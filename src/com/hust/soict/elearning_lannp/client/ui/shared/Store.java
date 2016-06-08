package com.hust.soict.elearning_lannp.client.ui.shared;

import com.hust.soict.elearning_lannp.shared.model.Course;
import com.hust.soict.elearning_lannp.shared.model.User;

public class Store {
	public static User user;
	public static Course course;
	public static int type;
	public static int id;

	public static void loadInfoComment(int type, int id) {
		Store.type = type;
		Store.id = id;
	}

	public static void setUser(User user) {
		Store.user = user;
	}

	public static void setCourse(Course course) {
		Store.course = course;
	}

	public static boolean isAdmin() {
		try {
			return Store.course.getUserId() == Store.user.getId();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isInCourse() {
		try {
			if (Store.user.getType() == 1)
				return false;
			return Store.user.getCourseIds().indexOf(Store.course.getId()) > -1;
		} catch (Exception e) {
			return false;
		}
	}
}
