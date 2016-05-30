package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hust.soict.elearning_lannp.shared.model.Assignment;
import com.hust.soict.elearning_lannp.shared.model.Model;

public class ServerAssinment extends Assignment implements ServerModel {
	private ConnectData conn;

	public ServerAssinment() {
		this.conn = new ConnectData();
	}

	public Assignment insert(Assignment assignment) {
		Assignment result = assignment;
		this.conn.condition.clear();
		this.conn.condition.put("name", result.getName());
		this.conn.condition.put("description", result.getDescription());
		this.conn.condition.put("course_id", "" + result.getCourseId());
		int id = this.conn.insertData("assignments");
		if (id == 0) {
			result = null;
		} else {
			result.setId(id);
		}
		return result;
	}

	public void destroy(int id) {
		this.conn.condition.clear();
		this.conn.condition.put("id", "" + id);
		this.conn.delete("assignments");
		try {
			this.conn.closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Assignment update(Assignment assignment) {
		this.conn.condition.clear();
		this.conn.condition.put("name", assignment.getName());
		this.conn.condition.put("description", assignment.getDescription());
		String queryplus = "id='" + assignment.getId() + "'";
		boolean result = this.conn.updateData("assignments", queryplus);
		if (result == false)
			return null;
		return assignment;
	}

	public void destroyWithCourse(int course_id) {
		this.conn.condition.clear();
		this.conn.condition.put("course_id", "" + course_id);
		this.conn.delete("assignments");
	}

	public Assignment getAssignment(int id) {
		Assignment assignment = null;
		this.conn.condition.clear();
		this.conn.condition.put("id", "" + id);
		ResultSet rs = this.conn.getResultSet("assignments", "");
		try {
			rs.first();
			assignment = (Assignment) setData(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return assignment;
	}

	public ArrayList<Assignment> getAssignmentOfCourse(int course_id) {
		ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		this.conn.condition.put("course_id", "" + course_id);
		this.conn.connectDatabase();
		ResultSet rs = this.conn.getResultSet("assignments", "");
		try {
			while (rs.next()) {
				Assignment assignment = (Assignment) setData(rs);
				assignments.add(assignment);
			}
			this.conn.closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return assignments;
	}

	@Override
	public Model setData(ResultSet rs) throws SQLException {
		Assignment assignment = new Assignment();
		assignment.setId(rs.getInt("id"));
		assignment.setCourseId(rs.getInt("course_id"));
		assignment.setName(rs.getString("name"));
		assignment.setDescription(rs.getString("description"));
		return assignment;
	}

}
