package com.hjh.ssmo.controller.blog;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjh.ssmo.model.blog.Article;
import com.hjh.ssmo.model.blog.Category;
import com.hjh.ssmo.model.blog.Tag;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.model.view.Result;
import com.hjh.ssmo.service.blog.ArticleService;
import com.hjh.ssmo.service.blog.CategoryService;
import com.hjh.ssmo.service.blog.FriendService;
import com.hjh.ssmo.service.blog.TagService;
import com.hjh.ssmo.util.Constant;
import com.hjh.ssmo.util.JsonUtil;
import com.hjh.ssmo.util.listener.SystemListener;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private TagService tagService;

	@Autowired
	private FriendService friendService;

	/**
	 * 跳转文章列表
	 */
	@RequestMapping(value = "/admin/article/list")
	public String list(HttpSession session, ModelMap map) {

		// 栏目列表
		List<Category> categoryList = categoryService.getCategoryList();
		// 标签列表
		List<Tag> tagList = tagService.getTagList();

		map.put("categoryList", categoryList);
		map.put("tagList", tagList);
		return "/admin/article/article_list";
	}

	/**
	 * 获取文章分页列表
	 */
	@RequestMapping(value = "/admin/article/load")
	public String loadArticlePageList(HttpSession session, ModelMap map, String param, Pager<Article> pager) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		Article article = JsonUtil.fromJson(param, Article.class);
		paramMap.put("article", article);
		List<Article> articleList = articleService.getArticleList(paramMap, pager);
		map.put("articleList", articleList);
		map.put("pager", pager);
		return "/admin/article/article_pager_list";
	}

	/**
	 * 跳转文章新增页面
	 */
	@RequestMapping(value = "/admin/article/addJump")
	public String addJump(HttpSession session, ModelMap map) {

		// 栏目列表 链接栏目
		List<Category> categoryList = categoryService.getCategoryList();
		// 标签列表
		List<Tag> tagList = tagService.getTagList();

		map.put("categoryList", categoryList);
		map.put("tagList", tagList);
		return "/admin/article/add_article";
	}

	/**
	 * 添加文章
	 */
	@RequestMapping(value = "/admin/article/add")
	public @ResponseBody
	Result addArticle(String description, String content, String param, HttpSession session)
			throws UnsupportedEncodingException {
		param = URLDecoder.decode(param, "utf-8");
		content = URLDecoder.decode(content, "utf-8");
		description = URLDecoder.decode(description, "utf-8");
		Article article = JsonUtil.fromJson(param, Article.class);
		article.setContent(content);
		article.setDescription(description);
		if (articleService.addArticle(article) > 0) {
			// 提交百度链接收录
			// LinkCommitThread.addLink(String.valueOf(article.getId().intValue()));
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 删除文章
	 */
	@RequestMapping(value = "/admin/article/delete")
	public @ResponseBody
	Result deleteArticle(String id) {
		if (articleService.deleteArticle(id) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 跳转文章编辑页面
	 */
	@RequestMapping(value = "/admin/article/editJump/{id}")
	public String editJump(HttpSession session, ModelMap map, @PathVariable String id) {

		// 栏目列表 链接栏目
		List<Category> categoryList = categoryService.getCategoryList();
		// 标签列表
		List<Tag> allTagList = tagService.getTagList();

		Article article = articleService.getArticleById(id);
		List<Tag> tagList = tagService.getArticleTagList(id);

		map.put("article", article);
		map.put("categoryList", categoryList);
		map.put("tagList", tagList);
		map.put("allTagList", allTagList);
		map.put("articleId", id);
		return "/admin/article/edit_article";
	}

	/**
	 * 编辑文章
	 */
	@RequestMapping(value = "/admin/article/edit")
	public @ResponseBody
	Result editArticle(String description, String content, String param, HttpSession session)
			throws UnsupportedEncodingException {
		content = URLDecoder.decode(content, "utf-8");
		description = URLDecoder.decode(description, "utf-8");
		param = URLDecoder.decode(param, "utf-8");
		Article article = JsonUtil.fromJson(param, Article.class);
		article.setContent(content);
		article.setDescription(description);
		if (articleService.editArticle(article) > 0) {
			// 删除文章
			File file = new File(SystemListener.getContext().getRealPath("/") + "/html/" + article.getId().intValue());
			if (file.exists()) {
				file.delete();
			}
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 变更状态
	 */
	@RequestMapping(value = "/admin/article/updateStatue")
	public @ResponseBody
	Result updateStatue(Article article) {
		if (articleService.updateStatue(article) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

}
