package com.mipa.osgi.core.registrar;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

public class CoreBundleActivator implements BundleActivator {

	private BundleContext context = null;
	
	private ServiceTracker<BundleContext, HttpService> httpServiceTracker;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("Start Core Bundle.");
		this.context = context;
		httpServiceTracker = new HttpServiceTrackerImpl(this.context);
		httpServiceTracker.open();
		System.out.println("Core Bundle started with Http Service");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("Shutdown Core Bundle Servlet Services");
		httpServiceTracker.close();
		System.out.println("All Core Bundle services are down");
	}

}