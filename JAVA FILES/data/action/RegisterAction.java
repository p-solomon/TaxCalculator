package data.action;

import com.opensymphony.xwork2.ActionSupport;

import data.service.UserService;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 7299264265184515893L;

	private String staffNumber;
	private String username;
	private String password;
	private String userRole;

	@Override
	public String execute() {

		UserService userService = new UserService();

		if (this.userRole.equals("1")) {
			try {
				userService.addAdmin(this.username, this.password, this.staffNumber);
			} catch (Exception e) {
				e.printStackTrace();
				addActionError(e.getMessage());
				return "error";
			}
		} else {
			try {
				userService.addUser(this.username, this.password, this.staffNumber);
			} catch (Exception e) {
				e.printStackTrace();
				addActionError(e.getMessage());
				return "error";
			}
		}

		return "success";
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

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}
