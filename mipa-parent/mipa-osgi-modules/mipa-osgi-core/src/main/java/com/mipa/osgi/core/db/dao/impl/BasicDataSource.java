package com.mipa.osgi.core.db.dao.impl;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class BasicDataSource implements DataSource {
	
	private final String className;
	private final String conUrl;
	private final String userName;
	private final String password;
	
	private Class driverClass = null;
	
	public BasicDataSource(final String className, final String conUrl, final String userName, final String password) {
		this.className = className;
		this.conUrl = conUrl;
		this.userName = userName;
		this.password = password;
		init();
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return new PrintWriter(System.out);
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(conUrl, userName, password);
		con.setAutoCommit(true);
		return con;
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		Connection con = DriverManager.getConnection(conUrl, username, password);
		con.setAutoCommit(true);
		return con;
	}
	
	private void init() {
		try {
			driverClass = Class.forName(className);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
