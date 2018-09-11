package com.mipa.osgi.core.service.impl;

import java.util.Collection;
import java.util.Objects;

import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

import com.mipa.osgi.core.ScheduledJob;
import com.mipa.osgi.core.container.BundleServiceContainer;
import com.mipa.osgi.core.db.entity.ProviderDataEntity;
import com.mipa.osgi.core.schedular.CoreSchedularProvider;
import com.mipa.osgi.core.service.DataCollectorService;

public class JobSchedulerServiceImpl {
	
	private final BundleServiceContainer serviceContainer = BundleServiceContainer.getInstance();
	
	private final CoreSchedularProvider schedularProvider = CoreSchedularProvider.getInstance();
	
	public JobSchedulerServiceImpl() {}
	
	public void scheduleAllJob() {
		System.out.println("All Job Schedule started...");
	}

	public boolean scheduleJob(final Integer providerId) {
		boolean status = false;
		System.out.println("Schedule Job for Provider Id " + providerId);
		ProviderDataEntity dataEntity = serviceContainer.getProviderDataService().getProvider(providerId);
		try {
			if(Objects.nonNull(dataEntity)) {
				final String providerName = dataEntity.getProviderName();
				Collection<ServiceReference<DataCollectorService>> serviceRefList = 
						getServiceReference(providerName);
				if(!serviceRefList.isEmpty()) {
					DataCollectorService dataCollectorService = 
							serviceContainer.getBundleContext().getService(serviceRefList.iterator().next());
					ScheduledJob job = dataCollectorService.getJob(providerId);
					schedularProvider.addJob(job);
					status = true;
				} else {
					System.out.println("Data Collector Service not found for " + dataEntity.getProviderName());
				}
			}
		}catch(InvalidSyntaxException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@SuppressWarnings({ "unused"})
	private Collection<ServiceReference<DataCollectorService>> getServiceReference(final String providerName) 
			throws InvalidSyntaxException {
		ServiceReference<DataCollectorService> serviceRef = null;
		final String filter = "(attributes=" + providerName + ")";
		return serviceContainer.getBundleContext().getServiceReferences(DataCollectorService.class, filter);
	}
}
