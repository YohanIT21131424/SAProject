package labAssistant;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.lab.AppointmentProducer.AppointmentProducer;
import com.lab.LabTestProducer.LabTestProducer;


public class LabAssistantConsumerActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceReference<?> LabTestRef,AppointmentRef;
	private ServiceRegistration<?> labAssistantReg;
	
	private LabTestProducer labTest;
	AppointmentProducer appointment;

     
	Scanner scan = new Scanner(System.in);

	public void start(BundleContext bundleContext) throws Exception {
	
		
		System.out.println("Lab assistant consumer started ");
		
		//LabAssistantConsumerActivator Registration
		labAssistantReg = bundleContext.registerService(this.getClass().getName(), this, null);
		
		
		//Get service from TestReportProducer
		LabTestRef = bundleContext.getServiceReference(LabTestProducer.class.getName());
		labTest = (LabTestProducer) bundleContext.getService(LabTestRef);

		
		//Get service from AppointmentProducer
		AppointmentRef = bundleContext.getServiceReference(AppointmentProducer.class.getName());
		appointment = (AppointmentProducer) bundleContext.getService(AppointmentRef);
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {

		System.out.println("Lab assistant consumer stoped ");
		labAssistantReg.unregister();
		
		bundleContext.ungetService(AppointmentRef);
		bundleContext.ungetService(LabTestRef);
		
	}
	
	public void displayLabAssistant() {
		
		
         while(true) {
			
			System.out.println("=================================");
			System.out.println("1. Add lab test");
			System.out.println("2. update for lab test");
			System.out.println("3. Search for lab test");
	        System.out.println("4. View all lab test");
	        System.out.println("5. Search for appointment");
	        System.out.println("6. View all appointment");
	        
	        System.out.println("7. exit\n"); 
	        
	        System.out.print("Select an option : ");
	        
	        String input = scan.nextLine();
	        
	        if(input.equals("1")) { 
	        	labTest.addnewTest();
	        	
	        } else if(input.equals("2")) {
	        	labTest.updateTest();
	        	
	        } else if(input.equals("3")) {
	        	labTest.searchTest();
	        	
	        } else if(input.equals("4")) {
	        	labTest.viewAllTest();
	        	
	        } else if(input.equals("5")) {
	        	appointment.searchAppointment();
	        	
	        } else if(input.equals("6")) {
	        	appointment.displayAppointment();
	        	
	        } else if(input.equals("7")) {
	        	
	        	break;
	        	
	        } else {
	        	
	        	System.out.println("Invalid input, try again.");
	        	
	        }
			
		}
	}
	
}
