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
		
		// 로그인했다면 인덱스 페이지로 보냄
		HttpSession session = request.getSession();
		if (session.getAttribute("loginStaff") != null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			
			return;
		}
		
		// 오늘의 방문자 수와 총 방문자 수를 뷰로 보내기 위해 StatsService를 사용함
		statsService = new StatsService();
		Stats todayStats = statsService.getTodayStats();
		Stats totalStats = statsService.getTotalStats();
		
		request.setAttribute("todayStats", todayStats);
		request.setAttribute("totalStats", totalStats);
		System.out.println("debug: request-attribute: todayStats="+request.getAttribute("todayStats"));
		System.out.println("debug: request-attribute: totalStats="+request.getAttribute("totalStats"));
		
		// 뷰로 포워딩
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
		System.out.println("debug: method-end: LoginServlet.doGet()");
	}
	
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debug: method-begin: LoginServlet.doPost()");
		
		// TODO: 로그인 액션 구현
		
		System.out.println("debug: method-end: LoginServlet.doPost()");
	}
}
