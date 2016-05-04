package com.hust.soict.elearning_lannp.shared.model;

import java.sql.Time;

public class AttachFile extends Model{
	protected int id;
	protected String name;
	protected int user_id;
	protected String path;
	protected Time time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	protected boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
}
