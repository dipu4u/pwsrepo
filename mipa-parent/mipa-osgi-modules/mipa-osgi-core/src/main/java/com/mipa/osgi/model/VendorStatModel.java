package com.mipa.osgi.model;

public class VendorStatModel {

	private final String name;
	private long lastRunTime;
	private long nextRunTime;
	
	public VendorStatModel(final String name) {
		this.name = name;
	}

	public long getLastRunTime() {
		return lastRunTime;
	}

	public void setLastRunTime(long lastRunTime) {
		this.lastRunTime = lastRunTime;
	}

	public long getNextRunTime() {
		return nextRunTime;
	}

	public void setNextRunTime(long nextRunTime) {
		this.nextRunTime = nextRunTime;
	}

	public String getName() {
		return name;
	}
}