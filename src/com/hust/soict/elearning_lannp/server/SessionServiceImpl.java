package com.hust.soict.elearning_lannp.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hust.soict.elearning_lannp.client.service.SessionService;
import com.hust.soict.elearning_lannp.server.model.ServerUserInCourses;
import com.hust.soict.elearning_lannp.server.model.ServerUsers;
import com.hust.soict.elearning_lannp.shared.model.User;

public class SessionServiceImpl extends RemoteServiceServlet implements SessionService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public User loginServer(String email, String password) {
		ServerUsers suser = new ServerUsers(email, password);
		User user = getUserAlreadyFromSession();
		if (user == null)
			storeUserInSession(suser.getUserFromServer());
		return getUserAlreadyFromSession();
	}

	@Override
	public User loginFromSessionServer() {
		return getUserAlreadyFromSession();
	}

	@Override
	public void logout() {
		deleteUserFromSession();
	}

	private User getUserAlreadyFromSession() {
		User user = null;
		HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
		HttpSession session = httpServletRequest.getSession();
		Object userObj = session.getAttribute("user");
		if (userObj != null && userObj instanceof User) {
			user = (User) userObj;
		}
		return user;
	}

	private void storeUserInSession(User user) {
		HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
		HttpSession session = httpServletRequest.getSession(true);
		session.setAttribute("user", user);
	}

	private void deleteUserFromSession() {
		HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
		HttpSession session = httpServletRequest.getSession();
		session.removeAttribute("user");
		System.out.println(session.getAttribute("user"));
	}

	@Override
	public User loginWithCookies(int id, String password) {
		ServerUsers suser = new ServerUsers();
		User user = suser.getUser(id, password);
		storeUserInSession(user);
		return user;
	}

	@Override
	public User signup(User user) {
		ServerUsers suser = new ServerUsers();
		return suser.insert(user);
	}

	@Override
	public User update(User user) {
		ServerUsers suser = new ServerUsers();
		return suser.update(user);
	}

	@Override
	public void join(int user_id, int course_id) {
		ServerUserInCourses users = new ServerUserInCourses();
		users.joinCourse(user_id, course_id);
		updateCourseInUser(users);
	}

	@Override
	public void leave(int user_id, int course_id) {
		ServerUserInCourses users = new ServerUserInCourses();
		users.leaveCourse(user_id, course_id);
		updateCourseInUser(users);
	}

	private void updateCourseInUser(ServerUserInCourses users) {
		HttpServletRequest httpServletRequest = this.getThreadLocalRequest();
		HttpSession session = httpServletRequest.getSession();
		User user = (User) session.getAttribute("user");
		if (user != null) {
			user.setCourseIds(users.getCourses(user.getId()));
		}
		session.setAttribute("user", user);
	}
}
