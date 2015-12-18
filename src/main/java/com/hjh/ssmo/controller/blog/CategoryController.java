package com.hjh.ssmo.controller.blog;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjh.ssmo.model.blog.Category;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.model.view.Result;
import com.hjh.ssmo.service.blog.CategoryService;
import com.hjh.ssmo.util.Constant;
import com.hjh.ssmo.util.JsonUtil;

/**
 * 栏目controller
 * 
 * @author haojiahong
 * 
 * @createtime：2015-12-18 上午11:11:55
 * 
 * 
 */
@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	/**
	 * 跳转列表
	 */
	@RequestMapping(value = "/admin/category/list")
	public String list(HttpSession session, ModelMap map) {
		return "/admin/category/category_list";
	}

	/**
	 * 获取分页列表
	 */
	@RequestMapping(value = "/admin/category/load")
	public String loadCategoryPageList(HttpSession session, ModelMap map, String param, Pager<Category> pager) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		Category category = JsonUtil.fromJson(param, Category.class);
		paramMap.put("category", category);
		List<Category> categoryList = categoryService.getCategoryList(paramMap, pager);
		map.put("categoryList", categoryList);
		map.put("pager", pager);
		return "/admin/category/category_pager_list";
	}

	/**
	 * 跳转添加页面
	 */
	@RequestMapping(value = "/admin/category/addJump")
	public String addJump(HttpSession session, ModelMap map) {
		return "/admin/category/add_category";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/admin/category/add")
	public @ResponseBody
	Result addCategory(Category category, HttpSession session) {
		if (categoryService.addCategory(category) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/admin/category/delete/{id}")
	public @ResponseBody
	Result deleteCategory(@PathVariable String id) {
		if (categoryService.deleteCategory(id) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 跳转编辑页面
	 */
	@RequestMapping(value = "/admin/category/editJump/{id}")
	public String editJump(HttpSession session, ModelMap map, @PathVariable String id) {
		Category category = categoryService.getCategoryById(id);
		map.put("category", category);
		map.put("categoryId", id);
		return "/admin/category/edit_category";
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/admin/category/edit")
	public @ResponseBody
	Result editTag(Category category, HttpSession session) {
		if (categoryService.editCategory(category) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

}
