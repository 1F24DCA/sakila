package sakila.service;

import java.sql.*;

import sakila.dao.StaffDao;
import sakila.vo.Staff;
import sakila.util.DBUtil;

public class StaffService {
	private StaffDao staffDao;
	
	public Staff checkLoginInfo(Staff paramStaff) {
		staffDao = new StaffDao();

		Connection conn = null;
		Staff returnStaff = null;
		
		try {
			DBUtil dbUtil = new DBUtil();
			conn = dbUtil.getConnection();
			
			returnStaff = staffDao.selectStaffByKey(conn, paramStaff);
			
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return returnStaff;
	}
}
