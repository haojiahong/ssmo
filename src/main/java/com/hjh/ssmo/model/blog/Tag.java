package com.hjh.ssmo.model.blog;

/**
 * 标签实体类
 * 
 * @author haojiahong
 * 
 * @createtime：2015-12-15 下午3:43:48
 * 
 * 
 */
public class Tag {
	private Integer id;
	private String tagName;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
