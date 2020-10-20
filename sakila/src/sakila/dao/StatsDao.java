package sakila.dao;

import java.util.*;
import java.sql.*;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	// paramStats의 날짜를 받아와 그날에 접속자가 있었는지 없었는지 판별하는 메서드
	// 있으면 날짜와 그 날의 접속자 수를 Stats VO로 반환하며, 없으면 null을 반환함
	public Stats selectStatsOne(Connection conn, Stats paramStats) throws Exception {
		System.out.println("debug: method-begin: StatsDao.selectStatsOne()");
		System.out.println("debug: method-parameter: paramStats="+paramStats);
		
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_STATS_ONE);
		stmt.setString(1, paramStats.getDay());
		System.out.println("debug: instance-variable: stmt="+stmt);

		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCount(rs.getLong("count"));
		}
		System.out.println("debug: instance-variable: returnStats="+returnStats);
		
		System.out.println("debug: method-end: StatsDao.selectStatsOne()");
		return returnStats;
	}
	
	// paramStats로 받아온 날짜의 방문자 수를 1로 초기화시키는 메서드
	public void insertStatsCountOne(Connection conn, Stats paramStats) throws Exception {
		System.out.println("debug: method-begin: StatsDao.insertStats()");
		System.out.println("debug: method-parameter: paramStats="+paramStats);
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS_COUNT_ONE);
		stmt.setString(1, paramStats.getDay());
		System.out.println("debug: instance-variable: stmt="+stmt);
		
		int updatedRow = stmt.executeUpdate();
		System.out.println("debug: instance-variable: updatedRow="+updatedRow);

		System.out.println("debug: method-end: StatsDao.insertStats()");
	}
	
	// paramStats로 받아온 날짜의 방문자 수를 1 증가시키는 메서드
	public void updateStatsPlusOne(Connection conn, Stats paramStats) throws Exception {
		System.out.println("debug: method-begin: StatsDao.insertStats()");
		System.out.println("debug: method-parameter: paramStats="+paramStats);
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS_PLUS_ONE);
		stmt.setString(1, paramStats.getDay());
		System.out.println("debug: instance-variable: stmt="+stmt);
		
		int updatedRow = stmt.executeUpdate();
		System.out.println("debug: instance-variable: updatedRow="+updatedRow);
		
		System.out.println("debug: method-end: StatsDao.insertStats()");
	}
}
