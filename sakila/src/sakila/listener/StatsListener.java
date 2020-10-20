package sakila.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import sakila.service.StatsService;

@WebListener
public class StatsListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("debug: method-begin: StatsListener.sessionCreated()");
		
		// 기존 세션의 재활용일수도 있으므로, 새로 만들어진 세션인지 다시 한번 검증
		if (event.getSession().isNew()) {
			System.out.println("debug: message: 'New session created'");
			
			// 오늘의 방문자 수를 1 증가시키는 서비스 실행(오늘의 첫 방문자면 방문자 수를 1로 초기화)
			StatsService statsService = new StatsService();
			statsService.addStats();
		}
		
		System.out.println("debug: method-end: StatsListener.sessionCreated()");
	}
	
	public void sessionDestroyed(HttpSessionEvent event) {
		// TODO Auto-generated method stub
	}
}
