package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerUserInCourses {
	private ConnectData conn;

	public ServerUserInCourses() {
		// TODO Auto-generated constructor stub
		super();
		this.conn = new ConnectData();
	}

	public void joinCourse(int user_id, int course_id) {
		this.conn.condition.clear();
		this.conn.condition.put("user_id", user_id + "");
		this.conn.condition.put("course_id", course_id + "");
		this.conn.insertData("user_in_course");
	}

	public void leaveCourse(int user_id, int course_id) {
		this.conn.condition.clear();
		this.conn.condition.put("user_id", user_id + "");
		this.conn.condition.put("course_id", course_id + "");
		this.conn.delete("user_in_course");
	}

	public ArrayList<Integer> getCourses(int user_id) {
		ArrayList<Integer> courses = new ArrayList<Integer>();
		this.conn.condition.clear();
		this.conn.condition.put("user_id", user_id + "");
		this.conn.connectDatabase();
		ResultSet rs = this.conn.getResultSet("user_in_course", "");
		try {
			while (rs.next()) {
				int course_id = rs.getInt("course_id");
				courses.add(course_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			courses = new ArrayList<Integer>();
		}
		return courses;
	}

}
