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

import cn.ssx.Class.SaleRecord;
import cn.ssx.DAO.SaleRecord_interface;
import cn.ssx.Impl.SaleRecord_DAO_Impl;

/**
 * Servlet implementation class ShanchuSaleRecordServlet
 */
@WebServlet("/ShanchuSaleRecordServlet")
public class ShanchuSaleRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShanchuSaleRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		  PrintWriter out=response.getWriter();
		  String Sale_date1 =null;
		  Sale_date1= request.getParameter("Sale_date1");
		  HttpSession session = request.getSession();
		  response.setContentType("text/html; charset=utf-8");
		  SaleRecord_interface  dao = new SaleRecord_DAO_Impl();
		  try {
			dao.SaleRecord_Delete(Sale_date1);
			List<SaleRecord> list = dao.SaleRecord_Findall();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("Xiaoshoulist", list);
			response.setHeader("Refresh", "0; http://localhost:8080/Second/ShanchuXiugai.jsp" );
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
