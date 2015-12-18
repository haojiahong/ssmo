package com.hjh.ssmo.model.blog;

/**
 * 栏目实体
 * 
 * @author haojiahong
 * 
 * @createtime：2015-12-18 上午11:13:42
 * 
 * 
 */
public class Category {

	private Integer id;

	private String categoryName;

	private String iconClass;

	private String aliasName;

	private int sortNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}
}
