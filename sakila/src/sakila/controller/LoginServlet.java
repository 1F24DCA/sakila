package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StatsService;
import sakila.vo.Stats;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StatsService statsService;
	
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debug: method-begin: LoginServlet.doGet()");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			
			return;
		}
		
		statsService = new StatsService();
		Stats todayStats = statsService.getStats();
		
		request.setAttribute("todayStats", todayStats);
		System.out.println("debug: request-attribute: todayStats="+request.getAttribute("todayStats"));
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
		System.out.println("debug: method-end: LoginServlet.doGet()");
	}
	
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debug: method-begin: LoginServlet.doPost()");

		System.out.println("debug: method-end: LoginServlet.doPost()");
	}
}
