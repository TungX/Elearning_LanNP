package com.hust.soict.elearning_lannp.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public interface LecturesServiceAsync {

	void add(Lecture lecture, AsyncCallback<Lecture> callback);

	void destroy(int lecture_id, AsyncCallback<Void> callback);

	void getLecture(int id, AsyncCallback<Lecture> callback);

	void update(Lecture lecture, AsyncCallback<Lecture> callback);

}
