package employeesubscriber;

import employeeproducer.Certification;
import employeeproducer.Employee;
import employeeproducer.EmployeeManagementService;
import employeeproducer.LeaveRequest;
import java.sql.Date;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class EmployeeServiceActivator implements BundleActivator, EmployeeSubscriber {

	private static BundleContext context;
	private ServiceReference employeeRef;
	private ServiceRegistration employeeReg;

	private EmployeeManagementService employeeService;

	Scanner sc = new Scanner(System.in);

	private int empId;
	private String name;
	private String occupation;
	private String email;
	private String phoneNum;
	private String sDate;
	private String eDate;
	private String reason;

	List<Certification> certificationList = new ArrayList<>();

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Starting Employee Service Subscriber...");

		employeeReg = context.registerService(this.getClass().getName(), this, null);

		employeeRef = context.getServiceReference(EmployeeManagementService.class.getName());

		employeeService = (EmployeeManagementService) context.getService(employeeRef);

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Thank you for using the service console.");
		context.ungetService(employeeRef);
	}

	// METHODS IMPLIMENTATION

	public void displayMenu() {
		int choice = 0;

		do {

			System.out.println("\n##############################");
			System.out.println("Employee Managment Menu");
			System.out.println("##############################\n");
			System.out.println("1. Register Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Get All Employees");
			System.out.println("4. Get Employee By ID");
			System.out.println("5. Get Employees By Job Title");
			System.out.println("6. Get Available Employees");
			System.out.println("7. Assign Shift");
			System.out.println("8. Request Leave");
			System.out.println("9. Get All Leave Requests");
			System.out.println("10. Remove Employee");
			System.out.println("0. Exit\n");
			System.out.println("##############################\n");

			choice = getChoiceFromUser();

			switch (choice) {
			case 1:
				RegisterEmployee();
				break;

			case 2:
				updateEmployee();
				break;

			case 3:
				getAllEmployees();
				break;

			case 4:
				getEmployeeById();
				break;

			case 5:
				getEmployeesByJobTitle();
				break;

			case 6:
				getAvailableEmployees();
				break;
				
			case 7:
				assignShift();
				break;
				
			case 8:
				requestLeave();
				break;
				
			case 9:
				getAllLeaveRequests();
				break;
			case 10:
				removeEmployee();
				break;
				
			}
			
			System.out.print("\nDo you want to continue (Y/N) : ");
			char ans = sc.next().charAt(0);
			
			if(ans == 'N' || ans == 'n') {
				choice = 0;
			}
			
		} while (choice != 0);

		System.out.println("####################  GOOD BYE!! ####################");
	}
	

	private int getChoiceFromUser() {
		while (true) {
			System.out.print("Enter your choice: ");
			if (sc.hasNextInt()) {
				int choice = sc.nextInt();
				sc.nextLine();
				return choice;
			} else {
				System.out.println("Invalid input! Please enter an integer.");
				sc.nextLine();
			}
		}
	}

	
	@Override
	public void RegisterEmployee() {
		System.out.println("\n############## REGISTER EMPLOYEE ##############\n");

		while (true) {
			System.out.print("Enter Employee ID: ");
			if (sc.hasNextInt()) {
				empId = sc.nextInt();
				sc.nextLine();
				break;
			} else {
				System.out.println("Invalid input! Please enter an integer.");
				sc.next();
			}
		}

		System.out.print("Enter Employee Name: ");
		name = sc.nextLine();

		System.out.print("Enter Employee Occupation: ");
		occupation = sc.nextLine();

		System.out.print("Enter Employee Email: ");
		email = sc.nextLine();

		System.out.print("Enter Employee Phone Number: ");
		phoneNum = sc.nextLine();

		// Add Employee Certifications
		System.out.println("Enter Employee Certifications (comma-separated):");
		String certificationString = sc.nextLine();
		String[] certifications = certificationString.split(",");

		for (String certification : certifications) {
			certificationList.add(new Certification(certification.trim()));
		}

		try {
			employeeService.registerEmployee(empId, name, occupation, email, phoneNum, certificationList);
			System.out.println("\n##### EMPLOYEE REGISTERD SUCCESSFULLY! #####\n");
		} catch (Exception e) {
			System.out.println("\n##### ERROR : EMPLOYEE REGISTRATION FAILED! #####\n");
		}

	}

	@Override
	public void updateEmployee() {
		System.out.println("\n############## UPDATE EMPLOYEE ##############\n");

		System.out.print("Enter Employee Id : ");
		empId = sc.nextInt();

		sc.nextLine();

		System.out.print("Enter Employee Phone Number : ");
		phoneNum = sc.nextLine();

		System.out.print("Enter Employee Email : ");
		email = sc.nextLine();

		boolean isUpdated = employeeService.updateEmployee(empId, phoneNum, email);
		if (isUpdated) {
			System.out.println("##### EMPLOYEE UPDATED SUCCESSFULLY! #####");
		} else {
			System.out.println("##############################\n");
			System.out.println("ERROR : FAILED to update Employee. Please re check the ID!");
			System.out.println("##############################\n");

		}
	}

	
	@Override
	public void getAllEmployees() {
		System.out.println("\n############## EMPLOYEES ##############\n");
		List<Employee> empList = employeeService.getEmployees();

		if (empList == null) {
			System.out.println("##### No Employees found! #####");
		} else {
			System.out.println("\n######## EMPLOYEES #########\n");
			for (Employee emp : empList) {
				System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getOccupation() + " " + emp.getPhone()
						+ " " + emp.getEmail());
			}
		}
	}

	
	@Override
	public void getEmployeeById() {

		System.out.print("Enter Employee Id : ");
		empId = sc.nextInt();
		sc.nextLine();
		Employee emp = employeeService.getEmployeeById(empId);

		if (emp != null) {
			System.out.println("\n##### EMPLOYEES #####\n");
			System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getOccupation() + " " + emp.getPhone()
					+ " " + emp.getEmail());
			System.out.println("\n----- CERTIFICATIONS -----\n");

			for (Certification ctf : emp.getCertifications()) {

				System.out.println("*) " + ctf.getName());
			}

			System.out.println("----------------------------");
		} else {
			System.out.println("\n##### Employee not found! Please recheck the ID #####\n");
		}
	}

	@Override
	public void getEmployeesByJobTitle() {

		System.out.println("\n ###### EMPLOYEES BY JOB TITLE #####\n");

		System.out.print("Enter Employee Occupation : ");
		occupation = sc.nextLine();
		List<Employee> empByJob = employeeService.getEmployeesByJobTitle(occupation);

		if (empByJob != null) {
			System.out.println("\n##### EMPLOYEEES : " + occupation + " #####\n");
			for (Employee empJ : empByJob) {
				System.out.println(empJ.getId() + " " + empJ.getName() + " " + empJ.getPhone() + " " + empJ.getEmail());
			}
		} else {
			System.out.println("\n##### Employee not found with that job title! #####\n");
		}
	}

	@Override
	public void getAvailableEmployees() {
		System.out.println("\n ###### SEARCH AVAILABLE EMPLOYEES #####\n");

		System.out.print("Enter start date (format: yyyy-mm-dd): ");
		String startDate = sc.nextLine();

		System.out.print("Enter end date (format: yyyy-mm-dd): ");
		String endDate = sc.nextLine();

		List<Employee> availableEmployees = employeeService.getAvailableEmployees(Date.valueOf(startDate),
				Date.valueOf(endDate));
		
		if (availableEmployees.size() > 0) {
			System.out.println("\n ##### Available Employees #####\n");
			for (Employee employee : availableEmployees) {
				System.out.println(employee.getId() + " " + employee.getName() + " " + employee.getOccupation());
			}
		} else {
			System.out.println("\n ##### No available employees found. #####\n");
		}
	}

	@Override
	public void assignShift() {
		System.out.print("Enter Employee ID: ");
		empId = sc.nextInt();

		sc.nextLine();

		System.out.print("Enter Start Date (yyyy-mm-dd): ");
		sDate = sc.nextLine();

		System.out.print("Enter End Date (yyyy-mm-dd): ");
		eDate = sc.nextLine();
		
		try {
			employeeService.assignShift(empId, Date.valueOf(sDate), Date.valueOf(eDate));
			System.out.println("\n##### SHIFT ASSIGNED SUCCESSFULLY! #####\n");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void requestLeave() {
		System.out.println("\n############## REQUEST LEAVE ##############\n");
		System.out.print("Enter Employee Id : ");
		empId = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Leave Start Date (yyyy-MM-dd) : ");
		sDate = sc.nextLine();
		System.out.print("Enter Leave End Date (yyyy-MM-dd) : ");
		eDate = sc.nextLine();
		System.out.print("Enter Leave Reason : ");
		reason = sc.nextLine();
		
		boolean isLeaveRequested = employeeService.requestLeave(empId, Date.valueOf(sDate), Date.valueOf(eDate),
				reason);
		if (isLeaveRequested) {
			System.out.println("\n##### LEAVE REQUESTED SUCCESSFULLY! #####\n");
		} else {
			System.out.println("\n##############################");
			System.out.println("ERROR : FAILED to request leave. Please re check the ID!");
		}
	}

	@Override
	public void getAllLeaveRequests() {
		System.out.println("\n############## GET ALL LEAVE REQUESTS ##############\n");
		
		List<LeaveRequest> leaveRequests = employeeService.getLeaveRequests();
		if (leaveRequests == null || leaveRequests.isEmpty()) {
			System.out.println("##### No Leave Requests found! #####");
		} else {
			System.out.println("\n######## LEAVE REQUESTS #########\n");
			for (LeaveRequest leaveRequest : leaveRequests) {
				System.out.println("LEAVE REQUEAST OF EMPLOYEE :  " + leaveRequest.getEmployee().getId() + "."
						+ leaveRequest.getEmployee().getName());
				System.out.println("\n FROM: " + leaveRequest.getStartDate() + "\n TO: " + leaveRequest.getEndDate()
						+ "\n Reason: " + leaveRequest.getReason());
				System.out.println("-----------------------------------------------");

			}
		}
	}

	@Override
	public void removeEmployee() {
		System.out.println("\n############## REMOVE EMPLOYEE ##############\n");
		
		System.out.print("Enter Employee Id : ");
		empId = sc.nextInt();
		sc.nextLine();
		boolean isRemoved = employeeService.removeEmployee(empId);
		if (isRemoved) {
			System.out.println("\n##### EMPLOYEE REMOVED SUCCESSFULLY! #####\n");
		} else {
			System.out.println("##############################\n");
			System.out.println("ERROR : FAILED to remove Employee. Please re check the ID!");
			System.out.println("##############################\n");
		}
	}

}