package com.hust.soict.elearning_lannp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.hust.soict.elearning_lannp.client.event.EventOfLogin;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseShow;
import com.hust.soict.elearning_lannp.client.ui.navtab.NavTab;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.User;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.thirdparty.javascript.rhino.head.Undefined;
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
		EventOfLogin eventLogin = new EventOfLogin(null, navTab);
		eventLogin.loginWithCookies();
		courseIndex = new CourseIndex();
		RootPanel.get("header").add(navTab);
		RootPanel.get("wrapper").add(courseIndex);
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				String historyToken = event.getValue();
				if (historyToken.isEmpty()) {
					RootPanel.get("wrapper").add(courseIndex);
					return;
				}

				if (Store.user == null) {
					History.newItem("");
					Window.alert("Please login befor show it");
				}

				if (historyToken.matches("courses/[0-9]+")) {
					int id = Integer.parseInt(historyToken.split("/")[1]);
					RootPanel.get("wrapper").add(courseShow);
					courseShow.showCourse(id);
				}
			}
		});

	}
}
