package com.hust.soict.elearning_lannp.shared.model;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.IsSerializable;

public abstract class Model implements IsSerializable {
	protected ArrayList<String> errors;
	
	public Model(){
		this.errors = new ArrayList<String>();
	}

	protected abstract boolean validate();

	public ArrayList<String> getErros() {
		return this.errors;
	}
}
