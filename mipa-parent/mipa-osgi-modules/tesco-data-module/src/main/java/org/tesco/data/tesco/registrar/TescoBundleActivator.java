package org.tesco.data.tesco.registrar;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class TescoBundleActivator implements BundleActivator {

	private AppServiceContainer serviceContainer = AppServiceContainer.getInstance();
	
	@Override
	public void start(BundleContext context) throws Exception {
		
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
	}

}