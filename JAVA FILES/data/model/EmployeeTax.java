package data.model;

public class EmployeeTax {
	private int id;
	private String staffNumber;
	private int year;
	private int grossSalary;
	private int taxDue;
	private int netSalary;
	private String name;

	public EmployeeTax(int id, String staffNumber, int year, int grossSalary, int taxDue, int netSalary) {
		super();
		this.id = id;
		this.staffNumber = staffNumber;
		this.year = year;
		this.grossSalary = grossSalary;
		this.taxDue = taxDue;
		this.netSalary = netSalary;
	}

	public EmployeeTax(int id, String staffNumber, int year, int grossSalary, int taxDue, int netSalary, String name) {
		super();
		this.id = id;
		this.staffNumber = staffNumber;
		this.year = year;
		this.grossSalary = grossSalary;
		this.taxDue = taxDue;
		this.netSalary = netSalary;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getTaxDue() {
		return taxDue;
	}

	public void setTaxDue(int taxDue) {
		this.taxDue = taxDue;
	}

	public int getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(int netSalary) {
		this.netSalary = netSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmployeeTax [id=" + id + ", staffNumber=" + staffNumber + ", year=" + year + ", grossSalary="
				+ grossSalary + ", taxDue=" + taxDue + ", netSalary=" + netSalary + "]";
	}

}
