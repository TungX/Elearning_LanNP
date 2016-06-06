package com.hust.soict.elearning_lannp.client.event;

import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.Elearning_LanNP;
import com.hust.soict.elearning_lannp.client.service.SessionService;
import com.hust.soict.elearning_lannp.client.service.SessionServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.login.LoginForm;
import com.hust.soict.elearning_lannp.client.ui.navtab.NavTab;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.client.ui.users.SignupForm;
import com.hust.soict.elearning_lannp.shared.model.User;

public class EventOfUser {
	final private long DURATION = 1000 * 60 * 60 * 24 * 14;
	private SessionServiceAsync sessionService;
	private NavTab nav;
	private LoginForm form;
	private SignupForm signupForm;
	private User user;
	private CourseIndex courseIndex;
	private Elearning_LanNP homepage;

	public void setSignupForm(SignupForm form) {
		this.signupForm = form;
	}

	public void setCourseIndex(CourseIndex courseIndex) {
		this.courseIndex = courseIndex;
	}

	public void setHomePage(Elearning_LanNP homepage) {
		this.homepage = homepage;
	}

	public EventOfUser(LoginForm loginForm, NavTab nav) {
		sessionService = GWT.create(SessionService.class);
		this.nav = nav;
		this.form = loginForm;
		this.user = new User();
	}

	public void doUpdate(User user) {
		this.sessionService.update(user, new AsyncCallback<User>() {

			@Override
			public void onSuccess(User result) {
				// TODO Auto-generated method stub
				nav.setProperty(result);
				if (result.isAutoLogin()) {
					Date expires = new Date(System.currentTimeMillis() + DURATION);
					if (!result.getPassword().isEmpty())
						Cookies.setCookie("password", result.getPassword(), expires);
				}
				Store.setUser(result);
				signupForm.hide();
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void doCreate(User user) {
		this.sessionService.signup(user, new AsyncCallback<User>() {

			@Override
			public void onSuccess(User result) {
				// TODO Auto-generated method stub
				doLogin(result.getEmail(), result.getPassword(), false);
				signupForm.hide();
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void doLogin(String email, String password, boolean isAutoLogin) {
		if (isAutoLogin) {
			this.user.setAutoLogin(isAutoLogin);
			this.user.setPassword(password);
		}

		sessionService.loginServer(email, password, new AsyncCallback<User>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("errors, please check code");
			}

			@Override
			public void onSuccess(User result) {
				if (result == null) {
					Window.alert("can't login");
				} else {
					loadNavInfo(result);
					form.hideModal();
				}
			}
		});
	}

	public void autoLogin() {
		this.sessionService.loginFromSessionServer(new AsyncCallback<User>() {

			@Override
			public void onSuccess(User result) {
				// TODO Auto-generated method stub
				if (result != null) {
					loadUserInfo(result);
					loadCourseAdd();
					homepage.loadContent(History.getToken());
				} else {
					loginWithCookies();
				}
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				loginWithCookies();
			}
		});
	}

	public void loginWithCookies() {
		if (Cookies.getCookie("isAutoLogin") != "1") {
			Store.setUser(null);
			homepage.loadContent(History.getToken());
			return;
		}
		try {
			int id = Integer.parseInt(Cookies.getCookie("id"));
			String password = Cookies.getCookie("password");
			sessionService.loginWithCookies(id, password, new AsyncCallback<User>() {

				@Override
				public void onSuccess(User result) {
					// TODO Auto-generated method stub
					loadUserInfo(result);
					homepage.loadContent(History.getToken());
				}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					Store.setUser(null);
				}
			});
		} catch (Exception e) {
			Store.setUser(null);
		}
		loadCourseAdd();
		homepage.loadContent(History.getToken());
	}

	public void logout() {
		sessionService.logout(new AsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				nav.changeDisplayName("User");
				nav.disableProperty();
				nav.hideProperty();
				nav.showTagLogin();
				Store.setUser(null);
				Cookies.removeCookie("isAutoLogin");
				Cookies.removeCookie("id");
				Cookies.removeCookie("password");
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
		});
		Store.setCourse(null);
		Store.setUser(null);
		this.courseIndex.hideAddCourse();
		if (History.getToken().isEmpty()) {
			homepage.loadContent(History.getToken());
		} else {
			History.newItem("");
		}
	}

	public void join(int user_id, int course_id) {
		this.sessionService.join(user_id, course_id, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void leave(int user_id, int course_id) {
		this.sessionService.leave(user_id, course_id, new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void loadUserInfo(User user) {
		nav.hideTagLogin();
		nav.showProperty();
		nav.setProperty(user);
		Store.setUser(user);
	}

	private void loadCourseAdd() {
		try {
			if (Store.user.getType() != 1)
				this.courseIndex.hideAddCourse();
			else
				this.courseIndex.showAddCourse();
		} catch (Exception e) {
			this.courseIndex.hideAddCourse();
		}
	}

	private void loadNavInfo(User result) {
		nav.hideTagLogin();
		nav.showProperty();
		nav.setProperty(result);
		if (user.isAutoLogin()) {
			Date expires = new Date(System.currentTimeMillis() + DURATION);
			Cookies.setCookie("id", result.getId() + "", expires);
			Cookies.setCookie("password", user.getPassword(), expires);
			Cookies.setCookie("isAutoLogin", "1", expires);
		}
		user = result;
		Store.setUser(result);
		loadCourseAdd();
		homepage.loadContent(History.getToken());
	}

}
