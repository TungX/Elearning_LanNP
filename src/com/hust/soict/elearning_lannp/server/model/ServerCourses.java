package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.hust.soict.elearning_lannp.shared.model.Category;
import com.hust.soict.elearning_lannp.shared.model.Course;
import com.hust.soict.elearning_lannp.shared.model.Model;

public class ServerCourses extends Course {
	private ConnectData conn;

	public ServerCourses() {
		super();
		this.conn = new ConnectData();
	}

	public Course update(Course course) {
		this.conn.condition.clear();
		this.conn.condition.put("name", course.getName());
		this.conn.condition.put("description", course.getDescription());
		String queryplus = "id='" + course.getId() + "'";
		boolean result = this.conn.updateData("courses", queryplus);
		if (result == false)
			return null;
		return course;
	}
	
	public boolean destroy(int course_id) {
		this.conn.condition.clear();
		this.conn.condition.put("id", ""+course_id);
		return this.conn.delete("courses");
	}

	public Course getCourse(int course_id) {
		Course course = null;
		this.conn.condition.put("id", "" + course_id);
		ResultSet rs = this.conn.getResultSet("courses", "");
		try {
			rs.first();
			course = (Course) setData(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			course = null;
		}
		return course;
	}

	public ArrayList<Course> getCourses(HashMap<String, String> condition) {
		ArrayList<Course> tcourses = new ArrayList<Course>();
		if (condition != null)
			this.conn.condition = condition;
		ResultSet rs = this.conn.getResultSet("courses", "");
		try {
			while (rs.next()) {
				Course course = (Course) setData(rs);
				tcourses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return tcourses;
	}

	private Model setData(ResultSet rs) throws SQLException {
		Course course = new Course();
		course.setId(rs.getInt("id"));
		course.setName(rs.getString("name"));
		course.setDescription(rs.getString("description"));
		course.setPassword(rs.getString("password"));
		course.setCategory(new Category(rs.getInt("category_id")));
		ServerUsers user = new ServerUsers();
		course.setUser(user.getUser(rs.getInt("user_id")));
		ServerLectures lectures = new ServerLectures();
		course.setLectures(lectures.getLectures(course.getId()));
		ServerAssinment assinments = new ServerAssinment();
		course.setAssignments(assinments.getAssignmentOfCourse(course.getId()));
		return course;
	}
}
