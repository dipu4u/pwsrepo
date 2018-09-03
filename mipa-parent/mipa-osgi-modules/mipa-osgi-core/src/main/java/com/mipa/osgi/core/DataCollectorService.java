package com.mipa.osgi.core;

public interface DataCollectorService {

	long nextRunTime();
	
	long lastRunTime();
	
	String getName();
	
}