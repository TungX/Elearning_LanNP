package com.hust.soict.elearning_lannp.client.ui.comments;

import java.util.ArrayList;

import org.gwtbootstrap3.client.ui.PanelGroup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.hust.soict.elearning_lannp.client.event.EventOfComment;
import com.hust.soict.elearning_lannp.shared.model.Comment;

public class Comments extends Composite {

	private static CommentsUiBinder uiBinder = GWT
			.create(CommentsUiBinder.class);

	interface CommentsUiBinder extends UiBinder<Widget, Comments> {
	}

	public Comments() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	PanelGroup comments;
	@UiField
	CommentForm form;

	public void loadForm(EventOfComment event) {
		this.form.loadUser();
		event.setComments(this);
		this.form.setEvent(event);
	}

	public void addComment(Comment comment) {
		CommentItem item = new CommentItem();
		item.setUser(comment.getUser());
		item.setContent(comment.getContent());
		this.comments.add(item);
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments.clear();
		for (Comment comment : comments) {
			addComment(comment);
		}
	}

	public void clearForm() {
		this.form.clearTextBox();
	}

}
