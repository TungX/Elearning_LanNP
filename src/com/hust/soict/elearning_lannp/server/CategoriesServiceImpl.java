package com.hust.soict.elearning_lannp.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.hust.soict.elearning_lannp.client.service.CategoriesService;
import com.hust.soict.elearning_lannp.server.model.ServerCatgories;
import com.hust.soict.elearning_lannp.shared.model.Category;

public class CategoriesServiceImpl extends RemoteServiceServlet implements
		CategoriesService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ArrayList<Category> getCategories() {
		ServerCatgories sCategory = new ServerCatgories();
		return sCategory.getCategories();
	}

	@Override
	public Category getCategory(int id) {
		ServerCatgories sCategory = new ServerCatgories();
		return sCategory.getCategory(id);
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroyCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
