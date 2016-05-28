package com.hust.soict.elearning_lannp.shared.model;

import java.util.ArrayList;

public class Course extends Model {
	protected int id;
	protected String name;
	protected String description;
	protected User user;
	protected String password;
	protected String homework;
	protected Category category;
	protected ArrayList<Lecture> lectures;
	protected ArrayList<Assignment> assignments;

	@Override
	protected boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public Course(int id) {
		this.id = id;
	}

	public Course() {
	}
		
	public void updateInfo(String name, String description, String password){
		this.name = name;
		this.description = description;
		this.password = password;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

}
