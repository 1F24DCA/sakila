package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/auth/*")
public class LoginFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("debug: method-begin: LoginFilter.doFilter()");
		
		// 받아온 요청이 HTTP 요청이라면
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			HttpServletResponse httpResponse = (HttpServletResponse)response;
				
			// 로그인했는지 물어보고, 로그인이 안되어있다면 로그인 페이지로 이동
			HttpSession session = httpRequest.getSession();
			if (session.getAttribute("loginStaff") == null) {
				httpResponse.sendRedirect(httpRequest.getContextPath()+"/LoginServlet");

				System.out.println("debug: method-end: LoginFilter.doFilter(), 'Login required'");
				return;
			}
		}
		
		chain.doFilter(request, response);
		
		System.out.println("debug: method-end: LoginFilter.doFilter()");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
