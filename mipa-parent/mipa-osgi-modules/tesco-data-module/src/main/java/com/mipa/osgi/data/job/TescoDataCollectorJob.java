package com.mipa.osgi.data.job;

import com.mipa.osgi.core.ScheduledJob;
import com.mipa.osgi.data.constant.TescoBundleConstant;

public class TescoDataCollectorJob implements ScheduledJob {

	public TescoDataCollectorJob() {}
	
	@Override
	public void run() {
		System.out.println("Tesco Data collection started....");
	}

	@Override
	public String getProviderName() {
		return TescoBundleConstant.NAME;
	}

}