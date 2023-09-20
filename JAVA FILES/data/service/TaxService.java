package data.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.model.User;
import data.util.DatabaseConnection;

public class TaxService {

	public int addRecord(String staffNumber, int year, int grossSalary, int taxDue, int netSalary) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO `employee_tax`(staff_number,year,gross_salary,tax_due,net_salary) VALUES (?,?,?,?,?)";
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, staffNumber);
			ps.setInt(2, year);
			ps.setInt(3, grossSalary);
			ps.setInt(4, taxDue);
			ps.setInt(5, netSalary);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
	}
	
	public User getUser(String email, String password) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * from user where name = '" + email + "' AND password = '" + password + "';";
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				User u = new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"),
						rs.getString("staff_number"), rs.getString("user_role"));
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
