package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.soict.elearning_lannp.shared.model.Comment;
@RemoteServiceRelativePath("commentsservice")
public interface CommentService extends RemoteService {
	ArrayList<Comment> getComments(int type, int id);

	Comment insert(Comment comment);
}
