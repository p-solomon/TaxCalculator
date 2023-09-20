package data.action;

import com.opensymphony.xwork2.ActionSupport;

import data.service.EmployeeService;

public class EmployeeRemoveAction extends ActionSupport {
	private static final long serialVersionUID = 7299264265184515893L;

	private int staffNumbertoremove;

	@Override
	public String execute() {

		EmployeeService employeeService = new EmployeeService();
		try {
			int i = employeeService.removeEmployeeByStaffNumber(staffNumbertoremove);
			if (i <= 0) {
				addActionError("Employee Not Found");
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Employee Not Found");
			return "error";
		}
		return "success";
	}

	public int getStaffNumbertoremove() {
		return staffNumbertoremove;
	}

	public void setStaffNumbertoremove(int staffNumbertoremove) {
		this.staffNumbertoremove = staffNumbertoremove;
	}

}
