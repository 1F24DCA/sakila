package sakila.query;

public class StaffQuery {
	public final static String SELECT_STAFF_BY_KEY = "SELECT staff_id, first_name, last_name, address_id, picture, email, store_id, active, username FROM staff WHERE staff.email = ? AND staff.password = PASSWORD(?)";
}
