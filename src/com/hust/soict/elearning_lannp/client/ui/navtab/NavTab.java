package com.hust.soict.elearning_lannp.client.ui.navtab;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfLogin;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.login.LoginForm;
import com.hust.soict.elearning_lannp.shared.model.User;

public class NavTab extends Composite {
	private EventOfLogin event;
	private LoginForm login;
	@UiField
	AnchorListItem btnCourses;
	@UiField
	NavbarLink urlLogin;
	@UiField
	AnchorListItem urlProperty;
	@UiField
	AnchorListItem urlEdit;
	@UiField
	AnchorListItem urlLogout;
	@UiField
	AnchorButton lbDisplayName;
	@UiField
	NavbarNav tagLogin;
	@UiField
	NavbarNav tagProperty;

	private static NavTabUiBinder uiBinder = GWT.create(NavTabUiBinder.class);

	interface NavTabUiBinder extends UiBinder<Widget, NavTab> {
	}

	public NavTab() {
		initWidget(uiBinder.createAndBindUi(this));
		event = new EventOfLogin(null, this);
		this.login = new LoginForm(this);
	}

	@UiHandler("btnCourses")
	void onBtnCoursesClick(ClickEvent e) {
	}

	public void hideProperty() {
		tagProperty.setVisible(false);
	}

	public void showProperty() {
		tagProperty.setVisible(true);
	}

	@UiHandler("urlLogin")
	void onUrlLoginClick(ClickEvent e) {

		login.showModal();
	}

	@UiHandler("urlLogout")
	void onUrlLogoutClick(ClickEvent e) {
		this.event.logout();
	}

	public void setCourseIndex(CourseIndex courseIndex) {
		this.event.setCourseIndex(courseIndex);
		this.login.setCourseIndex(courseIndex);
	}

	public void changeDisplayName(String displayName) {
		lbDisplayName.setText(displayName);
	}

	public void disableProperty() {
		urlProperty.setEnabled(false);
		urlEdit.setEnabled(false);
		urlLogout.setEnabled(false);
	}

	public void showTagLogin() {
		tagLogin.setVisible(true);
	}

	public void hideTagLogin() {
		tagLogin.setVisible(false);
	}

	public void setProperty(User user) {
		changeDisplayName(user.getDisplayName());
		urlProperty.setEnabled(true);
		urlProperty.setHref("#users/" + user.getId());
		urlEdit.setEnabled(true);
		urlProperty.setHref("#users/edit/" + user.getId());
		urlLogout.setEnabled(true);
	}

}
