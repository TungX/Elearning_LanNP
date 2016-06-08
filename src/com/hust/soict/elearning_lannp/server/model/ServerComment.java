package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hust.soict.elearning_lannp.shared.model.Comment;
import com.hust.soict.elearning_lannp.shared.model.Model;

public class ServerComment extends Comment implements ServerModel {
	private ConnectData conn;

	public ServerComment() {
		// TODO Auto-generated constructor stub
		super();
		this.conn = new ConnectData();
	}

	public Comment insert(Comment comment) {
		this.conn.condition.clear();
		this.conn.condition.put("user_id", comment.getUserId() + "");
		this.conn.condition.put("content", comment.getContent());
		if (comment.getCourseId() != 0)
			this.conn.condition.put("course_id", comment.getCourseId() + "");
		if (comment.getLectureId() != 0)
			this.conn.condition.put("lecture_id", comment.getLectureId() + "");
		if (comment.getAssignmentId() != 0)
			this.conn.condition.put("assignment_id", comment.getAssignmentId()
					+ "");
		this.conn.connectDatabase();
		int id = this.conn.insertData("comments");
		this.conn.closeDatabase();
		comment.setId(id);
		return comment;
	}

	public ArrayList<Comment> getComments(int type, int id) {
		this.conn.condition.clear();
		ArrayList<Comment> comments = new ArrayList<Comment>();
		if (type == COURSE) {
			this.conn.condition.put("course_id", "" + id);
		} else if (type == LECTURE) {
			this.conn.condition.put("lecture_id", "" + id);
		} else if (type == ASSIGNMENT) {
			this.conn.condition.put("assignment_id", "" + id);
		}
		ResultSet rs = this.conn.getResultSet("comments", "");
		try {
			while (rs.next()) {
				Comment comment = (Comment) setData(rs);
				comments.add(comment);
			}
			this.conn.closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return comments;
	}

	@Override
	public Model setData(ResultSet rs) throws SQLException {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setUserId(rs.getInt("user_id"));
		comment.setCourseId(rs.getInt("course_id"));
		comment.setLectureId(rs.getInt("lecture_id"));
		comment.setContent(rs.getString("content"));
		ServerUsers users = new ServerUsers();
		comment.setUser(users.getUser(comment.getUserId()));
		return comment;
	}

}
