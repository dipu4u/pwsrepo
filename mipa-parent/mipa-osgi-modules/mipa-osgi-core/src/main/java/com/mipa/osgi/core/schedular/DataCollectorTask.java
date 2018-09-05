package com.mipa.osgi.core.schedular;

import java.util.TimerTask;

import com.mipa.osgi.core.service.impl.JobSchedulerServiceImpl;

public class DataCollectorTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("Main Data Collector Task Started....");
		new JobSchedulerServiceImpl().scheduleAllJob();
	}

}