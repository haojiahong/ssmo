package com.hjh.ssmo.mapper.blog;

import java.util.HashMap;
import java.util.List;

import com.hjh.ssmo.model.blog.Tag;

public interface TagMapper {

	int getTagCount(HashMap<String, Object> paramMap);

	List<Tag> getTagList(HashMap<String, Object> paramMap);

	int addTag(Tag tag);

	int deleteTag(String id);

	Tag getTagById(String id);

	int editTag(Tag tag);

	List<Tag> getAllTagList();

	List<Tag> getArticleTagList(String id);

	Tag getTagByName(String tagName);

}
