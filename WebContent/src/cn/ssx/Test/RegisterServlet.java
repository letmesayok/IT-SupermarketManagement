package cn.ssx.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.ssx.Class.Administrator;
import cn.ssx.DAO.Administrator_interface;
import cn.ssx.Impl.Administrator_DAO_Impl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	    request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		Administrator_interface dao = new Administrator_DAO_Impl();
		String Administrator_name = request.getParameter("username");
		String Administrator_password = request.getParameter("password");
		//out.println(Administrator_name+' '+Administrator_password+"-------");
		Administrator admin = new Administrator();
		Administrator_interface Admin = new Administrator_DAO_Impl();
		admin.setAdministrator_name(Administrator_name);
		admin.setAdministrator_password(Administrator_password);
		String name;
		int flag=1;
		 try {
			List<Administrator> list = Admin.Administrator_FindAll();
			for(Administrator aa: list) {
				if(aa.getAdministrator_name().equals(Administrator_name)) {
					flag=0;
					break;
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		//out.println(admin.Administrator_name+' '+admin.Administrator_password+"----");
		 if(flag==1) {
			 try {
				 dao.Administrator_Insert(admin);
				 PrintWriter pw=response.getWriter();
				 response.setContentType("text/html; charset=utf-8");
				  request.setCharacterEncoding("utf-8");
				 pw.write("<script language='javascript'>alert('注册成功')</script>"); 
				 response.setHeader("Refresh", "0; URL = http://localhost:8080/Second/Login.jsp" );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 }
		 else {
			 
			 PrintWriter pw=response.getWriter();
			 response.setContentType("text/html; charset=utf-8");
			    request.setCharacterEncoding("utf-8");
			 pw.write("<script language='javascript'>alert('该用户已存在，重新输入')</script>"); 
			 response.setHeader("Refresh", "0; URL = http://localhost:8080/Second/Register.jsp" );
		 }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
