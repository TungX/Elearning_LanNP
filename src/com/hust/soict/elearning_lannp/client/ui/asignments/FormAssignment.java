package com.hust.soict.elearning_lannp.client.ui.asignments;

import java.util.Date;

import org.gwtbootstrap3.client.ui.FormGroup;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

public class FormAssignment extends Composite {

	private static FormAssignmentUiBinder uiBinder = GWT.create(FormAssignmentUiBinder.class);

	interface FormAssignmentUiBinder extends UiBinder<Widget, FormAssignment> {
	}

	public FormAssignment() {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
		setFormatDatePicker();
	}

	@UiField
	Modal modalAddAssignment;
	@UiField
	TextBox dateBox;
	@UiField
	DatePicker datePicker;
	@UiField
	FormGroup formDatePicker;

	public void showModal() {
		this.modalAddAssignment.show();
	}

	public void hideModal() {
		this.modalAddAssignment.hide();
	}

	public void setTitleModal(String title) {
		this.modalAddAssignment.setTitle(title);
	}

	@UiHandler("dateBox")
	void onDateBoxClick(ClickEvent e) {
		this.formDatePicker.setVisible(true);
	}
	
	@UiHandler("datePicker")
	void onDatePickerSelect(ValueChangeEvent<Date> e) {
		Date date = e.getValue();
		@SuppressWarnings("deprecation")
		String dateString = DateTimeFormat.getShortDateFormat().format(date);
		this.dateBox.setText(dateString);
		this.formDatePicker.setVisible(false);
	}

	private void setFormatDatePicker() {
		this.datePicker.setYearArrowsVisible(true);
		this.datePicker.setValue(new Date(), true);
	}
}