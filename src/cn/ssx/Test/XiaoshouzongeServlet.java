package cn.ssx.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ssx.Class.Product;
import cn.ssx.Class.SaleRecord;
import cn.ssx.DAO.Product_interface;
import cn.ssx.DAO.SaleRecord_interface;
import cn.ssx.Impl.Product_DAO_Impl;
import cn.ssx.Impl.SaleRecord_DAO_Impl;

/**
 * Servlet implementation class XiaoshouzongeServlet
 */
@WebServlet("/XiaoshouzongeServlet")
public class XiaoshouzongeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XiaoshouzongeServlet() {
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
		  double sum1=0,sum2=0;
		  Product_interface dao1 = new Product_DAO_Impl();
		  HttpSession session = request.getSession();
		  DecimalFormat df = new DecimalFormat( "0.00");
		  try {
			List<Product> list1= dao1.Product_Findall();
			for(Product p:list1) { 
				   double num1 = Double.parseDouble(p.getProduct_price());
				   double num2 = p.getProduct_number();
				   sum1+=num1*num2;
				   //System.out.println(sum1);
				  }
			
			//response.setContentType("text/html; charset=utf-8");
			session.setAttribute("sum1", df.format(sum1));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		  SaleRecord_interface dao2 = new SaleRecord_DAO_Impl();
		  try {
			List <SaleRecord> list2 = dao2.SaleRecord_Findall();
			response.setContentType("text/html; charset=utf-8");
			for(SaleRecord p:list2) { 
				  double num1= Double.parseDouble(p.getSale_Profit());
				  sum2  += num1;
		//		  System.out.println(sum2);
				  }
			session.setAttribute("sum2", df.format(sum2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	    double sum3 = sum2*0.2; 
	    session.setAttribute("sum3", df.format(sum3));
	    double sum4 = sum2-sum1-sum3;
	    session.setAttribute("sum4", df.format(sum4));
	  response.setHeader("Refresh", "0; http://localhost:8080/Second/Xiaoshouzonge.jsp"); 
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
