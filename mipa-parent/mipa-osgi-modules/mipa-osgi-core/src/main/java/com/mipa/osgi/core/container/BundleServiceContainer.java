package com.mipa.osgi.core.container;

import org.osgi.framework.BundleContext;

import com.mipa.osgi.core.service.ProviderDataActivityService;
import com.mipa.osgi.core.service.ProviderDataService;
import com.mipa.osgi.core.service.impl.ProviderDataActivityImpl;
import com.mipa.osgi.core.service.impl.ProviderDataServiceImpl;

public class BundleServiceContainer {

	private static final BundleServiceContainer SERVICE_CONTAINER = new BundleServiceContainer();
	
	private ProviderDataService providerDataService = null;
	
	private ProviderDataActivityService providerDataActivityService = null;
	
	private BundleContext bundleContext = null;
	
	public static BundleServiceContainer getInstance() {
		return SERVICE_CONTAINER;
	}
	
	public ProviderDataService getProviderDataService() {
		return providerDataService;
	}

	public ProviderDataActivityService getProviderDataActivityService() {
		return providerDataActivityService;
	}

	private BundleServiceContainer() {
		initServices();
	}
		
	private void initServices() {
		System.out.println("Core Bundle Datasource created.");
		DatabaseComponentContainer dbContainer = DatabaseComponentContainer.getInstance();
		providerDataService = new ProviderDataServiceImpl();
		providerDataService.setProviderDataDao(dbContainer.getProviderDataDao());
		
		providerDataActivityService = new ProviderDataActivityImpl();
		providerDataActivityService.setProviderDataActivityDao(dbContainer.getProviderDataActivityDao());
		System.out.println("Core Bundle Services are created and injected.");
	}

	public BundleContext getBundleContext() {
		return bundleContext;
	}

	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}
	
}