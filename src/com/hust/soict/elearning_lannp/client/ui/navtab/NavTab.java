package com.hust.soict.elearning_lannp.client.ui.navtab;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.Elearning_LanNP;
import com.hust.soict.elearning_lannp.client.event.EventOfUser;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.login.LoginForm;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.client.ui.users.SignupForm;
import com.hust.soict.elearning_lannp.client.ui.users.UserProperty;
import com.hust.soict.elearning_lannp.shared.model.User;

public class NavTab extends Composite {
	private EventOfUser event;
	private LoginForm login;
	private UserProperty property;
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
	@UiField
	Image avatar;

	private static NavTabUiBinder uiBinder = GWT.create(NavTabUiBinder.class);

	interface NavTabUiBinder extends UiBinder<Widget, NavTab> {
	}

	public NavTab() {
		initWidget(uiBinder.createAndBindUi(this));
		event = new EventOfUser(null, this);
		this.login = new LoginForm(this);
		property = new UserProperty();
	}

	@UiHandler("urlProperty")
	void onUrlPropertyClick(ClickEvent e) {
		this.property.show();
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

	@UiHandler("urlEdit")
	void onUrlEditClick(ClickEvent e) {
		SignupForm signupForm = new SignupForm();
		this.event.setSignupForm(signupForm);
		signupForm.setEvent(this.event);
		signupForm.setTitle("Update " + Store.user.getDisplayName());
		signupForm.setUser(Store.user);
		signupForm.show();
	}

	public void setCourseIndex(CourseIndex courseIndex, Elearning_LanNP homepage) {
		this.event.setCourseIndex(courseIndex);
		this.event.setHomePage(homepage);
		this.login.setCourseIndex(courseIndex, homepage);
	}

	public void changeDisplayName(String displayName) {
		lbDisplayName.setText(displayName);
	}

	public void changeAvatar(String avatar) {
		this.avatar.setUrl(avatar);
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
		changeAvatar(user.getAvatar());
		urlProperty.setEnabled(true);
		urlEdit.setEnabled(true);
		urlLogout.setEnabled(true);
	}

}
