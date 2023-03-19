package employeeproducer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	private List<Employee> employees;
	private Map<Integer, List<Shift>> shiftsMap;
	private List<LeaveRequest> leaveRequests;

	public EmployeeManagementServiceImpl() {
		this.employees = new ArrayList<>();
		this.shiftsMap = new HashMap<>();
		this.leaveRequests = new ArrayList<>();
	}

	@Override
	public void registerEmployee(int id, String name, String occupation, String email, String phone,
			List<Certification> certifications) {
		Employee employee = new Employee(id, name, occupation, email, phone, certifications);
		employees.add(employee);
	}

	@Override
	public boolean updateEmployee(int employeeId, String phone, String email) {
		Employee employee = getEmployeeById(employeeId);
		if (employee != null) {
			employee.setPhone(phone);
			employee.setEmail(email);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> getEmployees() {
		return employees;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {

		Employee emp = null;

		for (Employee employee : employees) {
			if (employee.getId() == employeeId) {
				emp = employee;
				break;
			}
		}

		if (emp != null) {
			return emp;
		} else {
			System.out.println("cannot find the employee!");
			return null;
		}

	}

	@Override
	public List<Employee> getEmployeesByJobTitle(String jobTitle) {
		List<Employee> empByJob = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getOccupation().equalsIgnoreCase(jobTitle)) {
				empByJob.add(employee);
			}
		}
		return empByJob;
	}

	@Override
	public List<Employee> getAvailableEmployees(Date startDate, Date endDate) {
	    List<Employee> availableEmployees = new ArrayList<>();
	    for (Employee employee : employees) {

	        List<Shift> employeeShifts = shiftsMap.get(employee.getId());

	        if (employeeShifts != null) {
	            boolean isAvailable = true;
	            for (Shift shift : employeeShifts) {
	                if (shift.getStartTime() == startDate && shift.getEndTime().compareTo(startDate) >= 0) {
	                    isAvailable = false;
	                    break;
	                }
	            }
	            if (isAvailable) {
	                availableEmployees.add(employee);
	            }
	        }
	    }
	    return availableEmployees;
	}

	@Override
	public void assignShift(int employeeId, Date startDate, Date endDate) {
		Employee employee = getEmployeeById(employeeId);
		if (employee == null) {
			throw new IllegalArgumentException("Invalid employee ID");
		}
		List<Shift> employeeShifts = shiftsMap.get(employeeId);
		if (employeeShifts == null) {
			employeeShifts = new ArrayList<>();
			shiftsMap.put(employeeId, employeeShifts);
		}
		Shift shift = new Shift(employee, startDate, endDate);
		employeeShifts.add(shift);
	}

	@Override
	public boolean requestLeave(int employeeId, Date startDate, Date endDate, String reason) {
		Employee employee = getEmployeeById(employeeId);
		if (employee == null) {
			System.out.println("Invalid employee ID");
			return false;
		} else {
			LeaveRequest request = new LeaveRequest(employee, startDate, endDate, reason);
			leaveRequests.add(request);

			return true;
		}
	}

	@Override
	public List<LeaveRequest> getLeaveRequests() {
		return leaveRequests;
	}

	@Override
	public boolean removeEmployee(int employeeId) {
		Employee employee = getEmployeeById(employeeId);
		if (employee == null) {
			return false;
		}

		shiftsMap.remove(employeeId);
		leaveRequests.removeIf(request -> request.getEmployee().getId() == employeeId);
		employees.remove(employee);

		return true;
	}

}
