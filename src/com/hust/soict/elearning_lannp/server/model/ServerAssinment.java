package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hust.soict.elearning_lannp.shared.model.Assignment;
import com.hust.soict.elearning_lannp.shared.model.Model;

public class ServerAssinment extends Assignment implements ServerModel{
	private ConnectData conn;
	public ServerAssinment() {
		this.conn = new ConnectData();
	}
	
	public ArrayList<Assignment> getAssignmentOfCourse(int course_id){
		ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		this.conn.condition.put("course_id", ""+course_id);
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
		assignment.setDeadline(rs.getDate("deadline"));
		assignment.setName(rs.getString("name"));
		assignment.setDescription(rs.getString("description"));
		return assignment;
	}

}
