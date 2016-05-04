package com.hust.soict.elearning_lannp.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FileServiceAsync {

	void deleteAttachement(String filePath, int caseID, String fieldName,
			AsyncCallback<Boolean> callback);

	void updateFileName(String name, AsyncCallback<String> callback);

	void uploadAttachement(String caseId, String fieldName, boolean isNewCase,
			AsyncCallback<String> callback);

}
