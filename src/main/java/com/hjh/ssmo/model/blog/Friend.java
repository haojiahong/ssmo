package com.hjh.ssmo.model.blog;

/**
 * 合作伙伴实体
 * 
 * @author haojiahong
 * 
 * @createtime：2015-12-18 上午11:13:42
 * 
 * 
 */
public class Friend {

	private Integer id;

	private String friendName;

	private String friendUrl;

	private String friendDesc;

	private int sortNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getFriendUrl() {
		return friendUrl;
	}

	public void setFriendUrl(String friendUrl) {
		this.friendUrl = friendUrl;
	}

	public String getFriendDesc() {
		return friendDesc;
	}

	public void setFriendDesc(String friendDesc) {
		this.friendDesc = friendDesc;
	}

	public int getSortNum() {
		return sortNum;
	}

	public void setSortNum(int sortNum) {
		this.sortNum = sortNum;
	}

}
