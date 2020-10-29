package sakila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.*;
import sakila.vo.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StatsService statsService;
	private StaffService staffService;
	
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
		Map<String, Object> map = statsService.getStats();
		
		request.setAttribute("todayStats", map.get("todayStats"));
		request.setAttribute("totalCount", map.get("totalCount"));
		System.out.println("debug: request-attribute: todayStats="+request.getAttribute("todayStats"));
		System.out.println("debug: request-attribute: totalCount="+request.getAttribute("totalCount"));
		
		// 뷰로 포워딩
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
		System.out.println("debug: method-end: LoginServlet.doGet()");
	}
	
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debug: method-begin: LoginServlet.doPost()");
		System.out.println("debug: request-parameter: email="+request.getParameter("email"));
		System.out.println("debug: request-parameter: password="+request.getParameter("password"));
		
		Staff paramStaff = new Staff();
		paramStaff.setEmail(request.getParameter("email"));
		paramStaff.setPassword(request.getParameter("password"));
		
		staffService = new StaffService();
		Staff returnStaff = staffService.checkLoginInfo(paramStaff);
		if (returnStaff != null) {
			System.out.println("debug: message: 'Login successfully'");
			
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", returnStaff);

			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
		} else {
			System.out.println("debug: message: 'Login failed'");
			
			// TODO: 로그인 실패했다는 alert 창, 혹은 뭐든 띄웠으면 함
			response.sendRedirect(request.getContextPath()+"/LoginServlet");
		}
		
		System.out.println("debug: method-end: LoginServlet.doPost()");
	}
}
