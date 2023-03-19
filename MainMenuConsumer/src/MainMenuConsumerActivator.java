import com.lab.LoginProducer.LoginProducer;
import employeesubscriber.EmployeeServiceActivator;
import inventorysubscriber.VaccineServiceActivator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import labAssistant.LabAssistantConsumerActivator;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import patientConsumer.PatientConsumerActivator;

public class MainMenuConsumerActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference<?> PatientRef;
	private ServiceReference<?> LabAssistantRef;
	private ServiceReference<?> MedicalRep;
	private ServiceReference<?> LoginRef;
	private ServiceReference<?> EmployeeRef;
	private ServiceReference<?> VaccineRef;

	private LoginProducer login;

	Scanner scanner = new Scanner(System.in);
	int option;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {

		MainMenuConsumerActivator.context = bundleContext;

		// Connect to PatientConsumerActivator class
		PatientRef = context.getServiceReference(PatientConsumerActivator.class.getName());
		PatientConsumerActivator patient = (PatientConsumerActivator) bundleContext.getService(PatientRef);

		// Connect to PatientConsumerActivator class

		// Connect to LabAssistantConsumerActivator class
		LabAssistantRef = context.getServiceReference(LabAssistantConsumerActivator.class.getName());
		LabAssistantConsumerActivator labAssistant = (LabAssistantConsumerActivator) bundleContext
				.getService(LabAssistantRef);

		// Connect to EmployeeConsumerActivator class
		EmployeeRef = context.getServiceReference(EmployeeServiceActivator.class.getName());
		EmployeeServiceActivator employee = (EmployeeServiceActivator) bundleContext.getService(EmployeeRef);

		// Connect to VaccineConsumerActivator class
		VaccineRef = context.getServiceReference(VaccineServiceActivator.class.getName());
		VaccineServiceActivator vaccine = (VaccineServiceActivator) bundleContext.getService(VaccineRef);

		// Connect to LoginProducerActivator class
		LoginRef = bundleContext.getServiceReference(LoginProducer.class.getName());
		login = (LoginProducer) bundleContext.getService(LoginRef);

//		while (true) {
//
//			System.out.println("\n=================================");
//			System.out.println("\n  ImmuniGuard  \n");
//			BufferedReader buffin = new BufferedReader(new InputStreamReader(System.in));
//			String option = "0";
//
//			System.out.println("\n=================================");
//			System.out.println("\nWelcome! Please select role,\n");
//			System.out.println("1. Patient ");
//			System.out.println("2. Employee ");
//
//			System.out.println("\n---------------------\n");
//			System.out.println("3. Exit from the system ");
//			System.out.print("\nSelect an option :");
//
//			String opt = scanner.nextLine();
//
//			if (opt.equals("3")) {
//
//				System.out.println("Logging you out!");
//				break;
//			} else if (opt.equals("1")) {
//
//				patient.displayPatient();
//
//			} else if (opt.equals("2")) {
//
//				boolean status = login.employeeLogin();
//
//				if (status == true) {
//
//					while (true) {
//
//						System.out.println("\n=================================");
//						System.out.println("\n\n\nPlease select an option!\n");
//						System.out.println("1. Lab Assistant ");
//						System.out.println("2. Employee Managment ");
//						System.out.println("3. Vaccine Managment ");
//						System.out.println("4. Exit \n\n");
//
//						System.out.print("Select an option :");
////						option = buffin.readLine();
//						// option = scanner.nextInt();
//						option = scanner.nextLine();
//
//						switch (option) {
//							case "1":
//								labAssistant.displayLabAssistant();
//								break;
//							case "2":
//								employee.displayMenu();
//								break;
//							case "3":
//								vaccine.displayMenu();
//								break;
//							case "4":
//								break;
//						}
//
////        			if(option.equals("1")){
////        				
////        				labAssistant.displayLabAssistant();
////        			} else if(option.equals("2") ){
////            			
////
////
////        				break;
////        			}
//					}
//				} else {
//
//					System.out.println("Please try again!");
//					continue;
//
//				}
//
//			}
//		}
		
		
		
		
		
		
		
		
		
		while (true) {
		    System.out.println("\n=================================");
		    System.out.println("\n  ImmuniGuard  \n");
		    String option = "0";

		    System.out.println("\n=================================");
		    System.out.println("\nWelcome! Please select role,\n");
		    System.out.println("1. Patient ");
		    System.out.println("2. Employee ");

		    System.out.println("\n---------------------\n");
		    System.out.println("3. Exit from the system ");
		    System.out.print("\nSelect an option :");

		    String opt = scanner.nextLine();

		    if (opt.equals("3")) {
		        System.out.println("Logging you out!");
		        break;
		    } else if (opt.equals("1")) {
		        patient.displayPatient();
		    } else if (opt.equals("2")) {
		        boolean status = login.employeeLogin();
		        if (status == true) {
		            while (true) {
		                System.out.println("\n=================================");
		                System.out.println("\n\n\nPlease select an option!\n");
		                System.out.println("1. Lab Assistant ");
		                System.out.println("2. Employee Managment ");
		                System.out.println("3. Vaccine Managment ");
		                System.out.println("4. Exit \n\n");

		                System.out.print("Select an option :");
		                option = scanner.nextLine();

		                switch (option) {
		                    case "1":
		                        labAssistant.displayLabAssistant();
		                        break;
		                    case "2":
		                        employee.displayMenu();
		                        break;
		                    case "3":
		                        vaccine.displayMenu();
		                        break;
		                    case "4":
		                        break;
		                }

		                if (option.equals("4")) {
		                    break;
		                }
		            }
		        } else {
		            System.out.println("Please try again!");
		            continue;
		        }
		    }
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		MainMenuConsumerActivator.context = null;

		System.out.println("Main menu consumer stopped");
		bundleContext.ungetService(LoginRef);
		bundleContext.ungetService(PatientRef);
		bundleContext.ungetService(LabAssistantRef);
		bundleContext.ungetService(MedicalRep);

	}

}
