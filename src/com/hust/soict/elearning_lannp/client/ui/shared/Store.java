package com.hust.soict.elearning_lannp.client.ui.shared;

import com.hust.soict.elearning_lannp.shared.model.User;

public class Store {
	public static User user;

	public static void setUser(User user) {
		Store.user = user;
	}
}
