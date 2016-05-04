package com.hust.soict.elearning_lannp.client.service;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.hust.soict.elearning_lannp.shared.model.Category;

public interface CategoriesServiceAsync {

	void addCategory(Category category, AsyncCallback<Category> callback);

	void destroyCategory(Category category, AsyncCallback<Boolean> callback);

	void getCategories(AsyncCallback<ArrayList<Category>> callback);

	void getCategory(int id, AsyncCallback<Category> callback);

	void updateCategory(Category category, AsyncCallback<Category> callback);

}
