package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.soict.elearning_lannp.shared.model.Assignment;

@RemoteServiceRelativePath("assignmentsservice")
public interface AssignmentService extends RemoteService {
	Assignment getAssignment(int id);

	ArrayList<Assignment> getAssignmentOfLecture(int lecture_id);

	Assignment addAssignment(Assignment assignment);

	Assignment updateAssignment(Assignment assignment);

	void destroyAssigment(int id);
}
