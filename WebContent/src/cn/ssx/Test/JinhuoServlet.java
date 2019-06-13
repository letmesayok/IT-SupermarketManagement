package cn.ssx.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ssx.Class.Product;
import cn.ssx.DAO.Product_interface;
import cn.ssx.Impl.Product_DAO_Impl;

/**
 * Servlet implementation class JinhuServlet
 */
@WebServlet("/JinhuoServlet")
public class JinhuoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JinhuoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Product_interface dao = new Product_DAO_Impl();
		HttpSession session = request.getSession();
		//out.println("1111");
		try {
			List <Product> list  = dao.Product_FindJinhuo();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("JinhuoProductlist", list);
			response.setHeader("Refresh", "0; http://localhost:8080/Second/Jinhuo.jsp" );
		} catch (Exception e) {
		
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
