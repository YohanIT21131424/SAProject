import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.lab.TestReportProducer.TestReportProducer;
import com.lab.TestReportProducer.TestReportProducerIMP;

public class TestReportProducerActivator implements BundleActivator {

	private static BundleContext context;
	private ServiceRegistration<?> testReportReg;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		System.out.println(" TestReport producer started !");
		
		TestReportProducerActivator.context = bundleContext;
		
		TestReportProducer test = new TestReportProducerIMP();
		
		testReportReg = bundleContext.registerService(TestReportProducer.class.getName(), test, null);
		
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println(" TestReport producer stoped !");
		TestReportProducerActivator.context = null;
		testReportReg.unregister();
		
	}

}
