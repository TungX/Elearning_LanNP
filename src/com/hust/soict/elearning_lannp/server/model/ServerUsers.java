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

	public User insert(User user) {
		this.conn.condition.clear();
		this.conn.condition.put("email", user.getEmail());
		this.conn.condition.put("first_name", user.getFirstName());
		this.conn.condition.put("last_name", user.getLastName());
		this.conn.condition.put("encrypted_password", user.getPassword());
		this.conn.condition.put("avatar", user.getAvatar());
		this.conn.condition.put("type", user.getType() + "");
		int id = this.conn.insertData("users");
		user.setId(id);
		return user;
	}

	public User update(User user) {
		this.conn.condition.clear();
		this.conn.condition.put("email", user.getEmail());
		this.conn.condition.put("first_name", user.getFirstName());
		this.conn.condition.put("last_name", user.getLastName());
		if (!user.getPassword().isEmpty())
			this.conn.condition.put("encrypted_password", user.getPassword());
		this.conn.condition.put("avatar", user.getAvatar());
		String queryplus = "id='" + user.getId() + "'";
		boolean result = this.conn.updateData("users", queryplus);
		if (result == false)
			return null;
		return user;
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

	public User getUser(int id, String password) {
		User user = null;
		this.conn.condition.put("id", id + "");
		this.conn.condition.put("encrypted_password", password);
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
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setType(rs.getInt("type"));
		user.setAvatar(rs.getString("avatar"));
		ServerUserInCourses userInCourses = new ServerUserInCourses();
		System.out.println("User_id: " + user.getId());
		user.setCourseIds(userInCourses.getCourses(user.getId()));
		return user;
	}
}
