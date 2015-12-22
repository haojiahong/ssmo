package com.hjh.ssmo.service.blog.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hjh.ssmo.mapper.blog.CategoryMapper;
import com.hjh.ssmo.model.blog.Category;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.service.blog.CategoryService;
import com.hjh.ssmo.util.cache.EhcacheUtil;

@Component("categoryService")
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> getCategoryList(HashMap<String, Object> paramMap, Pager<Category> pager) {
		List<Category> categoryList = null;
		int count = categoryMapper.getCategoryCount(paramMap);
		pager.setTotalCount(count);
		if (count > 0) {
			paramMap.put("start", pager.getStart());
			paramMap.put("limit", pager.getLimit());
			categoryList = categoryMapper.getCategoryList(paramMap);
		}
		return categoryList;
	}

	@Override
	public List<Category> getCategoryList() {
		List<Category> categoryList = (List<Category>) EhcacheUtil.get("defaultCache", "categoryList");
		if (categoryList == null) {
			categoryList = categoryMapper.getAllCategoryList();
			EhcacheUtil.put("defaultCache", "categoryList", categoryList);
		}
		return categoryList;
	}

	@Override
	public Category getCategoryById(String id) {
		return categoryMapper.getCategoryById(id);
	}

	@Override
	public int editCategory(Category category) {
		return categoryMapper.editCategory(category);
	}

	@Override
	public int addCategory(Category category) {
		return categoryMapper.addCategory(category);
	}

	@Override
	public int deleteCategory(String id) {
		return categoryMapper.deleteCategory(id);
	}
}
