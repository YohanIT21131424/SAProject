package employeeproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;



public class EmployeeActivator implements BundleActivator {

	private static BundleContext context;

	
	static BundleContext getContext() {
		return context;
	}
	
	private ServiceRegistration<?> publicServiceRegistration;


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Employee Publisher Started!!");
		
		EmployeeActivator.context = bundleContext;
		
		EmployeeManagementService publisherService =  new EmployeeManagementServiceImpl();
		publicServiceRegistration = bundleContext.registerService(EmployeeManagementService.class.getName(), publisherService, null);

	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Employee Publisher Stoped!!");
		publicServiceRegistration.unregister();
	}

}
