package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.shared.model.AttachFile;
import com.hust.soict.elearning_lannp.shared.model.User;

public interface AttachFileServiceAsync {

	void getFileOfUser(User user, AsyncCallback<ArrayList<AttachFile>> callback);

	void uploadAttachFiles(User user, String name, AsyncCallback<Void> callback);

}
