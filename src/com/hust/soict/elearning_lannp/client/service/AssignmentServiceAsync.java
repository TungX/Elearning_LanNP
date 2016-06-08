package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.shared.model.Assignment;

public interface AssignmentServiceAsync {

	void addAssignment(Assignment assignment, AsyncCallback<Assignment> callback);

	void destroyAssigment(int id, AsyncCallback<Void> callback);

	void getAssignment(int id, AsyncCallback<Assignment> callback);

	void getAssignmentOfLecture(int lecture_id, AsyncCallback<ArrayList<Assignment>> callback);

	void updateAssignment(Assignment assignment, AsyncCallback<Assignment> callback);

}
