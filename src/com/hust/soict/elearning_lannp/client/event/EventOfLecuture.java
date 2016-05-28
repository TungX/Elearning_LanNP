package com.hust.soict.elearning_lannp.client.event;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.LecturesService;
import com.hust.soict.elearning_lannp.client.service.LecturesServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseLeftBar;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseRightBar;
import com.hust.soict.elearning_lannp.client.ui.lectures.FormLecture;
import com.hust.soict.elearning_lannp.shared.model.Lecture;

public class EventOfLecuture {
	private LecturesServiceAsync lecturesServic;
	private FormLecture form;
	private CourseLeftBar leftBar;
	private CourseRightBar rightBar;
	public EventOfLecuture() {
		this.lecturesServic = GWT.create(LecturesService.class);
	}
	
	public void setForm(FormLecture form) {
		this.form = form;
	}
	
	public void setRightBar(CourseRightBar rightBar){
		this.rightBar = rightBar;
	}
	
	public void setLeftBar(CourseLeftBar leftBar) {
		this.leftBar = leftBar;
	}
	
	public void doCreate(String name, String description, String password, int course_id) {
		Lecture lecture = new Lecture(name, description, password, course_id);		
		lecturesServic.addLecture(lecture, new AsyncCallback<Lecture>() {
			
			@Override
			public void onSuccess(Lecture result) {
				form.hideModal();
				if(result == null){
					Window.alert("Error when insert");
				}else{
					leftBar.addLecture(result);
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("errors, please contact with us");
			}
		});
	}
	
	public void show(int lecture_id) {
		lecturesServic.getLecture(lecture_id, new AsyncCallback<Lecture>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Lecture result) {
				rightBar.setLecture(result);
			}
		});
	}
}
