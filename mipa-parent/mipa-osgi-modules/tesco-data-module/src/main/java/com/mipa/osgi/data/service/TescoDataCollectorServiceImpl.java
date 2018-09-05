package com.mipa.osgi.data.service;

import com.mipa.osgi.core.ScheduledJob;
import com.mipa.osgi.core.service.DataCollectorService;
import com.mipa.osgi.core.service.ProviderDataActivityService;
import com.mipa.osgi.data.job.TescoDataCollectorJob;
import com.mipa.osgi.data.tesco.registrar.AppServiceContainer;

public class TescoDataCollectorServiceImpl implements DataCollectorService {

	private final AppServiceContainer serviceContainer = AppServiceContainer.getInstance();
	
	@Override
	public ScheduledJob getJob(final Integer providerId) {
		System.out.println("Request received to Collect data for Provider Id " + providerId);
		ProviderDataActivityService activityService = serviceContainer.getProviderDataActivityService();
		activityService.createActivity(providerId);
		ScheduledJob job = new TescoDataCollectorJob();
		return job;
	}

}