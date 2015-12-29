package com.hjh.ssmo.controller.blog;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh.ssmo.model.blog.Category;
import com.hjh.ssmo.model.blog.Friend;
import com.hjh.ssmo.model.blog.Tag;
import com.hjh.ssmo.service.blog.ArticleService;
import com.hjh.ssmo.service.blog.CategoryService;
import com.hjh.ssmo.service.blog.FriendService;
import com.hjh.ssmo.service.blog.TagService;

@Controller
public class HomeController {
	@Autowired
	private ArticleService articleService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TagService tagService;

	@Autowired
	private FriendService friendService;

	@RequestMapping("/")
	public String home(HttpSession session, ModelMap map) {
		// 栏目列表
		List<Category> categoryList = categoryService.getCategoryList();
		// 标签列表
		List<Tag> tagList = tagService.getTagList();
		// 合作伙伴列表
		List<Friend> friendList = friendService.getAllFriendList();

		map.put("categoryList", categoryList);
		map.put("tagList", tagList);
		map.put("friendList", friendList);
		return "/blog/home";
	}
}
