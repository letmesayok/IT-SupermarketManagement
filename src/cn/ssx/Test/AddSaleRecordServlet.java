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

import cn.ssx.Class.Administrator;
import cn.ssx.Class.Product;
import cn.ssx.Class.SaleRecord;
import cn.ssx.DAO.Administrator_interface;
import cn.ssx.DAO.SaleRecord_interface;
import cn.ssx.Impl.Administrator_DAO_Impl;
import cn.ssx.Impl.SaleRecord_DAO_Impl;

/**
 * Servlet implementation class AddSaleRecordServlet
 */
@WebServlet("/AddSaleRecordServlet")
public class AddSaleRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSaleRecordServlet() {
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
		    String Sale_Administrator =request.getParameter("Sale_Administrator");
			String Sale_Productname = request.getParameter("Sale_Productname");
			String	Sale_Productprice = request.getParameter("Sale_Productprice");
			String Sale_date = request.getParameter("Sale_date")+"  ";
			String Sale_Productnumber = request.getParameter("Sale_Productnumber");
			float price= Float.parseFloat(Sale_Productprice);
			int number = Integer.parseInt(Sale_Productnumber);
			price = number*price;
			String Sale_Profit = String.valueOf(price);
			SaleRecord SaleRecord  = new SaleRecord();
			SaleRecord.setSale_Administrator(Sale_Administrator);
			SaleRecord.setSale_Productname(Sale_Productname);
			SaleRecord.setSale_Productprice(Sale_Productprice);
			SaleRecord.setSale_date(Sale_date);
			SaleRecord.setSale_Productnumber(Sale_Productnumber);
			SaleRecord.setSale_Profit(Sale_Profit);
			SaleRecord_interface dao = new SaleRecord_DAO_Impl();
			Administrator_interface dao1= new Administrator_DAO_Impl();
			 HttpSession session = request.getSession();
			  try {
				List<Administrator> list= dao1.Administrator_FindAll();
				response.setContentType("text/html; charset=utf-8");
				session.setAttribute("Administratorlist", list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dao.SaleRecord_Insert(SaleRecord);
			
				response.setContentType("text/html; charset=utf-8");
				request.setCharacterEncoding("utf-8");
				PrintWriter pw=response.getWriter();
				pw.write("<script language='javascript'>alert('Ìí¼Ó³É¹¦')</script>"); 
				response.setHeader("Refresh", "0; URL = http://localhost:8080/Second/AddSaleRecord.jsp" );
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
