package com.mipa.osgi.core.registrar;

import javax.servlet.ServletException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.util.tracker.ServiceTracker;

import com.mipa.osgi.core.servlet.CoreSchdulerServlet;

public class HttpServiceTrackerImpl extends ServiceTracker<BundleContext, HttpService> {
	
	private final BundleContext context;
	
	public HttpServiceTrackerImpl(BundleContext context) {
		super(context, HttpService.class.getName(), null);
		this.context = context;
	}

	@Override
	public HttpService addingService(ServiceReference<BundleContext> reference) {
		HttpService httpService = (HttpService) context.getService(reference);
		try {
			httpService.registerServlet("/core/statistic", new CoreSchdulerServlet(), null, null);
		} catch (ServletException | NamespaceException e) {
			e.printStackTrace();
		}
		return httpService;
	}

	@Override
	public void removedService(ServiceReference<BundleContext> reference,
			HttpService service) {
		service.unregister("/core/statistic");
	}
	
}