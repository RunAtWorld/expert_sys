package expert_sys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expert_sys.dao.Illness;
import expert_sys.dao.Priscription;
import expert_sys.service.DiagnoseService;

/**
 * Servlet implementation class GoDetailPrescription_en
 */
@WebServlet("/goDetailPrescription_en")
public class DetailPrescription_enServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailPrescription_enServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String illID = request.getParameter("illID");
		int illId = 0;
		if(illID!=null && !illID.equals("")){
			illId = Integer.parseInt(illID);
		}
		DiagnoseService ds =  new DiagnoseService();
		List<Priscription> mList = null;
		try {
			Illness ill = new Illness(illId,"","","",0);
			mList = ds.getPrescriptionByIllness(ill);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("mList", mList);
		request.getRequestDispatcher("/showMedicineDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
