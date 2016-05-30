package com.hust.soict.elearning_lannp.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hust.soict.elearning_lannp.client.service.AssignmentService;
import com.hust.soict.elearning_lannp.server.model.ServerAssinment;
import com.hust.soict.elearning_lannp.server.model.ServerCourses;
import com.hust.soict.elearning_lannp.shared.model.Assignment;

public class AssigmentsSeviceImpl extends RemoteServiceServlet implements AssignmentService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Assignment getAssignment(int id) {
		ServerAssinment assinments = new ServerAssinment();
		ServerCourses courses = new ServerCourses();
		Assignment assinment = assinments.getAssignment(id);
		assinment.setCourse(courses.getCourse(assinment.getCourseId()));
		return assinment;
	}

	@Override
	public ArrayList<Assignment> getAssignmentOfCourse(int course_id) {
		// TODO Auto-generated method stub
		ServerAssinment assinment = new ServerAssinment();
		return assinment.getAssignmentOfCourse(course_id);
	}

	@Override
	public ArrayList<Assignment> getAssignmentOfLecture(int lecture_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assignment addAssignment(Assignment assignment) {
		ServerAssinment assinments = new ServerAssinment();
		return assinments.insert(assignment);
	}

	@Override
	public Assignment updateAssignment(Assignment assignment) {
		ServerAssinment assinments = new ServerAssinment();
		return assinments.update(assignment);
	}

	@Override
	public void destroyAssigment(int id) {
		ServerAssinment assinments = new ServerAssinment();
		assinments.destroy(id);
	}

}
