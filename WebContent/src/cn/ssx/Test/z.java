package cn.ssx.Test;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.ssx.Class.Administrator;
import cn.ssx.DAO.Administrator_interface;
import cn.ssx.Impl.Administrator_DAO_Impl;
/**
 * Servlet implementation class z
 */
@WebServlet("/z")
public class z extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public z() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Administrator_interface dao1= new Administrator_DAO_Impl();
		 HttpSession session = request.getSession();
		  try {
			List<Administrator> list= dao1.Administrator_FindAll();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("Administratorlist", list);
			response.setHeader("Refresh", "0; http://localhost:8080/Second/AddSaleRecord.jsp" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
