package com.hjh.ssmo.service.blog.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hjh.ssmo.mapper.blog.FriendMapper;
import com.hjh.ssmo.model.blog.Friend;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.service.blog.FriendService;

@Component("friendService")
public class FriendServiceImpl implements FriendService {
	@Autowired
	private FriendMapper friendMapper;

	@Override
	public List<Friend> getFriendList(HashMap<String, Object> paramMap, Pager<Friend> pager) {
		List<Friend> friendList = null;
		int count = friendMapper.getFriendCount(paramMap);
		pager.setTotalCount(count);
		if (count > 0) {
			paramMap.put("start", pager.getStart());
			paramMap.put("limit", pager.getLimit());
			friendList = friendMapper.getFriendList(paramMap);
		}
		return friendList;
	}

	@Override
	public Friend getFriendById(String id) {
		return friendMapper.getFriendById(id);
	}

	@Override
	public int editFriend(Friend friend) {
		return friendMapper.editFriend(friend);
	}

	@Override
	public int addFriend(Friend friend) {
		return friendMapper.addFriend(friend);
	}

	@Override
	public int deleteFriend(String id) {
		return friendMapper.deleteFriend(id);
	}
}
