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

import cn.ssx.Class.TuihuoRecord;
import cn.ssx.DAO.TuihuoRecord_interface;
import cn.ssx.Impl.Tuihuo_DAO_Impl;

/**
 * Servlet implementation class TuihuoServlet
 */
@WebServlet("/TuihuoServlet")
public class TuihuoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TuihuoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		TuihuoRecord_interface dao=new Tuihuo_DAO_Impl();
		HttpSession session = request.getSession();
		try {
			List<TuihuoRecord> list = dao.Tuihuo_Findall();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("Tuihuolist", list);
			/*
			 * for(Product p:list) { System.out.println(p.getProduct_storedate()); }
			 */
			response.setHeader("Refresh", "0; http://localhost:8080/Second/Tuihuo.jsp" );
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
