package com.mipa.osgi.core;

public interface DataCollectorService {

	String getName();
	
	void trigger(final String name, final Short countryId, final String pincodes);
	
}