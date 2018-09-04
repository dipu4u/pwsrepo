package com.mipa.osgi.data.tesco.registrar;

import com.mipa.osgi.core.service.ProviderDataActivityService;
import com.mipa.osgi.core.service.ProviderDataService;

public class AppServiceContainer {

	private static final AppServiceContainer SERVICE_CONTAINER = new AppServiceContainer();
	
	private ProviderDataService providerDataService;
	
	private ProviderDataActivityService providerDataActivityService;
	
	public static AppServiceContainer getInstance() {
		return SERVICE_CONTAINER;
	}
	
	public ProviderDataService getProviderDataService() {
		return providerDataService;
	}

	public void setProviderDataService(ProviderDataService providerDataService) {
		this.providerDataService = providerDataService;
	}

	public ProviderDataActivityService getProviderDataActivityService() {
		return providerDataActivityService;
	}

	public void setProviderDataActivityService(
			ProviderDataActivityService providerDataActivityService) {
		this.providerDataActivityService = providerDataActivityService;
	}

	private AppServiceContainer() {
		
	}
	
	
	
}
