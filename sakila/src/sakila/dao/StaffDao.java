package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	public Staff selectStaffByKey(Connection conn, Staff paramStaff) throws Exception {
		Staff returnStaff = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setInt(1, paramStaff.getStaffId());
		stmt.setString(2, paramStaff.getPassword());
		
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			returnStaff = new Staff();
			returnStaff.setStaffId(rs.getInt("staff.staff_id"));
			returnStaff.setUsername(rs.getString("staff.username"));
		}
		
		return returnStaff;
	}
}
