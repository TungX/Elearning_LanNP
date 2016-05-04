package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public interface LecturesServiceAsync {

	void addLecture(Lecture lecture, AsyncCallback<Lecture> callback);

	void destroyLecture(Lecture lecture, AsyncCallback<Boolean> callback);

	void getLecture(int id, AsyncCallback<Lecture> callback);

	void getLectures(int course_id,
			AsyncCallback<ArrayList<Lecture>> callback);

	void updateLecture(Lecture lecture, AsyncCallback<Lecture> callback);

}
