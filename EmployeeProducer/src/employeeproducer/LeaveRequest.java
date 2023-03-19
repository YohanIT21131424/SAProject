package employeeproducer;

import java.sql.Date;

public class LeaveRequest {
	private int id = 0;
	private Employee employee;
	private Date startDate;
	private Date endDate;
	private String reason;

	public LeaveRequest(Employee employee, Date startDate, Date endDate, String reason) {
		this.id = id++;
		this.employee = employee;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
