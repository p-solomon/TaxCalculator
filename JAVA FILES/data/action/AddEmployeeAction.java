package data.action;

import com.opensymphony.xwork2.ActionSupport;

import data.model.Employee;
import data.service.EmployeeService;

public class AddEmployeeAction extends ActionSupport {
	private static final long serialVersionUID = 7299264265184515893L;

	private String name;
	private String staffNumber;
	private String ppsNumber;

	@Override
	public String execute() {

		EmployeeService employeeService = new EmployeeService();

		Employee temp;
		try {
			temp = employeeService.getEmployeeFromStaffNumber(staffNumber);

			if (temp != null) {
				addActionError("Employee with staff number " + staffNumber + " already exists");
				return "error";
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			employeeService.addEmployee(name, staffNumber, ppsNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public String getPpsNumber() {
		return ppsNumber;
	}

	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
