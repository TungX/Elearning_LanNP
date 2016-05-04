package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.hust.soict.elearning_lannp.shared.model.Category;
@RemoteServiceRelativePath("categoriesservice")
public interface CategoriesService extends RemoteService {
	ArrayList<Category> getCategories();
	
	Category getCategory(int id);

	Category addCategory(Category category);

	Category updateCategory(Category category);

	boolean destroyCategory(Category category);
}
