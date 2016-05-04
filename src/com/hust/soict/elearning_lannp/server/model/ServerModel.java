package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hust.soict.elearning_lannp.shared.model.Model;

public interface ServerModel {
	public Model setData(ResultSet rs) throws SQLException;
}
