package com.mipa.osgi.core.registrar;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

import com.mipa.osgi.core.service.ProviderDataActivityService;
import com.mipa.osgi.core.service.ProviderDataService;
import com.mipa.osgi.core.service.impl.ProviderDataActivityImpl;
import com.mipa.osgi.core.service.impl.ProviderDataServiceImpl;

public class CoreBundleActivator implements BundleActivator {
	
	private static final Logger LOG = Logger.getLogger(CoreBundleActivator.class);

	private BundleContext context = null;
	private ServiceTracker<BundleContext, HttpService> httpServiceTracker;
	
	private ServiceRegistration<ProviderDataService> providerServiceRef = null;
	private ServiceRegistration<ProviderDataActivityService> providerActivityServiceRef = null;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Core Bundle.");
		this.context = context;
		registerService();
		httpServiceTracker = new HttpServiceTrackerImpl(this.context);
		httpServiceTracker.open();
		System.out.println("Core Bundle started with Http Service");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Shutdown Core Bundle Servlet Services");
		providerServiceRef.unregister();
		providerActivityServiceRef.unregister();
		httpServiceTracker.close();
		System.out.println("All Core Bundle services are down");
		
	}
	
	private void registerService() {
		providerServiceRef = context.registerService(ProviderDataService.class, new ProviderDataServiceImpl(), null);
		
		providerActivityServiceRef = context.registerService(ProviderDataActivityService.class, new ProviderDataActivityImpl(), null);
		System.out.println("Core bundle Service registration complete.");
	}

}