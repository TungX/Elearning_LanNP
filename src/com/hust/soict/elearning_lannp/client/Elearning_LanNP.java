package com.hust.soict.elearning_lannp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.hust.soict.elearning_lannp.client.event.EventOfUser;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseShow;
import com.hust.soict.elearning_lannp.client.ui.navtab.NavTab;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Elearning_LanNP implements EntryPoint {

	private CourseShow courseShow;
	private CourseIndex courseIndex;

	public void onModuleLoad() {
		NavTab navTab = new NavTab();
		this.courseShow = new CourseShow();
		this.courseIndex = new CourseIndex();
		navTab.setCourseIndex(courseIndex, this);
		RootPanel.get("header").add(navTab);
		EventOfUser eventLogin = new EventOfUser(null, navTab);
		eventLogin.setCourseIndex(courseIndex);
		eventLogin.setHomePage(this);
		eventLogin.autoLogin();

		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				String historyToken = event.getValue();
				loadContent(historyToken);
			}
		});
	}

	public void loadContent(String historyToken) {
		if (historyToken.isEmpty()) {
			RootPanel.get("wrapper").clear();
			try {
				RootPanel.get("wrapper").add(this.courseIndex.loadCourse(Store.user.getId()));
			} catch (Exception e) {
				RootPanel.get("wrapper").add(this.courseIndex.loadCourse());
			}
			return;
		}

		if (historyToken.matches("courses")) {
			RootPanel.get("wrapper").clear();
			RootPanel.get("wrapper").add(this.courseIndex.loadCourse());
			return;
		}

		if (Store.user == null) {
			Window.alert("please login before show it!");
			History.newItem("");
			return;
		}

		if (historyToken.matches("courses/[1-9]+")) {
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
