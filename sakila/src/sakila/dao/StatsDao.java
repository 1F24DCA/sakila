package sakila.dao;

import java.util.*;
import java.sql.*;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	// stats.getDay()를 사용해 그 날에 접속자가 있었는지 없었는지 판별하는 메서드
	// 있으면 날짜와 그 날의 접속자 수를 Stats VO로 반환하며, 없으면 null을 반환함
	public Stats selectStatsOne(Connection conn, Stats paramStats) throws Exception {
		System.out.println("debug: method-begin: StatsDao.selectStatsOne()");
		System.out.println("debug: method-parameter: paramStats="+paramStats);
		
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_STATS_ONE);
		stmt.setString(1, paramStats.getDay());
		
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
	
	public void insertStats(Connection conn, Stats paramStats) throws Exception {
		System.out.println("debug: method-begin: StatsDao.insertStats()");
		System.out.println("debug: method-parameter: paramStats="+paramStats);
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1, paramStats.getDay());
		stmt.setLong(2, paramStats.getCount());
		
		int updatedRow = stmt.executeUpdate();
		System.out.println("debug: instance-variable: updatedRow="+updatedRow);

		System.out.println("debug: method-end: StatsDao.insertStats()");
	}
	
	public void updateStatsPlusOne(Connection conn, Stats paramStats) throws Exception {
		System.out.println("debug: method-begin: StatsDao.insertStats()");
		System.out.println("debug: method-parameter: paramStats="+paramStats);
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS_PLUS_ONE);
		stmt.setString(1, paramStats.getDay());
		
		int updatedRow = stmt.executeUpdate();
		System.out.println("debug: instance-variable: updatedRow="+updatedRow);
		
		System.out.println("debug: method-end: StatsDao.insertStats()");
	}
}
