package com.hust.soict.elearning_lannp.server;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload();

		try {
			FileItemIterator iter = upload.getItemIterator(request);
			while (iter.hasNext()) {
				FileItemStream item = iter.next();
				String name = item.getFieldName();
				if (!name.equals("uploadFile"))
					continue;
				InputStream stream = item.openStream();

				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int len;
				byte[] buffer = new byte[8192];
				while ((len = stream.read(buffer, 0, buffer.length)) != -1) {
					out.write(buffer, 0, len);
				}
				FileOutputStream fos = new FileOutputStream(new File("uploads/"+item.getName()));
				out.writeTo(fos);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
