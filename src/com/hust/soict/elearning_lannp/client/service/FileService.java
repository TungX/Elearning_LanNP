package com.hust.soict.elearning_lannp.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("UploadFile")
public interface FileService extends RemoteService {
	public String uploadAttachement(String caseId, String fieldName,
			boolean isNewCase);

	public boolean deleteAttachement(String filePath, int caseID,
			String fieldName);

	public String updateFileName(final String name);
}
