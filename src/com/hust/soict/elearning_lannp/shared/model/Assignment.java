package com.hust.soict.elearning_lannp.shared.model;

public class Assignment extends Model {
	protected int id;
	protected String name;
	protected String description;
	protected Course course;
	protected int course_id;

	public Assignment(String name, String description, String deadline,
			int course_id) {
		this.name = name;
		this.description = description;
		this.course_id = course_id;
	}

	public Assignment() {
		this.description = "";
	}

	public Assignment(int course_id) {
		this.description = "";
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

	public int getCourseId() {
		return course_id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setCourseId(int course_id) {
		this.course_id = course_id;
	}

	@Override
	public boolean validate() {
		this.errors.clear();
		if (this.name.isEmpty())
			addError("name", "Assignment's name can't empty");
		if (this.description.isEmpty())
			addError("description", "Assignment's description can't empty");
		return this.errors.isEmpty();
	}

}
