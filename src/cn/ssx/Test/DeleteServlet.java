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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		  //out.println("成功了");
		  String Product_name1 =null;
		  Product_name1= request.getParameter("selector1");
		  String Product_name2 =null;
		  Product_name2= request.getParameter("Product_name1");
		  String Product_name =null;
		  if(Product_name1==null) {
			   Product_name = Product_name2;
		  }
		  else {
			  Product_name = Product_name1;
		  }
		  response.setContentType("text/html; charset=utf-8");
		  //out.println(Product_name);
		  //out.println(request.getParameter("Product_name"));
		  Product_interface dao = new Product_DAO_Impl();
		  try {
			dao.Product_Delete(Product_name);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter pw=response.getWriter();
			pw.write("<script language='javascript'>alert('删除成功')</script>"); 
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
