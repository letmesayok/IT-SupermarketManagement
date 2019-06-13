package cn.ssx.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.ssx.Class.Administrator;
import cn.ssx.Class.Product;
import cn.ssx.DAO.Administrator_interface;
import cn.ssx.DAO.Product_interface;
import cn.ssx.Impl.Administrator_DAO_Impl;
import cn.ssx.Impl.Product_DAO_Impl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
         
        //获得所有请求参数名  
        Enumeration params = request.getParameterNames();  
        System.out.println(params.toString());
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String Administrator_name = request.getParameter("username");
		String Administrator_password = request.getParameter("password");
		Administrator_interface dao = new Administrator_DAO_Impl();
		Administrator admin = null;
	    //校验
		try {
			admin = dao.Findname(Administrator_name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 if(admin==null) {
			 
			 PrintWriter pw=response.getWriter();
			 response.setContentType("text/html; charset=utf-8");
			 request.setCharacterEncoding("utf-8");
			 pw.write("<script language='javascript'>alert('该用户不存在，正在为您跳转到注册界面')</script>"); 
			 response.setHeader("Refresh", "0; http://localhost:8080/Second/Register.jsp" );
		 }
		 else if(admin.getAdministrator_password().equals(Administrator_password )) {
			 
			 PrintWriter pw=response.getWriter();
			 response.setContentType("text/html; charset=utf-8");
			 request.setCharacterEncoding("utf-8");
			 pw.write("<script language='javascript'>alert('登陆成功，正在为您跳转到管理界面')</script>"); 
			 test1(request,response);
		 }
		 else {
			 PrintWriter pw=response.getWriter();
			 response.setContentType("text/html; charset=utf-8");
			    request.setCharacterEncoding("utf-8");
			 pw.write("<script language='javascript'>alert('密码错误，重新输入')</script>"); 
			 response.setHeader("Refresh", "0; URL = http://localhost:8080/Second/Login.jsp" );
		 }
		 
}
	protected void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Product_interface dao = new Product_DAO_Impl();
		HttpSession session = request.getSession();
		try {
			List <Product> list  = dao.Product_FindWarning();
			response.setContentType("text/html; charset=utf-8");
			session.setAttribute("WarningProductlist", list);
			response.setHeader("Refresh", "0; http://localhost:8080/Second/Index.jsp" );
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
