package com.mipa.osgi.core.container;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mipa.osgi.core.db.dao.ProviderDataActivityDao;
import com.mipa.osgi.core.db.dao.ProviderDataDao;
import com.mipa.osgi.core.db.dao.impl.BasicDataSource;
import com.mipa.osgi.core.db.dao.impl.ProviderDataActivityDaoImpl;
import com.mipa.osgi.core.db.dao.impl.ProviderDataDaoImpl;

public class DatabaseComponentContainer {

	private static final DatabaseComponentContainer CONTAINER = new DatabaseComponentContainer();
	private Properties configProps = new Properties();
	
	private DataSource dataSource = null;
	private ProviderDataDao providerDataDao = null;
	private ProviderDataActivityDao providerDataActivityDao = null;
	
	public static DatabaseComponentContainer getInstance() {
		return CONTAINER;
	}

	public boolean init() {
		boolean connected = false;
		if(isDBConnected()) {
			providerDataDao = new ProviderDataDaoImpl();
			providerDataDao.setDataSource(dataSource);

			providerDataActivityDao = new ProviderDataActivityDaoImpl();
			providerDataActivityDao.setDataSource(dataSource);
			System.out.println("Creation of DataSource and DAO classes complete.");
			connected = true;
		}
		return connected;
	}
	
	public ProviderDataDao getProviderDataDao() {
		return providerDataDao;
	}

	public ProviderDataActivityDao getProviderDataActivityDao() {
		return providerDataActivityDao;
	}

	private DatabaseComponentContainer() {
		initConfig();
		initDataSource();
	}
	
	private void initDataSource() {
		dataSource = new BasicDataSource(configProps.getProperty("database.driverClassName"), 
				configProps.getProperty("database.url"), configProps.getProperty("database.username"), 
				configProps.getProperty("database.password"));		
	}
	
	private void initConfig() {
		try (InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("configuration.properties")) {
			configProps.load(inStream);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean isDBConnected() {
		boolean connected = false;
		Connection con = null;
		try {
			System.out.println("Now check database connection...");
			con = dataSource.getConnection();
			connected = con.isValid(10);
			con.close();
			System.out.println("Got valid connection from database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connected;
	}

}