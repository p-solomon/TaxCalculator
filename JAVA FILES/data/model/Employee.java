package data.model;

public class Employee {

	private int id;
	private String name;
	private String staffNumber;
	private int year;
	private int grossSalary;
	private int taxDue;
	private int netSalary;
	private String ppsNumber;

	public Employee(int id, String name, String staffNumber, String ppsNumber) {
		super();
		this.id = id;
		this.name = name;
		this.staffNumber = staffNumber;
		this.ppsNumber = ppsNumber;
	}

	public Employee(int id, String name, String staffNumber, int year, int grossSalary) {
		super();
		this.id = id;
		this.name = name;
		this.staffNumber = staffNumber;
		this.year = year;
		this.grossSalary = grossSalary;
	}

	public Employee(int id, String name, String staffNumber, int year, int grossSalary, int taxDue, int netSalary) {
		super();
		this.id = id;
		this.name = name;
		this.staffNumber = staffNumber;
		this.year = year;
		this.grossSalary = grossSalary;
		this.taxDue = taxDue;
		this.netSalary = netSalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPpsNumber() {
		return ppsNumber;
	}

	public void setPpsNumber(String ppsNumber) {
		this.ppsNumber = ppsNumber;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", staffNumber=" + staffNumber + ", year=" + year
				+ ", grossSalary=" + grossSalary + ", taxDue=" + taxDue + ", netSalary=" + netSalary + "]";
	}

}
