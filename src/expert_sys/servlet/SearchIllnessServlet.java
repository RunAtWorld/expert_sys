package expert_sys.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import expert_sys.dao.Diagnose;
import expert_sys.dao.Priscription;
import expert_sys.service.DiagnoseService;

/**
 * Servlet implementation class SearchIllnessServlet
 */
@WebServlet("/SearchIllnessServlet")
public class SearchIllnessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIllnessServlet() {
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
		String[] args = new String[1];
		request.setCharacterEncoding("utf-8");
		args[0] = request.getParameter("description");
		DiagnoseService ds =  new DiagnoseService();
		List<Diagnose> diagnosisList = null;
		try {
			diagnosisList = ds.getDiagnoseList(args);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error");
		}
		if(diagnosisList!=null)
			request.setAttribute("list", diagnosisList);
		System.out.println(diagnosisList);
//		List<List<Medicine>> LmList = new ArrayList<List<Medicine>>();
//		if(diagnosisList!=null)
//			for(int i=0;i<diagnosisList.size();i++){
//				try {
//					List<Medicine> mlist = ds.getPrescriptionByIllId(diagnosisList.get(i).getIllness().getId());
//					LmList.add(mlist);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
		List<List<Priscription>> LmList = new ArrayList<List<Priscription>>();
		if(diagnosisList!=null)
		for(int i=0;i<diagnosisList.size();i++){
			try {
				List<Priscription> mlist = ds.getPrescriptionByIllness(diagnosisList.get(i).getIllness());
				LmList.add(mlist);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("LmList", LmList);
		request.setAttribute("searchInfo", args);
		request.getSession().setAttribute("search", args);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
