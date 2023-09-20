package data.action;

import com.opensymphony.xwork2.ActionSupport;

import data.service.EmployeeService;

public class YearlyTaxAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4663390798172013668L;
	private int selectedYear;
	private int sumofSelectedYearTaxes;

	@Override
	public String execute() {

		EmployeeService employeeService = new EmployeeService();

		if (selectedYear > 2022 || selectedYear < 2019) {
			addActionError("Year should be between 2019-2022");
			return "error";
		}

		try {
			sumofSelectedYearTaxes = employeeService.getSumOfYear(selectedYear);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public int getSelectedYear() {
		return selectedYear;
	}

	public void setSelectedYear(int selectedYear) {
		this.selectedYear = selectedYear;
	}

	public int getSumofSelectedYearTaxes() {
		return sumofSelectedYearTaxes;
	}

	public void setSumofSelectedYearTaxes(int sumofSelectedYearTaxes) {
		this.sumofSelectedYearTaxes = sumofSelectedYearTaxes;
	}

}
