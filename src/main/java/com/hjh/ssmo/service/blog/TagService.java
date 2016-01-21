package com.hjh.ssmo.service.blog;

import java.util.HashMap;
import java.util.List;

import com.hjh.ssmo.model.blog.Article;
import com.hjh.ssmo.model.blog.Tag;
import com.hjh.ssmo.model.view.Pager;

public interface TagService {

	public List<Tag> getTagList(HashMap<String, Object> paramMap, Pager<Tag> pager);

	public List<Tag> getTagList();

	public Tag getTagById(String id);

	public int editTag(Tag tag);

	public int addTag(Tag tag);

	public int deleteTag(String id);

	public List<Tag> getArticleTagList(String id);

	public List<Article> getLastTagArticleList(HashMap<String, Object> paramMap);

}
