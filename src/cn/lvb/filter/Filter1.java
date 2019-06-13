package cn.lvb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter1 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String encodingValue="UTF-8";
		//if(encodingValue==null)//如果没有配置该参数
	//		encodingValue="UTF-8";//给定默认值UTF-8
		request.setCharacterEncoding(encodingValue);//只对POST请求方式有用
		response.setContentType("text/html;charset="+encodingValue);
		
		
		
		String url = req.getRequestURI();

		System.out.println("Filter1拦截前:"+url);
		chain.doFilter(request, response);
		System.out.println("Filter1拦截后:"+url);
		System.out.println("-------------------------------");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
