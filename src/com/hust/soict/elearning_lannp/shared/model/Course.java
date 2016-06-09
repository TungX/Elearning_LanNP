package com.hust.soict.elearning_lannp.shared.model;

import java.util.ArrayList;

public class Course extends Model {
	protected int id;
	protected String name;
	protected String description;
	protected User user;
	protected String password;
	protected String homework;
	protected ArrayList<Lecture> lectures;
	protected ArrayList<Assignment> assignments;
	protected int user_id;

	@Override
	public boolean validate() {
		this.errors.clear();
		if (this.name.isEmpty())
			addError("name", "Course's name can't empty");
		if (this.description.isEmpty())
			addError("description", "Course's description can't empty");
		return this.errors.isEmpty();
	}

	public Course(int id) {
		this.id = id;
		this.name = "";
		this.description = "";
		this.password = "";
	}

	public Course() {
		this.name = "";
		this.description = "";
		this.password = "";
	}

	public void updateInfo(String name, String description) {
		this.name = name;
		this.description = description;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		setUserId(user.getId());
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHomework() {
		return homework;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}

	public ArrayList<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(ArrayList<Lecture> lectures) {
		this.lectures = lectures;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

}
