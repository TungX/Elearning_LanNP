package com.hust.soict.elearning_lannp.client.event;

import java.util.ArrayList;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.client.service.CommentService;
import com.hust.soict.elearning_lannp.client.service.CommentServiceAsync;
import com.hust.soict.elearning_lannp.client.ui.comments.Comments;
import com.hust.soict.elearning_lannp.client.ui.shared.Store;
import com.hust.soict.elearning_lannp.shared.model.Comment;

public class EventOfComment {
	private CommentServiceAsync commentServiceAsync;
	private Comments comments;

	public EventOfComment() {
		this.commentServiceAsync = GWT.create(CommentService.class);
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public void comment(Comment comment) {
		this.commentServiceAsync.insert(comment, new AsyncCallback<Comment>() {

			@Override
			public void onSuccess(Comment result) {
				// TODO Auto-generated method stub
				comments.addComment(result);
				comments.clearForm();
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

	public void loadComment() {
		this.commentServiceAsync.getComments(Store.type, Store.id,
				new AsyncCallback<ArrayList<Comment>>() {

					@Override
					public void onSuccess(ArrayList<Comment> result) {
						// TODO Auto-generated method stub
						comments.setComments(result);
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}
				});
	}
}
