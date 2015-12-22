package com.hjh.ssmo.mapper.blog;

import java.util.HashMap;
import java.util.List;

import com.hjh.ssmo.model.blog.Category;

public interface CategoryMapper {

	int getCategoryCount(HashMap<String, Object> paramMap);

	List<Category> getCategoryList(HashMap<String, Object> paramMap);

	List<Category> getAllCategoryList();

	Category getCategoryById(String id);

	int addCategory(Category category);

	int editCategory(Category category);

	int deleteCategory(String id);

}
