package sakila.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent arg0)  {
		// TODO Auto-generated method stub
	}
	
	public void contextInitialized(ServletContextEvent arg0)  {
		System.out.println("debug: method-begin: DBListener.contextInitialized()");

		
		try {
			System.out.println("debug: message: 'loading org.mariadb.jdbc.Driver...'");
			Class.forName("org.mariadb.jdbc.Driver");
			
			System.out.println("debug: message: 'load successfully: org.mariadb.jdbc.Driver'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("debug: method-end: DBListener.contextInitialized()");
	}
}
