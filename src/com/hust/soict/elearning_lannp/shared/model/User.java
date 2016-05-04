package com.hust.soict.elearning_lannp.shared.model;

public class User extends Model {
	protected int id;
	protected String email;
	protected String password;
	protected String password_confirm;
	protected String firstName;
	protected String lasttName;
	protected int type;

	public User(String email, String password, String password_confirm,
			String firstName, String lastName, int type) {
		super();
		this.email = email;
		this.password = password;
		this.password_confirm = password_confirm;
		this.firstName = firstName;
		this.lasttName = lastName;
		this.type = type;
	}

	public User() {
		super();
	}
	
	public User(int id) {
		super();
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getPassword_confirm() {
		return password_confirm;
	}

	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}

	public String getDisplayName() {
		return this.firstName + " " + this.lasttName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	protected boolean validate() {
		this.errors.clear();
		if (this.email.isEmpty())
			this.errors.add("email error");
		if (this.lasttName.isEmpty())
			return false;
		if (this.lasttName.isEmpty())
			return false;
		if (this.password.compareTo(this.password_confirm) != 0)
			return false;
		return this.errors.isEmpty();
	}
}
