package example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author cliffside
 * @date 2021-04-29 10:42
 */
//所以资源都进行过滤
@WebFilter(urlPatterns = "/*")
public class MyFilter3 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if (requestURI.contains("login.html")
                ||requestURI.contains("loginController.action")){
            filterChain.doFilter(request,servletResponse);
            return;
        }

        HttpSession session = request.getSession();
        if (session.getAttribute("user")!= null){
            filterChain.doFilter(request,servletResponse);
        }else {
            HttpServletResponse response= (HttpServletResponse) servletResponse;
            response.sendRedirect("login.html");
        }

    }

    @Override
    public void destroy() {

    }
}
