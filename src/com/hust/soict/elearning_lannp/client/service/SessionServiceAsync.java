package com.hust.soict.elearning_lannp.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.shared.model.User;

public interface SessionServiceAsync {

	void loginFromSessionServer(AsyncCallback<User> callback);

	void loginServer(String email, String password, AsyncCallback<User> asyncCallback);

	void logout(AsyncCallback<Void> callback);

	void loginWithCookies(int id, String password, AsyncCallback<User> callback);

	void signup(User user, AsyncCallback<User> callback);

	void update(User user, AsyncCallback<User> callback);

}
