package com.hust.soict.elearning_lannp.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hust.soict.elearning_lannp.client.service.AttachFileService;
import com.hust.soict.elearning_lannp.server.model.ServerAttachFile;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;
import com.hust.soict.elearning_lannp.shared.model.User;

public class AttachFilesSeviceImpl extends RemoteServiceServlet implements AttachFileService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void uploadAttachFiles(User user, String name) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<AttachFile> getFileOfUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AttachFile> getFileOfLecture(int lecture_id) {
		ServerAttachFile attachFileS = new ServerAttachFile();
		return attachFileS.getAttachFilesOfLecture(lecture_id);
	}

	@Override
	public AttachFile update(AttachFile file) {
		ServerAttachFile attachFileS = new ServerAttachFile();
		return attachFileS.update(file);
	}

	@Override
	public boolean destroy(int attachfile_id) {
		ServerAttachFile attachFileS = new ServerAttachFile();
		return attachFileS.destroy(attachfile_id);
	}

}
