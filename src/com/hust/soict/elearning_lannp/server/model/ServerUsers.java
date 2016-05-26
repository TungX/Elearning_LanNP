package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hust.soict.elearning_lannp.shared.model.Model;
import com.hust.soict.elearning_lannp.shared.model.User;

public class ServerUsers extends User implements ServerModel {
	private ConnectData conn;

	public ServerUsers() {
		super();
		this.conn = new ConnectData();
	}

	public ServerUsers(String email, String password) {
		super();
		this.email = email;
		this.password = password;
		this.conn = new ConnectData();
	}

	public User getUserFromServer() {
		User user = null;
		this.conn.condition.put("email", this.getEmail());
		this.conn.condition.put("encrypted_password", this.getPassword());
		this.conn.connectDatabase();
		ResultSet rs = this.conn.getResultSet("users", "");
		try {
			rs.first();
			user = (User) setData(rs);
		} catch (SQLException e) {
			user = null;
		}
		return user;
	}

	public User getUser(int id) {
		User user = null;
		this.conn.condition.put("id", id + "");
		this.conn.connectDatabase();
		ResultSet rs = this.conn.getResultSet("users", "");
		try {
			rs.first();
			user = (User) setData(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		}
		return user;
	}

	@Override
	public Model setData(ResultSet rs) throws SQLException {
		User user = new User();
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("first_name"));
		user.setLasttName(rs.getString("last_name"));
		user.setType(rs.getInt("type"));
		user.setAvatar(rs.getString("avatar"));
		return user;
	}
}
