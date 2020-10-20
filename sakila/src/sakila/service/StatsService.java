package sakila.service;

import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	public void addStats() {
		System.out.println("debug: method-begin: StatsService.addStats()");
		
		// 리스너에서 Class.forName()을 이미 호출하여 JDBC를 로드했으므로 따로 적을 필요는 없음
		Connection conn = null;
		
		final String DB_URL = "jdbc:mariadb://localhost:3306/sakila";
		final String DB_USER = "root";
		final String DB_PASSWORD = "java1004";
		System.out.println("debug: instance-variable: DB_URL="+DB_URL);
		System.out.println("debug: instance-variable: DB_USER="+DB_USER);
		System.out.println("debug: instance-variable: DB_PASSWORD="+DB_PASSWORD);
		
		try {
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			// 트랜잭션이 처리될 경우를 대비해, 자동 커밋을 하지 않고, try문의 끝에서 수동으로 commit을 넣음
			conn.setAutoCommit(false);
			System.out.println("debug: message: 'connected successfully: DB'");
			
			// TODO: 채워넣기
			StatsDao statsDao = new StatsDao();
			
			Calendar today = Calendar.getInstance(); // 현재 날짜를 Calendar 객체로 가져와서 today 변수에 넣고
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // yyyy-MM-dd 포맷 형식을 만든 다음
			String formattedDate = dateFormat.format(today.getTime()); // today 변수를 yyyy-MM-dd 포맷으로 변환해서 String에 집어넣음
			System.out.println("debug: instance-variable: formattedDate="+formattedDate);
			
			// 현재 날짜를 이용해 statsDao에 전달할 파라미터 객체를 만든 뒤
			Stats paramStats = new Stats();
			paramStats.setDay(formattedDate);
			System.out.println("debug: instance-variable: paramStats="+paramStats);
			// 현재 날짜에 대한 방문자 수 정보를 가져옴
			Stats todayStats = statsDao.selectStatsOne(conn, paramStats);
			System.out.println("debug: instance-variable: todayStats="+todayStats);
			
			if (todayStats != null) {
				// 오늘 날짜에 방문자가 이미 있다면 기존 방문자 수에 +1을 함
				statsDao.updateStatsPlusOne(conn, todayStats);
			} else {
				// 오늘 날짜의 첫 방문자면 오늘 날짜로 테이블의 행을 만들고, 1을 집어넣음
				statsDao.insertStatsCountOne(conn, paramStats);
			}
			
			conn.commit();
		} catch (Exception e) { // DB 연결 혹은 쿼리 작업 중 예외 발생 시
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (Exception e2) { // 롤백 실패 시
				e2.printStackTrace();
			}
		} finally { // 어쩌나 저쩌나 작업이 중도 실패됐든 작업이 정상 종료 되었든간에 conn.close()로 자원 수동 반환
			try {
				conn.close();
			} catch (Exception e) { // conn.close() 실패 시
				e.printStackTrace();
			}
		}
		
		System.out.println("debug: method-end: StatsService.addStats()");
	}
}
