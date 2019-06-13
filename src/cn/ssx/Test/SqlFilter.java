package cn.ssx.Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
//过滤sql关键字的Filter 
public class SqlFilter implements Filter {  
  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
  
        HttpServletRequest req = (HttpServletRequest) request;  
        HttpServletResponse res = (HttpServletResponse) response;   
        Enumeration params = req.getParameterNames();  
    	  PrintWriter out=response.getWriter();
    	  out.println("11111");
        String sql = "";  
        while (params.hasMoreElements()) {  
            //得到参数名  
            String name = params.nextElement().toString();  
            //System.out.println("name===========================" + name + "--");  
            //得到参数对应值  
            String[] value = req.getParameterValues(name);  
            for (int i = 0; i < value.length; i++) {  
                sql = sql + value[i];  
            }  
        }  
		/*
		 * System.out.println(sql); System.out.println("被匹配字符串："+sql);
		 */
        if (sqlValidate(sql)) {  
            res.sendRedirect("error.jsp");   
        } else {  
            chain.doFilter(req, res);  
        }  
    }  
  
    //校验
    protected static boolean sqlValidate(String str) {  
        str = str.toLowerCase();//统一转为小写
        //String badStr = "and|exec";
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|chr|mid|master|truncate|char|declare|sitename|net user|xp_cmdshell|or|like| |malaigebazi|shabi|caonima";  
        /*String badStr = "'|and|exec|execute|insert|create|drop|table|from|grant|use|group_concat|column_name|" +  
                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +  
                "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";    */    //过滤掉的sql关键字，可以手动添加  
        String[] badStrs = badStr.split("\\|");  
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) !=-1) { 
                System.out.println("匹配到："+badStrs[i]);
                return true;  
            }  
        }  
        return false;  
    }  
  
    public void init(FilterConfig filterConfig) throws ServletException {  
        //throw new UnsupportedOperationException("Not supported yet.");  
    }  
  
    public void destroy() {  
        //throw new UnsupportedOperationException("Not supported yet.");  
    }  
}