package expert_sys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expert_sys.dao.Medicine;
import expert_sys.service.DiagnoseService;

/**
 * Servlet implementation class MedicineAllDetailServlet
 */
@WebServlet("/goMedicineAllDetail")
public class MedicineAllDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineAllDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String medicineSId = request.getParameter("medicineId");
		int medicineId = 0;
		if(medicineSId!=null && !medicineSId.equals("")){
			medicineId = Integer.parseInt(medicineSId);
		}
		DiagnoseService ds = new DiagnoseService();
		List<Medicine> medicine = null;
		try {
			medicine = ds.getMedicineInfoByMedicineId(medicineId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("medicine", medicine);
		request.getRequestDispatcher("/medicineAllDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
