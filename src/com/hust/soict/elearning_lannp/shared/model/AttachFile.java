package com.hust.soict.elearning_lannp.shared.model;

public class AttachFile extends Model {
	protected int id;
	protected String name;
	protected int user_id;
	protected int lecture_id;
	protected String path;

	public AttachFile() {

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

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public boolean validate() {
		this.errors.clear();
		if (this.name.isEmpty())
			addError("name", "Attach file's name can't empty");
		if (this.path.isEmpty())
			addError("path", "Attach file's path can't empty");
		return this.errors.isEmpty();
	}

	public int getLectureId() {
		return lecture_id;
	}

	public void setLectureId(int lecture_id) {
		this.lecture_id = lecture_id;
	}
}
