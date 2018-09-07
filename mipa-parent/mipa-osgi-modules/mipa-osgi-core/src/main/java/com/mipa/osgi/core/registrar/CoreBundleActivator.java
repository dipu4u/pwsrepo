package com.mipa.osgi.core.registrar;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

import com.mipa.osgi.core.container.BundleServiceContainer;
import com.mipa.osgi.core.container.DatabaseComponentContainer;
import com.mipa.osgi.core.schedular.CoreSchedularProvider;
import com.mipa.osgi.core.service.ProviderDataActivityService;
import com.mipa.osgi.core.service.ProviderDataService;

public class CoreBundleActivator implements BundleActivator {
	
	private static final Logger LOG = Logger.getLogger(CoreBundleActivator.class);

	private BundleContext context = null;
	private ServiceTracker<BundleContext, HttpService> httpServiceTracker = null;
	
	private ServiceRegistration<ProviderDataService> providerServiceRef = null;
	private ServiceRegistration<ProviderDataActivityService> providerActivityServiceRef = null;
	
	private DatabaseComponentContainer dbContainer = null;
	private BundleServiceContainer serviceContainer = null;
	private CoreSchedularProvider schedulerProvider = null;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Core Bundle.");
		this.context = context;		
		System.out.println("Core Bundle started with Http Service");
		dbContainer = DatabaseComponentContainer.getInstance();
		if(dbContainer.init()) {
			httpServiceTracker = new HttpServiceTrackerImpl(this.context);
			httpServiceTracker.open();
			
			serviceContainer = BundleServiceContainer.getInstance();
			serviceContainer.setBundleContext(context);
			schedulerProvider = CoreSchedularProvider.getInstance();
			registerService();
		} else {
			throw new RuntimeException("Core Bundle. Database not reachable aborted service startup.");
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Shutdown Core Bundle Servlet Services");
		providerServiceRef.unregister();
		providerActivityServiceRef.unregister();
		httpServiceTracker.close();
		schedulerProvider.shutdown();
		System.out.println("All Core Bundle services are down");
	}

	private void registerService() {
		providerServiceRef = context.registerService(ProviderDataService.class, 
				serviceContainer.getProviderDataService(), null);
		providerActivityServiceRef = context.registerService(ProviderDataActivityService.class, 
				serviceContainer.getProviderDataActivityService(), null);
		System.out.println("Core Provider Service registration complete.");
	}
	
}