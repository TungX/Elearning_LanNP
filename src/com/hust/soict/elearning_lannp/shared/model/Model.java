package com.hust.soict.elearning_lannp.shared.model;

import java.util.HashMap;

import com.google.gwt.user.client.rpc.IsSerializable;

public abstract class Model implements IsSerializable {
	protected HashMap<String, String> errors;

	public Model() {
		this.errors = new HashMap<String, String>();
	}

	public abstract boolean validate();

	public HashMap<String, String> getErros() {
		return this.errors;
	}

	public void addError(String field, String error) {
		if (!this.errors.containsKey(field)) {
			this.errors.put(field, error);
		}
	}
}
