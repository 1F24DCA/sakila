package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;

public class StaffDao {
	public Staff selectStaffByKey(Connection conn, Staff paramStaff) throws Exception {
		Staff returnStaff = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setString(1, paramStaff.getEmail());
		stmt.setString(2, paramStaff.getPassword());
		
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			returnStaff = new Staff();
			returnStaff.setStaffId(rs.getInt("staff_id"));
			returnStaff.setFirstName(rs.getString("first_name"));
			returnStaff.setLastName(rs.getString("last_name"));
			returnStaff.setAddressId(rs.getInt("address_id"));
			returnStaff.setPicture(rs.getString("picture"));
			returnStaff.setEmail(rs.getString("email"));
			returnStaff.setStoreId(rs.getInt("store_id"));
			returnStaff.setActive(rs.getInt("active"));
			returnStaff.setUsername(rs.getString("Username"));
		}
		
		return returnStaff;
	}
}
