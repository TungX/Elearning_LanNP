package com.hust.soict.elearning_lannp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseShow;
import com.hust.soict.elearning_lannp.client.ui.navtab.NavTab;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Elearning_LanNP implements EntryPoint {

	/**
	 * This is the entry point method.
	 */

	public void onModuleLoad() {
		NavTab navTab = new NavTab();
//		CourseIndex course_index = new CourseIndex();
		 CourseShow course_show = new CourseShow();
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				// String historyToken = event.getValue();
				try {
				} catch (IndexOutOfBoundsException e) {
				}
			}
		});
		RootPanel.get("header").add(navTab);
		RootPanel.get("wrapper").add(course_show);
	}
}
