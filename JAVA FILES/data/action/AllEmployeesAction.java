package data.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import data.model.EmployeeTax;
import data.service.EmployeeService;

public class AllEmployeesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8891321230498581915L;
	private List<EmployeeTax> employeeTaxList = new ArrayList<EmployeeTax>();

	@Override
	public String execute() {

		EmployeeService employeeService = new EmployeeService();

		try {
			employeeTaxList = employeeService.getAllRecords();
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}

		return "success";

	}

	public List<EmployeeTax> getEmployeeTaxList() {
		return employeeTaxList;
	}

	public void setEmployeeTaxList(List<EmployeeTax> employeeTaxList) {
		this.employeeTaxList = employeeTaxList;
	}

}
