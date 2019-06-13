package cn.lvb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class BBSFilter
 */
public class BBSFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BBSFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;	
		BBSHttpServletRequest breq = new BBSHttpServletRequest(req);
		chain.doFilter(breq, resp);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}


class BBSHttpServletRequest extends HttpServletRequestWrapper
{
	private String words[] = {"傻B","畜生","禽兽"};
	
	public BBSHttpServletRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null)
			return "没有";
		for(String dword:words){
			if(value.contains(dword)){//判断用户输入的内容中包含脏话
				value = value.replace(dword, "**");
			}
		}
		return value;
	}
	
}



class HtmlHttpServletRequest extends HttpServletRequestWrapper{
	public HtmlHttpServletRequest(HttpServletRequest request){
		super(request);
	}

	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		if(value==null)
			return value;
		value = htmlFilter(value);//完成标记过滤
		return value;
	}

	private String htmlFilter(String message) {
		if (message == null)
            return (null);
        char content[] = new char[message.length()];
        message.getChars(0, message.length(), content, 0);
        StringBuffer result = new StringBuffer(content.length + 50);
        for (int i = 0; i < content.length; i++) {
            switch (content[i]) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '"':
                result.append("&quot;");
                break;
            default:
                result.append(content[i]);
            }
        }
        return (result.toString());
	}
	
}



