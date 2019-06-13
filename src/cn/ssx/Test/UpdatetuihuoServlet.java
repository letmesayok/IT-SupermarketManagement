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
 * Servlet implementation class UpdatetuihuoServlet
 */
@WebServlet("/UpdatetuihuoServlet")
public class UpdatetuihuoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatetuihuoServlet() {
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
		String Customer_Tel =request.getParameter("Customer_Tel");
	    String Product_name =request.getParameter("Product_name");
	    String Product_price =request.getParameter("Product_price");
	    String Product_number =request.getParameter("Product_number");
	    TuihuoRecord tuihuoRecord = new TuihuoRecord();
	    tuihuoRecord.setCustomer_Tel(Customer_Tel);
	    tuihuoRecord.setProduct_name(Product_name);
	    tuihuoRecord.setProduct_number(Product_number);
	    tuihuoRecord.setProduct_price(Product_price);
	    TuihuoRecord_interface dao = new Tuihuo_DAO_Impl();
	    HttpSession session = request.getSession();
	    try {
			dao.Tuihuo_Update(tuihuoRecord);
			out.write("<script language='javascript'>alert('ÐÞ¸Ä³É¹¦')</script>"); 
			List<TuihuoRecord> list =dao.Tuihuo_Findall();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("Tuihuolist", list);
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
