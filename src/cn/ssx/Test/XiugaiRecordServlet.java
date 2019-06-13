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
 * Servlet implementation class XiugaiRecordServlet
 */
@WebServlet("/XiugaiRecordServlet")
public class XiugaiRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiugaiRecordServlet() {
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
		  String Sale_Administrator = request.getParameter("Sale_Administrator1");
		  String Sale_Productname = request.getParameter("Sale_Productname1");
		  String Sale_Productprice = request.getParameter("Sale_Productprice1");
		  String Sale_date = request.getParameter("Sale_date1");
		  String Sale_Productnumber = request.getParameter("Sale_Productnumber1");
		  String Sale_Profit = request.getParameter("Sale_Profit1");
		  SaleRecord saleRecord = new SaleRecord();
		  saleRecord.setSale_Administrator(Sale_Administrator);
		  saleRecord.setSale_Productname(Sale_Productname);
		  saleRecord.setSale_Productprice(Sale_Productprice);
		  saleRecord.setSale_date(Sale_date);
		  saleRecord.setSale_Productnumber(Sale_Productnumber);
		  saleRecord.setSale_Profit(Sale_Profit);
		  SaleRecord_interface dao = new SaleRecord_DAO_Impl();
		  HttpSession session = request.getSession();
		  try {
			dao.SaleRecord_Update(saleRecord);
			List<SaleRecord> list = dao.SaleRecord_Findall();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("Xiaoshoulist", list);
			response.setHeader("Refresh", "0; http://localhost:8080/Second/ShanchuXiugai.jsp" );
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
