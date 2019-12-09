package employee_mvc;

public class Emp {

	private int empno;
	private String deptid;
	private int salary;

	public Emp() {

	}

	public Emp(int empno, String deptid, int salary) {
		this.empno = empno;
		this.deptid = deptid;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", deptid=" + deptid + ", salary=" + salary + "]";
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}

