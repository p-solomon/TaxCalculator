package data.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import data.model.EmployeeTax;
import data.model.User;
import data.service.EmployeeService;
import data.service.UserService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 7299264265184515893L;

	private String username;
	private String staffNumber;
	private String password;
	private String userRole;
	private List<EmployeeTax> employeeTaxList = new ArrayList<EmployeeTax>();

	@SuppressWarnings("unused")
	@Override
	public String execute() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		UserService userService = new UserService();
		User u = null;

		try {
			u = userService.getUser(this.username, this.password, this.staffNumber);
			System.out.println("dbUser: " + u.toString());
			System.out.println("formUser: " + this.userRole);
		} catch (SQLException e1) {
			e1.printStackTrace();
			addActionError("Invalid Login");
			return "error";
		} catch (Exception e1) {
			e1.printStackTrace();
			addActionError("Invalid Login");
			return "error";
		}

		if (u == null) {
			addActionError("Invalid Login");
			return "error";
		} else if (this.userRole.equals("1") && u.getUserRole().equals("admin")) {
			try {
				session.setAttribute("loggedInStaffNumber", u.getStaffNumber());
				return "adminDashboard";
			} catch (Exception e) {
				e.printStackTrace();
				addActionError("Invalid Login");
				return "error";
			}
		} else {
			if (this.userRole.equals("2") && u.getUserRole().equals("user")) {
				try {
					session.setAttribute("loggedInStaffNumber", u.getStaffNumber());

					EmployeeService employeeService = new EmployeeService();

					try {
						employeeTaxList = employeeService.getAllRecordsByStaffNumber(u.getStaffNumber());
					} catch (Exception e) {
						System.err.println(e.getMessage());

					}

					return "employeeDashboard";
				} catch (Exception e) {
					e.printStackTrace();
					addActionError("Invalid Login");
					return "error";
				}
			} else {
				addActionError("Invalid Login");
				return "error";
			}
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<EmployeeTax> getEmployeeTaxList() {
		return employeeTaxList;
	}

	public void setEmployeeTaxList(List<EmployeeTax> employeeTaxList) {
		this.employeeTaxList = employeeTaxList;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

}