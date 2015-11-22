package com.ioc.rotw.bussinesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ioc.rotw.helper.Constants;


public class Manager {
	private Connection connection;
	public Manager() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(
						Constants.DATABASE_CONNECTION + (Constants.DATABASE_NAME != null ? Constants.DATABASE_NAME  : ""),
						Constants.DATABASE_USERNAME, Constants.DATABASE_PASSWORD);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*	public int getType(String username, String password) {
		DatabaseOperations databaseOperations = null;
		try {
			databaseOperations = DatabaseOperationsImplementation.getInstance();
			int result = Constants.USER_NONE;
			List<String> attributes = new ArrayList<>();
			attributes.add(Constants.USER_TYPE);
			List<List<String>> type = databaseOperations.getTableContent(table, attributes,
					Constants.USERNAME + "=\'" + username + "\' AND " + Constants.PASSWORD + "=\'" + password + "\'",
					null, null, null);
			if (type != null && !type.isEmpty() && type.get(0) != null && type.get(0).get(0) != null) {
				switch (type.get(0).get(0).toString()) {
				case Constants.ADMINISTRATOR_TYPE:
					return Constants.USER_ADMINISTRATOR;
				case Constants.CLIENT_TYPE:
					return Constants.USER_CLIENT;
				}
			}
			return result;
		} catch (SQLException sqlException) {
			System.out.println("An exception has occurred: " + sqlException.getMessage());
			if (Constants.DEBUG) {
				sqlException.printStackTrace();
			}
		} finally {
			databaseOperations.releaseResources();
		}
		return Constants.USER_NONE;
	}

	public String getDisplay(String username, String password) {
		DatabaseOperations databaseOperations = null;
		try {
			databaseOperations = DatabaseOperationsImplementation.getInstance();
			List<String> attributes = new ArrayList<>();
			attributes.add("CONCAT(first_name, ' ', last_name)");
			List<List<String>> display = databaseOperations.getTableContent(table, attributes,
					Constants.USERNAME + "=\'" + username + "\' AND " + Constants.PASSWORD + "=\'" + password + "\'",
					null, null, null);
			if (display != null && display.get(0) != null) {
				return display.get(0).get(0);
			}
		} catch (SQLException sqlException) {
			System.out.println("An exception has occurred: " + sqlException.getMessage());
			if (Constants.DEBUG) {
				sqlException.printStackTrace();
			}
		} finally {
			databaseOperations.releaseResources();
		}
		return null;
	}

	public long getIdentifier(String display) {
		DatabaseOperations databaseOperations = null;
		try {
			databaseOperations = DatabaseOperationsImplementation.getInstance();
			List<String> attributes = new ArrayList<>();
			attributes.add(Constants.ID_ATTRIBUTE);
			List<List<String>> identifier = databaseOperations.getTableContent(table, attributes,
					"CONCAT(first_name, \' \', last_name)=\'" + display + "\'", null, null, null);
			if (identifier != null && !identifier.isEmpty()) {
				return Long.parseLong(identifier.get(0).get(0));
			}
		} catch (SQLException sqlException) {
			System.out.println("An exception has occurred: " + sqlException.getMessage());
			if (Constants.DEBUG) {
				sqlException.printStackTrace();
			}
		} finally {
			databaseOperations.releaseResources();
		}
		return -1;
	}*/

}