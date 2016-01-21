package com.hjh.ssmo.controller.blog;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjh.ssmo.model.blog.Article;
import com.hjh.ssmo.model.blog.Tag;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.model.view.Result;
import com.hjh.ssmo.service.blog.ArticleService;
import com.hjh.ssmo.service.blog.TagService;
import com.hjh.ssmo.util.Constant;
import com.hjh.ssmo.util.JsonUtil;
import com.hjh.ssmo.util.SsmoCommonUtil;

@Controller
public class TagController {

	@Autowired
	private TagService tagService;
	@Autowired
	private ArticleService articleService;

	/**
	 * 跳转列表
	 */
	@RequestMapping(value = "/admin/tag/list")
	public String list(HttpSession session, ModelMap map) {
		return "/admin/tag/tag_list";
	}

	/**
	 * 获取分页列表
	 */
	@RequestMapping(value = "/admin/tag/load")
	public String loadTagPageList(HttpSession session, ModelMap map, String param, Pager<Tag> pager)
			throws UnsupportedEncodingException {

		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		Tag tag = JsonUtil.fromJson(param, Tag.class);
		if (!StringUtils.isEmpty(tag.getTagName())) {
			tag.setTagName(URLDecoder.decode(tag.getTagName(), "utf-8"));
		}
		paramMap.put("tag", tag);
		List<Tag> tagList = tagService.getTagList(paramMap, pager);
		map.put("tagList", tagList);
		map.put("pager", pager);
		return "/admin/tag/tag_pager_list";
	}

	/**
	 * 跳转编辑页面
	 */
	@RequestMapping(value = "/admin/tag/editJump/{id}")
	public String editJump(HttpSession session, ModelMap map, @PathVariable String id) {
		Tag tag = tagService.getTagById(id);
		map.put("tag", tag);
		map.put("tagId", id);
		return "/admin/tag/edit_tag";
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/admin/tag/edit")
	public @ResponseBody
	Result editTag(Tag tag, HttpSession session) {
		if (tagService.editTag(tag) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 跳转添加页面
	 */
	@RequestMapping(value = "/admin/tag/addJump")
	public String addJump(HttpSession session, ModelMap map) {
		return "/admin/tag/add_tag";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/admin/tag/add")
	public @ResponseBody
	Result addTag(Tag tag, HttpSession session) throws UnsupportedEncodingException {
		tag.setTagName(URLDecoder.decode(tag.getTagName(), "utf-8"));
		if (tagService.addTag(tag) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/admin/tag/delete/{id}")
	public @ResponseBody
	Result deleteTag(@PathVariable String id) {
		if (tagService.deleteTag(id) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 获取文章分页列表
	 */
	@RequestMapping(value = "/tag/loadPage/{tagId}/{articleId}")
	public String loadPage(HttpSession session, ModelMap map, @PathVariable String articleId, @PathVariable String tagId)
			throws UnsupportedEncodingException {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tagId", tagId);
		paramMap.put("articleId", articleId);
		// 最新的文章列表
		List<Article> articleList = tagService.getLastTagArticleList(paramMap);
		if (!SsmoCommonUtil.isEmptyCollection(articleList)) {
			int i = 1;
			for (Article article : articleList) {
				// 获取标签
				List<Tag> tList = tagService.getArticleTagList(String.valueOf(article.getId()));
				article.setTagList(tList);
				// 获取图片
//				String imageUrl = articleService.getArticleImageUrl(String.valueOf(article.getId()));
//				article.setImageUrl(imageUrl);

				if (i == articleList.size()) {
					map.put("articleId", article.getId());
				}
				i++;
			}
		}
		map.put("articleList", articleList);
		return "/blog/tag/article_pager";
	}

}
