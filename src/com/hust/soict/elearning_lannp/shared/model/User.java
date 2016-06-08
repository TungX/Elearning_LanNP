package com.hust.soict.elearning_lannp.shared.model;

import java.util.ArrayList;

public class User extends Model {
	protected int id;
	protected String email;
	protected String password;
	protected String password_confirm;
	protected String firstName;
	protected String lastName;
	protected String avatar;
	protected int type;
	private boolean isAutoLogin;
	private ArrayList<Integer> courseIds;

	public User(String email, String password, String password_confirm,
			String firstName, String lastName, int type) {
		super();
		this.email = email;
		this.password = password;
		this.password_confirm = password_confirm;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.isAutoLogin = false;
		this.courseIds = new ArrayList<Integer>();
	}

	public User() {
		super();
		this.isAutoLogin = false;
		this.courseIds = new ArrayList<Integer>();
	}

	public User(int id) {
		super();
		this.id = id;
		this.isAutoLogin = false;
		this.courseIds = new ArrayList<Integer>();
	}

	public void setInfo(String email, String password, String password_confirm,
			String name, int type, String filename) {
		this.email = email;
		this.password = password;
		this.password_confirm = password_confirm;
		this.firstName = name.substring(0, name.lastIndexOf(" "));
		this.lastName = name.substring(name.lastIndexOf(" ") + 1);
		this.type = type;
		this.avatar = "uploads/"
				+ filename.substring(filename.lastIndexOf("\\") + 1);
	}

	public ArrayList<Integer> getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(ArrayList<Integer> courseIds) {
		this.courseIds = courseIds;
	}

	public boolean isAutoLogin() {
		return isAutoLogin;
	}

	public void setAutoLogin(boolean isAutoLogin) {
		this.isAutoLogin = isAutoLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lasttName) {
		this.lastName = lasttName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPassword_confirm() {
		return password_confirm;
	}

	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}

	public String getDisplayName() {
		return this.firstName + " " + this.lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean validate() {
		this.errors.clear();
		if (this.email.isEmpty())
			this.errors.add("email error");
		if (this.lastName.isEmpty())
			return false;
		if (this.lastName.isEmpty())
			return false;
		if (this.password.compareTo(this.password_confirm) != 0)
			return false;
		return this.errors.isEmpty();
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isTeacher() {
		return this.type == 1;
	}

	public void addCourse(int course_id) {
		int index = this.courseIds.indexOf(course_id);
		if (index == -1) {
			this.courseIds.add(course_id);
		}
	}

	public void removeCourse(int course_id) {
		this.courseIds.remove((Integer) course_id);
	}
}
