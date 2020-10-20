package sakila.query;

// Stats DAO에 사용되는 SQL문만 모아둔 메서드
// DB 관리만을 전문적으로 하는 인원이 DAO의 코드를 직접 건드리지 못하게끔, 패키지를 나눠서 작업함
public class StatsQuery {
	// 쿼리문은 실행 도중 변할 가능성이 없으므로 final, 변하지 않는 녀석을 매번 객체로 만들 필요가 없으므로 static으로 지정하여
	// ConcreteClass.VARIABLE로 호출 가능하게 설정함
	public static final String SELECT_STATS_ONE = "SELECT day, count FROM stats WHERE day = ?";
	public static final String SELECT_STATS_TOTAL = "SELECT SUM(count) FROM stats";
	public static final String INSERT_STATS_COUNT_ONE = "INSERT INTO stats(day, count) VALUES(?, 1)";
	public static final String UPDATE_STATS_PLUS_ONE = "UPDATE stats SET count = count+1 WHERE day = ?";
}
