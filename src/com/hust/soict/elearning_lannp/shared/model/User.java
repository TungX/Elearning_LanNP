package com.hust.soict.elearning_lannp.shared.model;

public class User extends Model {
	protected int id;
	protected String email;
	protected String password;
	protected String password_confirm;
	protected String firstName;
	protected String lasttName;
	protected String avatar;
	protected int type;
	private boolean isAutoLogin;

	public User(String email, String password, String password_confirm, String firstName, String lastName, int type) {
		super();
		this.email = email;
		this.password = password;
		this.password_confirm = password_confirm;
		this.firstName = firstName;
		this.lasttName = lastName;
		this.type = type;
		this.isAutoLogin = false;
	}

	public User() {
		super();
		this.isAutoLogin = false;
	}

	public User(int id) {
		super();
		this.id = id;
		this.isAutoLogin = false;
	}

	public void setInfo(String email, String password, String password_confirm, String name, int type,
			String filename) {
		this.email = email;
		this.password = password;
		this.password_confirm = password_confirm;
		this.firstName = name.substring(0, name.lastIndexOf(" "));
		this.lasttName = name.substring(name.lastIndexOf(" ") + 1);
		this.type = type;
		this.avatar = "uploads/" + filename.substring(filename.lastIndexOf("\\") + 1);
	}

	public boolean isAutoLogin() {
		return isAutoLogin;
	}

	public void setAutoLogin(boolean isAutoLogin) {
		this.isAutoLogin = isAutoLogin;
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

	public String getLastName() {
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
