package com.hust.soict.elearning_lannp.client.ui.comments;

import org.gwtbootstrap3.client.ui.*;
import org.gwtbootstrap3.client.ui.html.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.shared.model.User;

public class CommentItem extends Composite {

	private static CommentItemUiBinder uiBinder = GWT
			.create(CommentItemUiBinder.class);

	interface CommentItemUiBinder extends UiBinder<Widget, CommentItem> {
	}

	public CommentItem() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Image avatar;
	@UiField
	Strong name;
	@UiField
	Text content;

	public void setUser(User user) {
		this.avatar.setUrl(user.getAvatar());
		this.name.setText(user.getDisplayName());
	}

	public void setContent(String content) {
		this.content.setText(content);
	}

}
