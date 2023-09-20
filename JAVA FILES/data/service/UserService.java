package data.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.model.User;
import data.util.DatabaseConnection;

public class UserService {

	public int addAdmin(String name, String password, String staffNumber) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO `user`(name,password,staff_number,user_role) VALUES (?,?,?,?)";
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, staffNumber);
			ps.setString(4, "admin");
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
	}

	public int addUser(String name, String password, String staffNumber) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO `user`(name,password,staff_number,user_role) VALUES (?,?,?,?)";
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, staffNumber);
			ps.setString(4, "user");
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
	
	public User getUser(String email, String password, String staffNumber) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * from user where name = '" + email + "' AND password = '" + password + "' AND staff_number = '"+staffNumber+"';";
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
