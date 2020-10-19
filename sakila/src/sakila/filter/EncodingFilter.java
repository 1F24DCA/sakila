package sakila.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// 들어오는 모든 요청에 대해서 request의 캐릭터 인코딩을 UTF-8로 설정함
@WebFilter("/*")
public class EncodingFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("debug: method-begin: EncodingFilter.doFilter()");
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("debug: ServletRequest.characterEncoding="+request.getCharacterEncoding());
		
		chain.doFilter(request, response);
		
		System.out.println("debug: method-end: EncodingFilter.doFilter()");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
