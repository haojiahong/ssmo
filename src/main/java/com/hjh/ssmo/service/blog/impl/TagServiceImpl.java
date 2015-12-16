package com.hjh.ssmo.service.blog.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hjh.ssmo.model.blog.Tag;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.service.blog.TagService;

@Component("tagService")
public class TagServiceImpl implements TagService {
	@Override
	public List<Tag> getTagList(HashMap<String, Object> paramMap, Pager<Tag> pager) {
		// TODO Auto-generated method stub
		return null;
	}
}
