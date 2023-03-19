package employeesubscriber;

public interface EmployeeSubscriber {
	 void RegisterEmployee();
	    void updateEmployee();
	    void getAllEmployees();
	    void getEmployeeById();
	    void getEmployeesByJobTitle();
	    void getAvailableEmployees();
	    void assignShift();
	    void requestLeave();
	    void getAllLeaveRequests();
	    void removeEmployee();
}
