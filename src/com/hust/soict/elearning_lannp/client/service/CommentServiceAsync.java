package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.soict.elearning_lannp.shared.model.Comment;

@RemoteServiceRelativePath("commentsservice")
public interface CommentServiceAsync {

	void getComments(int type, int id,
			AsyncCallback<ArrayList<Comment>> callback);

	void insert(Comment comment, AsyncCallback<Comment> callback);

}
