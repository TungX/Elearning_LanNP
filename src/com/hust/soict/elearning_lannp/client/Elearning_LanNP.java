package com.hust.soict.elearning_lannp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseIndex;
import com.hust.soict.elearning_lannp.client.ui.courses.CourseShow;
import com.hust.soict.elearning_lannp.client.ui.navtab.NavTab;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Elearning_LanNP implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	private final String extention = ".pdf";
	public void onModuleLoad() {
		NavTab navTab = new NavTab();
		
		// Course_index course_index = new Course_index();
		CourseShow course_show = new CourseShow();
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			public void onValueChange(ValueChangeEvent<String> event) {
				// String historyToken = event.getValue();
				try {
				} catch (IndexOutOfBoundsException e) {
				}
			}
		});
		final FormPanel formPanel;
		formPanel = new FormPanel();
		formPanel.setAction(GWT.getModuleBaseURL()+ "UploadFile");
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);

		RootPanel.get("header").add(navTab);
		// RootPanel.get("wrapper").add(course_show);
		// Create new Instance of vertical panel to align the widgets
		VerticalPanel vp = new VerticalPanel();

		// Add label
		vp.add(new HTML("<label>Choose file to Upload:</label>"));

		// Create new Instance of FileUpload
		final FileUpload fileUpload = new FileUpload();

		// Create button for submit
		Button uploadButton = new Button("Upload");

		// Add ClickHandler to the button
		uploadButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				// Get file name

				String filename = fileUpload.getFilename();

				// Check the length of the filename
				if (filename.length() != 0) {

					// Get the extention
					String fileExtention = filename.substring(filename.length()
							- extention.length(), filename.length());

					// Check if the extention is '.pdf'

					if (fileExtention.equals(extention)) {
						formPanel.submit();
					}
				} else
					Window.alert("No file choosen");
			}
		});
		formPanel
		.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
		 
		    @Override
		    public void onSubmitComplete(final SubmitCompleteEvent event) {
			// call upload method from service with the file's name
			String result = event.getResults();
			
		    }
		});

		// Add widgets to Vertical Panel
		vp.add(fileUpload);
		vp.add(uploadButton);
		RootPanel.get("wrapper").add(vp);

	}
}
