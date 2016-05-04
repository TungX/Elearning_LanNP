package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

@RemoteServiceRelativePath("lecturesservice")
public interface LecturesService extends RemoteService {
	Lecture getLecture(int id);

	ArrayList<Lecture> getLectures(int course_id);

	Lecture addLecture(Lecture lecture);

	Lecture updateLecture(Lecture lecture);

	boolean destroyLecture(Lecture lecture);
}
