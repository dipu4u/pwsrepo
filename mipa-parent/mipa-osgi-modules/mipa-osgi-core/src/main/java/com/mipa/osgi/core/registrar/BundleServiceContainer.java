package com.mipa.osgi.core.registrar;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.osgi.framework.BundleContext;

import com.mipa.osgi.core.db.dao.ProviderDataActivityDao;
import com.mipa.osgi.core.db.dao.ProviderDataDao;
import com.mipa.osgi.core.db.dao.impl.ProviderDataActivityDaoImpl;
import com.mipa.osgi.core.db.dao.impl.ProviderDataDaoImpl;
import com.mipa.osgi.core.service.ProviderDataActivityService;
import com.mipa.osgi.core.service.ProviderDataService;
import com.mipa.osgi.core.service.impl.ProviderDataActivityImpl;
import com.mipa.osgi.core.service.impl.ProviderDataServiceImpl;

public class BundleServiceContainer {

	private static final BundleServiceContainer SERVICE_CONTAINER = new BundleServiceContainer();
	
	private ProviderDataService providerDataService = null;
	
	private ProviderDataActivityService providerDataActivityService = null;
	
	private BundleContext bundleContext = null;
	
	private Properties appProperties = new Properties();
	
	public static BundleServiceContainer getInstance() {
		return SERVICE_CONTAINER;
	}
	
	public ProviderDataService getProviderDataService() {
		return providerDataService;
	}

	public void setProviderDataService(ProviderDataService providerDataService) {
		this.providerDataService = providerDataService;
	}

	public ProviderDataActivityService getProviderDataActivityService() {
		return providerDataActivityService;
	}

	public void setProviderDataActivityService(
			ProviderDataActivityService providerDataActivityService) {
		this.providerDataActivityService = providerDataActivityService;
	}

	public BundleContext getBundleContext() {
		return bundleContext;
	}

	public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}

	private BundleServiceContainer() {
		initConfig();
		initServices();
	}
	
	private void initConfig() {
		try (InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("configuration.properties")) {
			appProperties.load(inStream);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void initServices() {
		DataSource dataSource = createDataSource();
		System.out.println("Core Bundle Datasource created.");
		ProviderDataDao providerDataDao = new ProviderDataDaoImpl();
		providerDataDao.setDataSource(dataSource);
		ProviderDataActivityDao providerDataActivityDao = new ProviderDataActivityDaoImpl();
		providerDataActivityDao.setDataSource(dataSource);
		
		providerDataService = new ProviderDataServiceImpl();
		providerDataService.setProviderDataDao(providerDataDao);				
		providerDataActivityService = new ProviderDataActivityImpl();
		providerDataActivityService.setProviderDataActivityDao(providerDataActivityDao);
	}
	
	private DataSource createDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(appProperties.getProperty("database.driverClassName"));
		dataSource.setUrl(appProperties.getProperty("database.url"));
		dataSource.setUsername(appProperties.getProperty("database.username"));
		dataSource.setPassword(appProperties.getProperty("database.password"));
		return dataSource;
	}

}