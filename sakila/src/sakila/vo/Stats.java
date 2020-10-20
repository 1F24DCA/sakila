package sakila.vo;

// 날짜별 유저 접속 카운트를 세어주는 DB, Stats
// Stats 테이블의 데이터를 각 객체에 전달할 때 사용되는 Value object
public class Stats {
	private String day;
	private long cnt;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public long getCnt() {
		return cnt;
	}
	public void setCnt(long count) {
		this.cnt = count;
	}
	
	@Override
	public String toString() {
		return "Stats [day=" + day + ", count=" + cnt + "]";
	}
}
