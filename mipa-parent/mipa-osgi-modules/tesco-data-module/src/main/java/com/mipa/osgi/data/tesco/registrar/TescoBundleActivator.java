package com.mipa.osgi.data.tesco.registrar;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.mipa.osgi.core.service.DataCollectorService;
import com.mipa.osgi.core.service.ProviderDataActivityService;
import com.mipa.osgi.core.service.ProviderDataService;
import com.mipa.osgi.data.constant.TescoBundleConstant;
import com.mipa.osgi.data.service.TescoDataCollectorServiceImpl;

public class TescoBundleActivator implements BundleActivator {
	
	private static final Logger LOG= Logger.getLogger(TescoBundleActivator.class);

	private AppServiceContainer serviceContainer = AppServiceContainer.getInstance();
	
	private ServiceRegistration<DataCollectorService> dataCollectorService = null;
	
	private BundleContext bundleContext = null;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Now register Tesco Data Collector Service");
		bundleContext = context;
		Hashtable<String, String> props = new Hashtable<String, String>(1);
		props.put("type", TescoBundleConstant.NAME);
		dataCollectorService = context.registerService(DataCollectorService.class, new TescoDataCollectorServiceImpl(), props);
		System.out.println("Tesco Data Collector service registered");
		findService();
	}

	@Override
	public void stop(BundleContext context) throws Exception {		
		dataCollectorService.unregister();
		System.out.println("Shutdown Tesco Data Collector Service");
	}
	
	private void findService() {
		System.out.println("Search started for Provider and Data Activity Services");
		ServiceReference<ProviderDataService> providerServiceRef = 
				bundleContext.getServiceReference(ProviderDataService.class);
		
		ServiceReference<ProviderDataActivityService> providerActivityServiceRef = 
				bundleContext.getServiceReference(ProviderDataActivityService.class);
		
		serviceContainer.setProviderDataService(bundleContext.getService(providerServiceRef));
		serviceContainer.setProviderDataActivityService(bundleContext.getService(providerActivityServiceRef));
		System.out.println("Search completed for Provider and Data Activity Services");
	}

}