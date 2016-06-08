package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hust.soict.elearning_lannp.shared.model.Course;
import com.hust.soict.elearning_lannp.shared.model.Model;

public class ServerCourses extends Course {
	private ConnectData conn;

	public ServerCourses() {
		super();
		this.conn = new ConnectData();
	}

	public Course insert(Course course) {
		this.conn.condition.clear();
		this.conn.condition.put("name", course.getName());
		this.conn.condition.put("description", course.getDescription());
		this.conn.condition.put("password", course.getPassword());
		this.conn.condition.put("user_id", course.getUserId() + "");
		int id = this.conn.insertData("courses");
		course.setId(id);
		return course;
	}

	public Course update(Course course) {
		this.conn.condition.clear();
		this.conn.condition.put("name", course.getName());
		this.conn.condition.put("description", course.getDescription());
		this.conn.condition.put("password", course.getPassword());
		String queryplus = "id='" + course.getId() + "'";
		boolean result = this.conn.updateData("courses", queryplus);
		if (result == false)
			return null;
		return course;
	}

	public boolean destroy(int course_id) {
		this.conn.condition.clear();
		ServerAssinment assinments = new ServerAssinment();
		assinments.destroyWithCourse(course_id);
		ServerLectures lectures = new ServerLectures();
		lectures.destroyWithCourse(course_id);
		this.conn.condition.put("id", "" + course_id);
		return this.conn.delete("courses");
	}

	public Course getCourse(int course_id) {
		Course course = null;
		this.conn.condition.put("id", "" + course_id);
		ResultSet rs = this.conn.getResultSet("courses", "");
		try {
			rs.first();
			course = (Course) setData(rs);
			this.conn.closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			course = null;
		}
		return course;
	}

	public ArrayList<Course> getCourses(int user_id) {
		this.conn.condition.clear();
		if (user_id != 0)
			this.conn.condition.put("user_id", user_id + "");
		ArrayList<Course> tcourses = new ArrayList<Course>();
		String queryplus = "";
		if (user_id != 0) {
			queryplus = "true or id in (select course_id from user_in_course where user_id='" + user_id + "')";
		}
		ResultSet rs = this.conn.getResultSet("courses", queryplus);
		try {
			while (rs.next()) {
				Course course = (Course) setData(rs);
				tcourses.add(course);
			}
			this.conn.closeDatabase();
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
		course.setUserId(rs.getInt("user_id"));
		ServerUsers user = new ServerUsers();
		course.setUser(user.getUser(rs.getInt("user_id")));
		ServerLectures lectures = new ServerLectures();
		course.setLectures(lectures.getLectures(course.getId()));
		ServerAssinment assinments = new ServerAssinment();
		course.setAssignments(assinments.getAssignmentOfCourse(course.getId()));
		return course;
	}
}
