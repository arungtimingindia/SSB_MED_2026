package com.ttil.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbConnection {

	public static Connection setupDataSource() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env"); 
			DataSource ds = null;
			if (envContext != null) {
				ds = (DataSource) envContext.lookup("jdbc/SSBADVT_1_MEDICAL_26");
			}
			if (ds != null) {
				conn = ds.getConnection();
			}
			if (conn == null) {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DbConnectionMain",
				// "Connection is null", null, null, null);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogsWithMobileNumber("DbConnectionMain",
			// exceptionAsString, null, null, null);
		}
		return conn; 
	}

	public static Connection setupRepoDataSource() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = null;
			if (envContext != null) {
				ds = (DataSource) envContext.lookup("jdbc/SSBADVT_1_MEDICAL_26"); 
			}
			if (ds != null) {
				conn = ds.getConnection();
			}
			if (conn == null) {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DbConnectionSlave", "Slave
				// Connection is null", null, null, null);
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogsWithMobileNumber("DbConnectionSlave",
			// exceptionAsString, null, null, null);
		}
		return conn;
	}

	public static Connection setupCommRectDataSource() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = null;
			if (envContext != null) {
				ds = (DataSource) envContext.lookup("jdbc/SSBADVT_1_MEDICAL_26");
			}
			if (ds != null) {
				conn = ds.getConnection();
			}
			if (conn == null) {
				// LogsGeneration.generateErrorLogsWithMobileNumber("DbConnectionMain",
				// "Connection is null", null, null, null);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			// LogsGeneration.generateErrorLogsWithMobileNumber("DbConnectionMain",
			// exceptionAsString, null, null, null);
		}
		return conn;
	}

}