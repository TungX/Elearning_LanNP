package com.hust.soict.elearning_lannp.shared.model;

public class Lecture extends Model {
	protected int id;
	protected String name;
	protected String description;
	protected String password;
	protected int course_id;

	@Override
	protected boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public Lecture(String name, String description, String password, int course_id) {
		super();
		this.name = name;
		this.description = description;
		this.password = password;
		this.course_id = course_id;
	}
	
	public Lecture() {
		
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCourseId() {
		return course_id;
	}

	public void setCourseId(int course_id) {
		this.course_id = course_id;
	}
}
