package data.action;

import com.opensymphony.xwork2.ActionSupport;

import data.model.Employee;
import data.service.EmployeeService;
import data.service.TaxService;

public class CalculateTaxAction extends ActionSupport {
	private static final long serialVersionUID = 7299264265184515893L;

	private String staffNumber;
	private int year;
	private int grossSalary;

	@Override
	public String execute() {

		TaxService taxService = new TaxService();
		EmployeeService employeeService = new EmployeeService();
		int taxDue = 0;
		int netSalary = 0;

		System.out.println("-Year: " + year);
		System.out.println("Gross Salary: " + grossSalary);
		System.out.println("Net Salary: " + netSalary);
		System.out.println("Tax Due: " + taxDue);
		
		if (year > 2022 || year < 2019) {
			addActionError("Year should be between 2019-2022");
			return "error";
		}

		Employee emp = null;
		try {
			emp = employeeService.getEmployeeFromStaffNumber(this.staffNumber);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		if (emp == null) {
			addActionError("Employee with staff number " + this.staffNumber + " not found");
			return "error";
		}
		System.out.println(emp.toString());

		int balance = 0;
		if (year == 2022) {
			balance = grossSalary - 36800;

			if (grossSalary > 36800) {
				taxDue = (int) (36800 * 0.2);
			} else {
				taxDue = (int) (grossSalary * 0.2);
			}

			System.out.println("--Year: " + year);
			System.out.println("Gross Salary: " + grossSalary);
			System.out.println("Net Salary: " + netSalary);
			System.out.println("Tax Due: " + taxDue);

			if (balance > 0)
				taxDue += (int) (balance * 0.4);

			System.out.println("---Year: " + year);
			System.out.println("Gross Salary: " + grossSalary);
			System.out.println("Net Salary: " + netSalary);
			System.out.println("Tax Due: " + taxDue);

		} else {
			balance = grossSalary - 35300;

			if (grossSalary > 35300) {
				taxDue = (int) (35300 * 0.2);
			} else {
				taxDue = (int) (grossSalary * 0.2);
			}

			System.out.println("==Year: " + year);
			System.out.println("Gross Salary: " + grossSalary);
			System.out.println("Net Salary: " + netSalary);
			System.out.println("Tax Due: " + taxDue);

			if (balance > 0)
				taxDue += (int) (balance * 0.4);

			System.out.println("===Year: " + year);
			System.out.println("Gross Salary: " + grossSalary);
			System.out.println("Net Salary: " + netSalary);
			System.out.println("Tax Due: " + taxDue);
		}

		netSalary = grossSalary - taxDue;

		System.out.println("+++Year: " + year);
		System.out.println("Gross Salary: " + grossSalary);
		System.out.println("Net Salary: " + netSalary);
		System.out.println("Tax Due: " + taxDue);

		try {
			taxService.addRecord(staffNumber, year, grossSalary, taxDue, netSalary);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return "success";
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(int grossSalary) {
		this.grossSalary = grossSalary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}