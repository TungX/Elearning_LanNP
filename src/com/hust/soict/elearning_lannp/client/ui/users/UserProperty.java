package com.hust.soict.elearning_lannp.client.ui.users;

import org.gwtbootstrap3.client.ui.Image;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.html.Text;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;

public class UserProperty extends Composite {

	private static UserPropertyUiBinder uiBinder = GWT.create(UserPropertyUiBinder.class);

	interface UserPropertyUiBinder extends UiBinder<Widget, UserProperty> {
	}

	public UserProperty() {
		initWidget(uiBinder.createAndBindUi(this));
		RootPanel.get().add(this);
	}

	@UiField
	Modal modalProperty;
	@UiField
	Text txtEmail;
	@UiField
	Text txtFirstName;
	@UiField
	Text txtLastName;
	@UiField
	Text txtType;
	@UiField
	Image avatar;

	public void show() {
		txtEmail.setText(Store.user.getEmail());
		txtFirstName.setText(Store.user.getFirstName());
		txtLastName.setText(Store.user.getLastName());
		avatar.setUrl(Store.user.getAvatar());
		String type;
		if (Store.user.getType() == 0)
			type = "Student";
		else
			type = "Teacher";
		txtType.setText(type);
		this.modalProperty.show();
	}

}
