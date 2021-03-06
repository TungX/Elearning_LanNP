package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;
import com.hust.soict.elearning_lannp.shared.model.User;

@RemoteServiceRelativePath("attachfileservice")
public interface AttachFileService extends RemoteService {
	void uploadAttachFiles(User user, String name);

	ArrayList<AttachFile> getFileOfUser(User user);

	AttachFile update(AttachFile file);

	void destroy(int attachfile_id);

	AttachFile add(AttachFile file);
}
