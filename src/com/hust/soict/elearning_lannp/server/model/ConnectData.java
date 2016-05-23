package com.hust.soict.elearning_lannp.server.model;

import java.sql.*;
import java.util.HashMap;

import com.hust.soict.elearning_lannp.server.Config;

public class ConnectData {
	static String jdbc_url = "jdbc:mysql://127.0.0.1:3306/elearning_lannp?useUnicode=true&characterEncoding=UTF-8";
	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static String mysql_user = Config.MYSQLUSER;
	static String mysql_password = Config.MYSQLPASSWORD;
	private Connection conn = null;
	private Statement stmt = null;
	public HashMap<String, String> condition;

	public ConnectData() {
		this.condition = new HashMap<String, String>();
	}

	public void connectDatabase() {
		try {
			Class.forName(JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(jdbc_url, mysql_user,
					mysql_password);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeDatabase() throws SQLException {
		this.conn.close();
	}

	public boolean checkUserExist(String email, String password) {
		connectDatabase();
		int count = 0;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from users where email='" + email
							+ "'&& encrypted_password='" + password + "'");
			rs.last();
			count = rs.getRow();
			closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return (count > 0);
	}

	public boolean checkExist(String table_name, String queryplus) {
		connectDatabase();
		int count = 0;
		try {
			String query = "select * from " + table_name;
			query += getQuery(condition, queryplus);
			ResultSet rs = stmt.executeQuery(query);
			rs.last();
			count = rs.getRow();
			closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (count > 0);
	}

	public ResultSet getResultSet(String table_name, String queryplus) {
		connectDatabase();
		ResultSet rs = null;
		try {
			String query = "select * from " + table_name;
			query += getQuery(condition, queryplus);
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public boolean updateData(String table_name, String queryplus) {
		connectDatabase();
		String query = getQueryUpdate();
		if (query == null)
			return false;
		query = "UPDATE " + table_name + " SET " + query;
		if (queryplus == null || queryplus.isEmpty())
			return false;
		query += "where " + queryplus;
		System.out.println("Query: " + query);
		try {
			this.stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public int insertData(String table_name) {
		connectDatabase();
		int id;
		try {
			String query = "INSERT INTO " + table_name + getQueryInsert();
			id = this.stmt
					.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			if (id == 0)
				return 0;
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return id;
	}

	private String getQueryUpdate() {
		if (condition.size() == 0 || condition == null)
			return null;
		String[] keys = condition.keySet().toArray(new String[0]);
		String query = "";
		for (int i = 0; i < keys.length - 1; i++) {
			query += keys[i] + "='" + condition.get(keys[i]) + "',";
		}
		query += keys[keys.length - 1] + "='"
				+ condition.get(keys[keys.length - 1]) + "'";
		return query;
	}

	private String getQueryInsert() {
		if (condition.size() == 0 || condition == null)
			return "";
		String[] keys = condition.keySet().toArray(new String[0]);
		String query = "(";
		for (int i = 0; i < keys.length - 1; i++) {
			query += keys[i] + ",";
		}
		query += keys[keys.length - 1] + ") values (";
		for (int i = 0; i < keys.length - 1; i++) {
			query += "'" + condition.get(keys[i]) + "',";
		}
		query += "'" + condition.get(keys[keys.length - 1]) + "')";
		return query;
	}

	private String getQuery(HashMap<String, String> condition, String queryplus) {
		if ((condition.size() == 0 || condition == null)
				&& (queryplus.isEmpty() || queryplus == null))
			return "";
		String[] keys = condition.keySet().toArray(new String[0]);
		String query = " where (";
		for (int i = 0; i < keys.length - 1; i++) {
			query += keys[i] + "='" + condition.get(keys[i]) + "' and ";
		}
		query += keys[keys.length - 1] + "='"
				+ condition.get(keys[keys.length - 1]) + "')";
		if (keys.length > 0 && !queryplus.isEmpty())
			query += " and ";
		query += queryplus;
		return query;
	}
}
