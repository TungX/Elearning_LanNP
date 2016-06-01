package com.hust.soict.elearning_lannp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.hust.soict.elearning_lannp.client.event.EventOfLogin;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseShow;
import com.hust.soict.elearning_lannp.client.ui.navtab.NavTab;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.Course;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Elearning_LanNP implements EntryPoint {

	private CourseIndex courseIndex;
	private CourseShow courseShow;

	public void onModuleLoad() {
		NavTab navTab = new NavTab();
		this.courseShow = new CourseShow();
		EventOfLogin eventLogin = new EventOfLogin(null, navTab);
		eventLogin.loginWithCookies();
		courseIndex = new CourseIndex();
		RootPanel.get("header").add(navTab);
		loadContent(History.getToken());
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				String historyToken = event.getValue();
				loadContent(historyToken);
			}
		});

	}

	private void loadContent(String historyToken) {
		if (historyToken.isEmpty()) {
			RootPanel.get("wrapper").add(new CourseIndex());
			return;
		}

		// if (Store.user == null) {
		// History.newItem("");
		// Window.alert("Please login befor show it");
		// RootPanel.get("wrapper").add(courseIndex);
		// return;
		// }
		if (historyToken.matches("courses")) {
			RootPanel.get("wrapper").clear();
			RootPanel.get("wrapper").add(new CourseIndex());
		} else if (historyToken.matches("courses/[1-9]+")) {
			loadCourse(historyToken);
		} else if (historyToken.matches("courses/[1-9]+/lectures/[1-9]+")) {
			if (Store.course == null) {
				loadCourse(historyToken);
			}
			int id = Integer.parseInt(historyToken.split("/")[3]);
			courseShow.showLecture(Store.course, id);
		} else if (historyToken.matches("courses/[1-9]+/assignments/[1-9]+")) {
			if (Store.course == null) {
				loadCourse(historyToken);
			}
			int id = Integer.parseInt(historyToken.split("/")[3]);
			courseShow.showAssignment(id);
		}
	}

	private void loadCourse(String historyToken) {
		int id = Integer.parseInt(historyToken.split("/")[1]);
		RootPanel.get("wrapper").clear();
		RootPanel.get("wrapper").add(courseShow);
		courseShow.showCourse(id);
	}
}
