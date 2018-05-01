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
 * Servlet implementation class SearchMedicineServlet
 */
@WebServlet("/getMedicineList")
public class SearchMedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tradename = request.getParameter("description");
		DiagnoseService ds = new DiagnoseService();
		List<Medicine> mList = null;
		try {
			mList = ds.getMedicineInfoByTradeName(tradename);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("mList", mList);
		request.getRequestDispatcher("/showSearchMedicineDetail.jsp").forward(request, response);
	}

}
