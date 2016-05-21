package com.hust.soict.elearning_lannp.shared.model;

public class Assignment extends Model {
	protected int id;
	protected String name;
	protected String description;
	protected String deadline;
	protected int course_id;
	
	public Assignment(String name, String description, String deadline, int course_id){
		this.name = name;
		this.description = description;
		this.deadline = deadline;
		this.course_id = course_id;
	}
	
	public Assignment(){
		
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

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String dateline) {
		this.deadline = dateline;
	}

	public int getCourseId() {
		return course_id;
	}

	public void setCourseId(int course_id) {
		this.course_id = course_id;
	}

	@Override
	protected boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

}
