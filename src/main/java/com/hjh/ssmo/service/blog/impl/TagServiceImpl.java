package com.hjh.ssmo.service.blog.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hjh.ssmo.mapper.blog.TagMapper;
import com.hjh.ssmo.model.blog.Article;
import com.hjh.ssmo.model.blog.Tag;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.service.blog.TagService;
import com.hjh.ssmo.util.cache.EhcacheUtil;

@Component("tagService")
public class TagServiceImpl implements TagService {
	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<Tag> getTagList(HashMap<String, Object> paramMap, Pager<Tag> pager) {
		List<Tag> tagList = null;
		int count = tagMapper.getTagCount(paramMap);
		pager.setTotalCount(count);
		if (count > 0) {
			paramMap.put("start", pager.getStart());
			paramMap.put("limit", pager.getLimit());
			tagList = tagMapper.getTagList(paramMap);
		}
		return tagList;
	}

	@Override
	public List<Tag> getTagList() {
		List<Tag> tagList = (List<Tag>) EhcacheUtil.get("defaultCache", "tagList");
		if (tagList == null) {
			tagList = tagMapper.getAllTagList();
			EhcacheUtil.put("defaultCache", "tagList", tagList);
		}
		return tagList;
	}

	@Override
	public Tag getTagById(String id) {
		return tagMapper.getTagById(id);
	}

	@Override
	public int editTag(Tag tag) {
		return tagMapper.editTag(tag);
	}

	@Override
	public int addTag(Tag tag) {
		return tagMapper.addTag(tag);
	}

	@Override
	public int deleteTag(String id) {
		return tagMapper.deleteTag(id);
	}

	@Override
	public List<Tag> getArticleTagList(String id) {
		return tagMapper.getArticleTagList(id);
	}

	@Override
	public List<Article> getLastTagArticleList(HashMap<String, Object> paramMap) {
		List<Article> articleList = tagMapper.getLastTagArticleList(paramMap);
		return articleList;
	}
}
