package com.hust.soict.elearning_lannp.shared.model;

public class Category extends Model {
	protected int id;
	protected String name;

	public Category(int id) {
		this.id = id;
	}
	
	public Category() {
	}

	@Override
	protected boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
