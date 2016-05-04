package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hust.soict.elearning_lannp.shared.model.Lecture;
import com.hust.soict.elearning_lannp.shared.model.Model;

public class ServerLectures extends Lecture implements ServerModel {
	private ConnectData conn;

	public ServerLectures() {
		super();
		this.conn = new ConnectData();
	}

	public Lecture getLecture(int id) {
		this.conn.condition.put("id", "" + id);
		Lecture lecture = new Lecture();
		ResultSet rs = this.conn.getResultSet("lectures", "");
		try {
			rs.first();
			lecture = (Lecture) setData(rs);
			this.conn.closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lecture = null;
		}

		return lecture;
	}

	public ArrayList<Lecture> getLectures(int course_id) {
		ArrayList<Lecture> lectures = new ArrayList<Lecture>();
		this.conn.condition.put("course_id", course_id + "");
		this.conn.connectDatabase();
		ResultSet rs = this.conn.getResultSet("lectures", "");
		try {
			while (rs.next()) {
				Lecture lecture = (Lecture) setData(rs);
				lectures.add(lecture);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return lectures;
	}

	@Override
	public Model setData(ResultSet rs) throws SQLException {
		Lecture lecture = new Lecture();
		lecture.setId(rs.getInt("id"));
		lecture.setName(rs.getString("name"));
		lecture.setDescription(rs.getString("description"));
		lecture.setPassword(rs.getString("password"));
		lecture.setCourseId(rs.getInt("course_id"));
		return lecture;
	}

}
