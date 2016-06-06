package com.hust.soict.elearning_lannp.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.soict.elearning_lannp.shared.model.User;

@RemoteServiceRelativePath("sesionservice")
public interface SessionService extends RemoteService {
	User loginServer(String email, String password);

	User loginFromSessionServer();

	User loginWithCookies(int id, String password);

	void logout();

	User signup(User user);

	User update(User user);

	void join(int user_id, int course_id);

	void leave(int user_id, int course_id);
}
