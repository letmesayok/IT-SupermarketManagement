package cn.ssx.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		  out.println("1111");
		  String Product_name = request.getParameter("Product_name1");
		  String Product_price = request.getParameter("Product_price1");
		  String Product_storedate = request.getParameter("Product_storedate1");
		  String Product_number1 = request.getParameter("Product_number1");
		  int  Product_number= Integer.parseInt(Product_number1);
		  Product Product = new Product();/******重要的地方说两遍*****/
		  Product.setProduct_name(Product_name);;
	      Product.setProduct_storedate(Product_storedate); 
	      Product.setProduct_number(Product_number);
		  Product.setProduct_price(Product_price); 
		  //out.println(Product_name+' '+Product_price+' '+Product_storedate+' '+Product_number);
		  Product_interface dao = new Product_DAO_Impl();
		  try {
			dao.Product_Update(Product);
			/*
			 * System.out.println(Product.getProduct_storedate()+'
			 * '+Product.getProduct_price()+' '+Product.getProduct_number()+'
			 * '+Product.getProduct_name());
			 */
			//response.setHeader("Refresh", "0; http://localhost:8080/Second/main-page.jsp" );
			test1(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void test1(HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception {
		// TODO Auto-generated method stub
		Product_interface dao = new Product_DAO_Impl();
		HttpSession session = request.getSession();
		List <Product> list  = dao.Product_Findall();
		response.setContentType("text/html; charset=utf-8");
		session.setAttribute("Productlist", list);
		response.setHeader("Refresh", "0; http://localhost:8080/Second/Jinhuoshangpinxinxi.jsp" );
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
