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
}
