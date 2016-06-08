package com.hust.soict.elearning_lannp.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hust.soict.elearning_lannp.client.service.CommentService;
import com.hust.soict.elearning_lannp.server.model.ServerComment;
import com.hust.soict.elearning_lannp.shared.model.Comment;

public class CommentsSeviceImpl extends RemoteServiceServlet implements
		CommentService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<Comment> getComments(int type, int id) {
		ServerComment comments = new ServerComment();
		return comments.getComments(type, id);
	}

	@Override
	public Comment insert(Comment comment) {
		ServerComment comments = new ServerComment();
		return comments.insert(comment);
	}

}
