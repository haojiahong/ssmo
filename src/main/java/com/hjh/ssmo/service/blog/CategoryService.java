package com.hjh.ssmo.service.blog;

import java.util.HashMap;
import java.util.List;

import com.hjh.ssmo.model.blog.Category;
import com.hjh.ssmo.model.view.Pager;

public interface CategoryService {

	public List<Category> getCategoryList(HashMap<String, Object> paramMap, Pager<Category> pager);

	public Category getCategoryById(String id);

	public int editCategory(Category category);

	public int addCategory(Category category);

	public int deleteCategory(String id);

}
