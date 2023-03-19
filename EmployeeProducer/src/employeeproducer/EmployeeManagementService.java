package employeeproducer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeManagementService {
	void registerEmployee(int id, String name, String occupation, String email, String phone,
			List<Certification> certifications);

	boolean updateEmployee(int employeeId, String phone, String email);

	List<Employee> getEmployees();

	Employee getEmployeeById(int employeeId);

	List<Employee> getEmployeesByJobTitle(String jobTitle);

	List<Employee> getAvailableEmployees(Date startDate, Date endDate);

	void assignShift(int employeeId, Date startDate, Date endDate);

	boolean requestLeave(int employeeId, Date startDate, Date endDate, String reason);

	List<LeaveRequest> getLeaveRequests();

	boolean removeEmployee(int employeeId);
}
