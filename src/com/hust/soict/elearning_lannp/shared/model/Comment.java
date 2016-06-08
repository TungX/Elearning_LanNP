package com.hust.soict.elearning_lannp.shared.model;

public class Comment extends Model {
	private int id;
	private int user_id;
	private int course_id;
	private int lecture_id;
	private int assignment_id;
	private User user;
	private String content;
	public static final int COURSE = 0;
	public static final int LECTURE = 1;
	public static final int ASSIGNMENT = 2;

	public Comment() {
	}

	public Comment(int type, int id, User user, String content) {
		switch (type) {
		case Comment.COURSE: {
			this.course_id = id;
			break;
		}
		case Comment.LECTURE: {
			this.lecture_id = id;
			break;
		}
		case Comment.ASSIGNMENT: {
			this.assignment_id = id;
			break;
		}
		default:
			break;
		}
		this.content = content;
		this.user_id = user.getId();
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return user_id;
	}

	public int getCourseId() {
		return course_id;
	}

	public int getLectureId() {
		return lecture_id;
	}

	public int getAssignmentId() {
		return assignment_id;
	}

	public String getContent() {
		return content;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public void setCourseId(int course_id) {
		this.course_id = course_id;
	}

	public void setLectureId(int lecture_id) {
		this.lecture_id = lecture_id;
	}

	public void setAssignmentId(int assignment_id) {
		this.assignment_id = assignment_id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public boolean validate() {
		if (this.content.replace("\\s", "").isEmpty())
			return false;
		return true;
	}
}
