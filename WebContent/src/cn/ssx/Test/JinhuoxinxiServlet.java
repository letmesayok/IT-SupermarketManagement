package cn.ssx.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ssx.Class.Administrator;
import cn.ssx.Class.Product;
import cn.ssx.DAO.Administrator_interface;
import cn.ssx.DAO.Product_interface;
import cn.ssx.Impl.Administrator_DAO_Impl;
import cn.ssx.Impl.Product_DAO_Impl;

/**
 * Servlet implementation class JinhuoxinxiServlet
 */
@WebServlet("/JinhuoxinxiServlet")
public class JinhuoxinxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JinhuoxinxiServlet() {
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
	    //response.setCharacterEncoding("utf-8");

	    String Administrator_store =request.getParameter("selector1");
		String Product_name = request.getParameter("Product_name");
		String	Product_price = request.getParameter("Product_price");
		String Product_storedate = request.getParameter("Product_storedate");
		String Storenumber = request.getParameter("Storenumber");
	    Product Product = new Product();/******重要的地方说两遍*****/
	    Product.setAdministrator_store(Administrator_store);
	    Product.setProduct_name(Product_name);;
		Product.setProduct_storedate(Product_storedate); 
		Product.setStorenumber(Storenumber);
		Product.setProduct_price(Product_price);
		int product_number = Integer.parseInt(Storenumber);
		//System.out.println(product_number);
		Product.setProduct_number(product_number);
		//out.println(Product.getProduct_name());
		//(Administrator_store,Product_name,Product_price,Product_storedate,Product_prenumber,Storenumber,Product_honumber
		Product_interface dao = new Product_DAO_Impl();
		try {
			dao.Product_Delete(Product_name);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(Product!=null) {
			try {
				 response.setContentType("text/html; charset=utf-8");
			     request.setCharacterEncoding("utf-8");
				 dao.Proudct_Insert(Product);
				 response.setContentType("text/html; charset=utf-8");
				 //out.println("商品信息已经成功录入到库存表和进货表中");
				 response.setHeader("Refresh", "0; URL = http://localhost:8080/Second/AddProduct.jsp" );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
