package com.ioc.rotw.bussinesslogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ioc.rotw.entities.Mission;
import com.ioc.rotw.helper.Constants;


public class Manager {
	private Connection connection;
	public Manager() {
		try {
			System.out.println("blabla");
			Class.forName("com.mysql.jdbc.Driver"); 
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(
						Constants.DATABASE_CONNECTION + (Constants.DATABASE_NAME != null ? Constants.DATABASE_NAME  : ""),
						Constants.DATABASE_USERNAME, Constants.DATABASE_PASSWORD);
			}
			System.out.println("print2");
			PrintMission();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean deleteMissionEntity(int MID, String MType) {
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			StringBuilder query = new StringBuilder("DELETE FROM IocProject.mission WHERE idmission='"+Integer.toString(MID)+"' AND mission_type='"+MType+"'");
			System.out.println(query.toString());
			if (statement.executeUpdate(query.toString()) > 0)
				return true;
			PrintMission();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Mission getMissionEntity(int MID, String MType) {
		try {
			Mission ret = new Mission();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			StringBuilder query = new StringBuilder("SELECT * FROM IocProject.mission WHERE idmission='"+Integer.toString(MID)+"' AND mission_type='"+MType+"'");
			ResultSet result = statement.executeQuery(query.toString());
			
			if (result != null && result.next()) {
				ret.setIdmission(Integer.parseInt(result.getString(1)));
				System.out.println(query.toString());
				System.out.println(Integer.parseInt(result.getString(1)));
				ret.setMissionName(result.getString(2));
				System.out.println(result.getString(2));
				ret.setPicName(result.getString(3));
				System.out.println(result.getString(3));
				ret.setLevel(Integer.parseInt(result.getString(4)));
				System.out.println(Integer.parseInt(result.getString(4)));
				ret.setParticipants(Integer.parseInt(result.getString(5)));
				System.out.println(Integer.parseInt(result.getString(5)));
				ret.setMaxParticipants(Integer.parseInt(result.getString(6)));
				System.out.println(Integer.parseInt(result.getString(6)));
				ret.setDescription(result.getString(7));
				System.out.println(result.getString(7));
				ret.setMissionType(result.getString(8));
				System.out.println(result.getString(8));
			}
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Mission> getMissionsByType(String MType) {
		try {
			List<Mission> ret = new ArrayList<Mission>();
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			StringBuilder query = new StringBuilder("SELECT * FROM IocProject.mission WHERE mission_type='"+MType+"'");
			ResultSet result = statement.executeQuery(query.toString());
			int currentRow = 0;
			System.out.println(result);
			while (result.next()) {
				ret.add(new Mission());
				ret.get(currentRow).setIdmission(Integer.parseInt(result.getString(1)));
				ret.get(currentRow).setMissionName(result.getString(2));
				ret.get(currentRow).setPicName(result.getString(3));
				ret.get(currentRow).setLevel(Integer.parseInt(result.getString(4)));
				ret.get(currentRow).setParticipants(Integer.parseInt(result.getString(5)));
				ret.get(currentRow).setMaxParticipants(Integer.parseInt(result.getString(6)));
				ret.get(currentRow).setDescription(result.getString(7));
				ret.get(currentRow).setMissionType(result.getString(8));
				currentRow++;
			}
			for (Mission elem : ret) {
				System.out.println(elem.getMissionName());
				System.out.println(elem.getIdmission());
				System.out.println(elem.getMissionType());
				System.out.println(elem.getDescription());
				System.out.println(elem.getLevel());
				System.out.println(elem.getMaxParticipants());
				System.out.println(elem.getPicName());
				System.out.println(elem.getParticipants());
			}
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addReplaceMission(int MID, Mission misiune) {
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			if (MID < 0) {
				//inseram misiunea in baza de date
				//INSERT INTO IocProject.mission VALUES(300 , 'AAAA', 'bbbb', 12, 20, 60, 'gigi', 'PERSON');	
				StringBuilder query = new StringBuilder("INSERT INTO IocProject.mission VALUES(null, '"+misiune.getMissionName()+"','"+misiune.getPicName()+"','"+misiune.getLevel()+"','"+misiune.getParticipants()+"','"+misiune.getMaxParticipants()+"','"+misiune.getDescription()+"','"+misiune.getMissionType()+"');");
				if (statement.executeUpdate(query.toString()) > 0)
					return true;
				return false;
			} else {
				//facem replace in baza de date cu misiune
				StringBuilder query = new StringBuilder("UPDATE IocProject.mission SET mission_name='"+misiune.getMissionName()+"', pic_name='"+misiune.getPicName()+"', level='"+misiune.getLevel()+"', participants='"+misiune.getParticipants()+"', max_participants='"+misiune.getMaxParticipants()+"', description='"+misiune.getDescription()+"', mission_type='"+misiune.getMissionType()+"' WHERE idmission='"+MID+"'");
				if (statement.executeUpdate(query.toString()) > 0)
					return true;
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void PrintMission() {
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			List<List<String>> databaseContent = null;
			StringBuilder query = new StringBuilder("SELECT * FROM IocProject.mission");
			databaseContent = new ArrayList<>();
			ResultSet result = statement.executeQuery(query.toString());
			int currentRow = 0;
			System.out.println(result);
			while (result.next()) {
				databaseContent.add(new ArrayList<String>());
				for (int currentColumn = 0; currentColumn < 8; currentColumn++) {
					System.out.println(result.getString(currentColumn + 1));
				}
				currentRow++;
			}
		} catch (SQLException sqlException) {
			System.out.println("An exception has occurred: " + sqlException.getMessage());
			sqlException.printStackTrace();
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
