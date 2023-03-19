package inventorypublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class VaccineActivator implements BundleActivator {
	
	
	private static BundleContext context;

	
	static BundleContext getContext() {
		return context;
	}
	
	private ServiceRegistration<?> 	vaccineReg;



	public void start(BundleContext context) throws Exception {
		System.out.println("Vaccine Publisher Service Started!");
		
		VaccineActivator.context = context;
		
		VaccineService publisherService =  new VaccineServiceImpl();
		vaccineReg = context.registerService(VaccineService.class.getName(), publisherService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Vaccine Publisher Service Stoped!");
		vaccineReg.unregister();
	}

}
