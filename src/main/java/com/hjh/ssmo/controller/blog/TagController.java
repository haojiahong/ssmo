package com.hjh.ssmo.controller.blog;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.druid.util.StringUtils;
import com.hjh.ssmo.model.blog.Tag;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.service.blog.TagService;
import com.hjh.ssmo.util.JsonUtil;

@Controller
public class TagController {

	@Autowired
	private TagService tagService;

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
	 * 跳转新增页面
	 */
	@RequestMapping(value = "/admin/tag/addJump")
	public String addJump(HttpSession session, ModelMap map) {
		return "/admin/tag/add_tag";
	}
}
