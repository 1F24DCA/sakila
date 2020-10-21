package sakila.query;

public class StaffQuery {
	public final static String SELECT_STAFF_BY_KEY = "SELECT staff.staff_id, staff.username FROM staff WHERE staff.staff_id = ? AND staff.password = PASSWORD(?)";
}
