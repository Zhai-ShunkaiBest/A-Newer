package example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author cliffside
 * @date 2021-04-29 9:57
 */
@WebFilter(urlPatterns = "/servlet1.action",initParams = {@WebInitParam(name="realname",value ="zhangsan"),@WebInitParam(name="charset",value ="utf-8")})
public class MyFilter2 implements Filter {
    private String charset ;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       charset = filterConfig.getInitParameter("charset");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(charset);
        System.out.println("MyFilter2   在过滤请求 ");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("MyFilter2   在过滤响应");
    }
    @Override
    public void destroy() {
    }
}
