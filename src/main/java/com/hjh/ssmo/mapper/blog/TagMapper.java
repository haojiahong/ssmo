package com.hjh.ssmo.mapper.blog;

import java.util.HashMap;
import java.util.List;

import com.hjh.ssmo.model.blog.Tag;

public interface TagMapper {

	int getTagCount(HashMap<String, Object> paramMap);

	List<Tag> getTagList(HashMap<String, Object> paramMap);

	List<Tag> getAllTagList();

	Tag getTagById(String id);

	int addTag(Tag tag);

	int editTag(Tag tag);

	int deleteTag(String id);

	List<Tag> getArticleTagList(String id);

}
