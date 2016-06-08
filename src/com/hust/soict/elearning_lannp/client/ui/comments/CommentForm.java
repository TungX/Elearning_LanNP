package com.hust.soict.elearning_lannp.client.ui.comments;

import org.gwtbootstrap3.client.ui.*;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfComment;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.Comment;

public class CommentForm extends Composite {

	private static CommentFormUiBinder uiBinder = GWT
			.create(CommentFormUiBinder.class);
	private EventOfComment event;

	interface CommentFormUiBinder extends UiBinder<Widget, CommentForm> {
	}

	public CommentForm() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Image avatar;
	@UiField
	TextBox txtContent;
	@UiField
	Button btnSubmit;

	public void loadUser() {
		this.avatar.setUrl(Store.user.getAvatar());
	}

	public void setEvent(EventOfComment event) {
		this.event = event;
	}

	@UiHandler("btnSubmit")
	void onBtnSubmitClick(ClickEvent e) {
		String content = txtContent.getText();
		Comment comment = new Comment(Store.type, Store.id, Store.user, content);
		if (!comment.validate())
			return;
		event.comment(comment);
	}

	public void clearTextBox() {
		this.txtContent.clear();
	}
}
