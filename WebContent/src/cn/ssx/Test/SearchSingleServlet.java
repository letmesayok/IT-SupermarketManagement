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

import cn.ssx.Class.Product;
import cn.ssx.DAO.Product_interface;
import cn.ssx.Impl.Product_DAO_Impl;

/**
 * Servlet implementation class SearchSingleServlet
 */
@WebServlet("/SearchSingleServlet")
public class SearchSingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSingleServlet() {
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
	    PrintWriter out = response.getWriter();
	    String Product_name = request.getParameter("search");
		//PrintWriter out=response.getWriter();
	    Product_interface dao = new Product_DAO_Impl();
		//out.println(Product_name);
		HttpSession session = request.getSession();
		try {
			//out.println("222222222");
			Product list = dao.Product_FindSingle(Product_name);
			if(list==null) {
				out.println("该商品不存在，请重新输入");
				test(request, response);
			}
			else {
			
			//out.println("1111");
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("singleProductlist", list);
			response.setHeader("Refresh", "0; http://localhost:8080/Second/Single.jsp" );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html; charset=utf-8");
	}
	protected void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		//out.println("1111");
		Product_interface dao = new Product_DAO_Impl();
		HttpSession session = request.getSession();
		//out.println("1111");
		try {
			List <Product> list  = dao.Product_Findall();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("Productlist", list);
			response.setHeader("Refresh", "0; http://localhost:8080/Second/FindAll.jsp" );
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
