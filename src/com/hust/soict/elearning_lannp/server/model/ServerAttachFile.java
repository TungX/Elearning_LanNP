package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hust.soict.elearning_lannp.shared.model.AttachFile;
import com.hust.soict.elearning_lannp.shared.model.Model;

public class ServerAttachFile extends AttachFile implements ServerModel{
	private ConnectData conn;
	
	public ServerAttachFile() {
		super();
		this.conn = new ConnectData();
	}
	
	
	@Override
	public Model setData(ResultSet rs) throws SQLException {
		AttachFile attachFile = new AttachFile();
		attachFile.setId(rs.getInt("id"));
		attachFile.setName(rs.getString("name"));
		attachFile.setPath(rs.getString("path"));
		attachFile.setTime(rs.getTime("time"));
		return attachFile;
	}

}
