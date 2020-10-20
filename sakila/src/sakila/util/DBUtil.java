package sakila.util;

import java.sql.*;

public class DBUtil {
	// DB에 연결하는 메서드
	// 연결 실패 시 호출한 쪽으로 Exception을 던짐
	public Connection getConnection() throws Exception {
		System.out.println("debug: method-begin: DBUtil.getConnection()");
		
		final String DB_URL = "jdbc:mariadb://localhost:3306/sakila";
		final String DB_USER = "root";
		final String DB_PASSWORD = "java1004";
		System.out.println("debug: instance-variable: DB_URL="+DB_URL);
		System.out.println("debug: instance-variable: DB_USER="+DB_USER);
		System.out.println("debug: instance-variable: DB_PASSWORD="+DB_PASSWORD);

		System.out.println("debug: message: 'Connect DB...'");
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		// 트랜잭션이 처리될 경우를 대비해, 자동 커밋을 하지 않고, try문의 끝에서 수동으로 commit을 넣음
		conn.setAutoCommit(false);
		System.out.println("debug: message: 'Connect successfully: DB'");
		
		System.out.println("debug: method-end: DBUtil.getConnection()");
		return conn;
	}
}
