package com.hust.soict.elearning_lannp.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hust.soict.elearning_lannp.client.service.FileService;

public class FileServiceImpl extends RemoteServiceServlet implements
		FileService {
	private FileItem uploadedFileItem;

	@Override
	public String uploadAttachement(String caseId, String fieldName,
			boolean isNewCase) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteAttachement(String filePath, int caseID,
			String fieldName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String updateFileName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void service(final HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean isMultiPart = ServletFileUpload
				.isMultipartContent(new ServletRequestContext(request));

		if (isMultiPart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			try {
				@SuppressWarnings("unchecked")
				List items = upload.parseRequest(request);
				uploadedFileItem = (FileItem) items.get(0); // we only upload one file

				if (uploadedFileItem == null) {
					super.service(request, response);
					return;
				} else if (uploadedFileItem.getFieldName().equalsIgnoreCase(
						"uploadFormElement")) {
					String fileName = uploadedFileItem.getName();
					response.setStatus(HttpServletResponse.SC_CREATED);
					response.getWriter().print("OK");
					response.flushBuffer();
				}

			} catch (FileUploadException e) {
				System.out.println(e.getMessage());
			}
		}

		else {
			super.service(request, response);
			return;
		}
	}

}
