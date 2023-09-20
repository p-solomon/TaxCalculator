package data.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.model.Employee;
import data.model.EmployeeTax;
import data.util.DatabaseConnection;

public class EmployeeService {

	public int addEmployee(String name, String staffNumber, String ppsNumber) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO `employee`(name,staff_number,pps_number) VALUES (?,?,?)";
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, staffNumber);
			ps.setString(3, ppsNumber);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
	}

	public ArrayList<EmployeeTax> getAllRecords() throws SQLException, Exception {
		ResultSet rs = null;
		ArrayList<EmployeeTax> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM assignment3.employee_tax\r\n"
					+ "inner join employee on \r\n"
					+ "employee.staff_number = employee_tax.staff_number;";
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new EmployeeTax(rs.getInt("id"), rs.getString("staff_number"), rs.getInt("year"),
						rs.getInt("gross_salary"), rs.getInt("tax_due"), rs.getInt("net_salary"), rs.getString("name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<EmployeeTax> getAllRecordsByStaffNumber(String staffNumber) throws SQLException, Exception {
		ResultSet rs = null;
		ArrayList<EmployeeTax> list = new ArrayList<>();
		try {
			String sql = "SELECT * from employee_tax where staff_number =" + staffNumber;
			System.out.println(sql);
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new EmployeeTax(rs.getInt("id"), rs.getString("staff_number"), rs.getInt("year"),
						rs.getInt("gross_salary"), rs.getInt("tax_due"), rs.getInt("net_salary")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int removeEmployeeByStaffNumber(int staffNumber) throws SQLException, Exception {
		int i = 0;
		try {
			String sql = "DELETE from employee_tax where staff_number = " + staffNumber;
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.executeUpdate();

			sql = "DELETE from employee where staff_number = " + staffNumber;
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			i = ps.executeUpdate();

			sql = "DELETE from user where staff_number = " + staffNumber;
			ps = DatabaseConnection.getConnection().prepareStatement(sql);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public Integer getSumOfYear(int year) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "select sum(tax_due) as sumOfYear from employee_tax where `year` = " + year;
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next())
				return rs.getInt("sumOfYear");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Employee getEmployeeFromStaffNumber(String staffNumber) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "select * from employee where staff_number = '" + staffNumber + "';";
			PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("staff_number"),
						rs.getString("pps_number"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
