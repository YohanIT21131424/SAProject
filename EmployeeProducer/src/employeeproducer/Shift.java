package employeeproducer;

import java.sql.Date;

public class Shift {

	private Employee employee;
	private Date startTime;
	private Date endTime;

	public Shift(Employee employee, Date startTime, Date endTime) {
		this.employee = employee;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean overlaps(Date startTime, Date endTime) {
		return (startTime.before(this.endTime) && startTime.after(this.endTime))
				|| (startTime.equals(this.endTime) || endTime.equals(this.endTime));
	}

}
