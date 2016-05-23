package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hust.soict.elearning_lannp.shared.model.AttachFile;
import com.hust.soict.elearning_lannp.shared.model.Model;

public class ServerAttachFile extends AttachFile implements ServerModel {
	private ConnectData conn;

	public ServerAttachFile() {
		super();
		this.conn = new ConnectData();
	}

	public ArrayList<AttachFile> getAttachFilesOfLecture(int lecture_id) {
		ArrayList<AttachFile> attachFiles = new ArrayList<AttachFile>();
		this.conn.condition.put("lecture_id", "" + lecture_id);
		this.conn.connectDatabase();
		ResultSet rs = this.conn.getResultSet("attach_files", "");
		try {
			while (rs.next()) {
				AttachFile attachFile = (AttachFile) setData(rs);
				attachFiles.add(attachFile);
			}
			this.conn.closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return attachFiles;
	}

	public AttachFile update(AttachFile attachFile) {
		this.conn.condition.clear();
		this.conn.condition.put("name", attachFile.getName());
		this.conn.condition.put("path", attachFile.getPath());
		this.conn.connectDatabase();
		String queryplus = "id='" + attachFile.getId() + "'";
		boolean result = this.conn.updateData("attach_files", queryplus);
		if (result == false)
			return null;
		return attachFile;
	}
	
	public boolean delete(int attachfile_id) {
		this.conn.condition.clear();
		this.conn.condition.put("id", attachfile_id+"");
		this.conn.connectDatabase();
		return this.conn.delete("attach_files");
	}

	@Override
	public Model setData(ResultSet rs) throws SQLException {
		AttachFile attachFile = new AttachFile();
		attachFile.setId(rs.getInt("id"));
		attachFile.setName(rs.getString("name"));
		attachFile.setPath(rs.getString("path"));
		return attachFile;
	}

}
