package com.hust.soict.elearning_lannp.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

@RemoteServiceRelativePath("lecturesservice")
public interface LecturesService extends RemoteService {
	Lecture getLecture(int id);

	Lecture add(Lecture lecture);

	Lecture update(Lecture lecture);

	void destroy(int lecture_id);
}
