package com.hust.soict.elearning_lannp.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hust.soict.elearning_lannp.client.service.LecturesService;
import com.hust.soict.elearning_lannp.server.model.ServerLectures;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public class LecturesServiceImpl extends RemoteServiceServlet implements
		LecturesService {

	private static final long serialVersionUID = 1L;

	@Override
	public Lecture getLecture(int id) {
		ServerLectures lectures = new ServerLectures();
		return lectures.getLecture(id);
	}

	@Override
	public ArrayList<Lecture> getLectures(int course_id) {
		// TODO Auto-generated method stub
		ServerLectures lectures = new ServerLectures();
		return lectures.getLectures(course_id);
	}

	@Override
	public Lecture add(Lecture lecture) {
		ServerLectures lectures = new ServerLectures();
		return lectures.insertLecuture(lecture);
	}

	@Override
	public Lecture update(Lecture lecture) {
		ServerLectures lectures = new ServerLectures();
		return lectures.update(lecture);
	}

	@Override
	public void destroy(int lecture_id) {
		ServerLectures lectures = new ServerLectures();
		lectures.destroy(lecture_id);
	}

}
