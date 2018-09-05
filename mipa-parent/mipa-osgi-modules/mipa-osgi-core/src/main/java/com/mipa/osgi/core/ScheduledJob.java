package com.mipa.osgi.core;

public interface ScheduledJob extends Runnable {

	String getProviderName();
	
}