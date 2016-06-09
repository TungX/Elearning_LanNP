package com.hust.soict.elearning_lannp.shared.model;

import java.util.HashMap;

import org.gwtbootstrap3.client.ui.html.Span;

import com.google.gwt.user.client.ui.Composite;

public abstract class FormInputAbastract extends Composite {
	public abstract void show();

	public abstract void hide();

	protected HashMap<String, Span> errors;

	protected void clearError() {
		for (String key : this.errors.keySet())
			this.errors.get(key).setText("");

	}

	protected void printError(HashMap<String, String> errors) {
		for (String key : errors.keySet()) {
			this.errors.get(key).setText(errors.get(key));
		}
	}
}
