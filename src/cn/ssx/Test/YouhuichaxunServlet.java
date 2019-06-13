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
import cn.ssx.DAO.SaleRecord_interface;
import cn.ssx.Impl.SaleRecord_DAO_Impl;

/**
 * Servlet implementation class YouhuichaxunServlet
 */
@WebServlet("/YouhuichaxunServlet")
public class YouhuichaxunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YouhuichaxunServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		SaleRecord_interface dao = new SaleRecord_DAO_Impl();
		try {
			List<Product> list = dao.Youhui_Findall();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("Youhuilist", list);
			/*
			 * for(Product p:list) { System.out.println(p.getProduct_storedate()); }
			 */
			response.setHeader("Refresh", "0; http://localhost:8080/Second/Youhui.jsp" );
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
