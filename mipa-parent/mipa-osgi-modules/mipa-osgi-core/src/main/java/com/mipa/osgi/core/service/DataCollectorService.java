package com.mipa.osgi.core.service;

import com.mipa.osgi.core.ScheduledJob;

public interface DataCollectorService {

	ScheduledJob getJob(final Integer providerId);
	
}