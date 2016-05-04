package com.hust.soict.elearning_lannp.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hust.soict.elearning_lannp.shared.model.Category;

public class ServerCatgories extends Category {
	private ConnectData conn;

	public ServerCatgories() {
		super();
		this.conn = new ConnectData();
	}

	public ArrayList<Category> getCategories() {
		ArrayList<Category> categories = new ArrayList<Category>();
		this.conn.connectDatabase();
		ResultSet rs = this.conn.getResultSet("categories", "");
		try {
			while (rs.next()) {
				Category category = setData(rs);
				categories.add(category);
			}
			this.conn.closeDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return categories;
	}

	public Category getCategory(int id) {
		Category category = null;
		this.conn.connectDatabase();
		this.conn.condition.put("id", "" + id);
		ResultSet rs = this.conn.getResultSet("categories", "");
		try {
			rs.first();
			category = setData(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			category = null;
		}
		return category;
	}

	private Category setData(ResultSet rs) throws SQLException {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("name"));
		return category;
	}
}
