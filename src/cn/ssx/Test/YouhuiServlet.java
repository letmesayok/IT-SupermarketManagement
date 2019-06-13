package cn.ssx.Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ssx.Class.Product;
import cn.ssx.DAO.Product_interface;
import cn.ssx.DAO.SaleRecord_interface;
import cn.ssx.Impl.Product_DAO_Impl;
import cn.ssx.Impl.SaleRecord_DAO_Impl;

/**
 * Servlet implementation class YouhuiServlet
 */
@WebServlet("/YouhuiServlet")
public class YouhuiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YouhuiServlet() {
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
		String  Product_name = request.getParameter("Product_name");
		String	Product_price = request.getParameter("Product_price");
		String	product_number = request.getParameter("Product_number");
		String	Product_storedate = request.getParameter("Product_storedate");
		Product product = new Product();
		product.setProduct_name(Product_name);
		product.setProduct_price(Product_price);
		int Product_number = Integer.parseInt(product_number);
		product.setProduct_number(Product_number);
		product.setProduct_storedate(Product_storedate);
		//out.println(Product_name);
		SaleRecord_interface dao = new SaleRecord_DAO_Impl();
		try {
			dao.insert(product);
			out.write("<script language='javascript'>alert('½µ¼Û³É¹¦')</script>"); 
			response.setHeader("Refresh", "0; http://localhost:8080/Second/Jinhuoshangpinxinxi.jsp" );
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
