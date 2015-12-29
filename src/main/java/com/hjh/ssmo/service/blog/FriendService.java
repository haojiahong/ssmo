package com.hjh.ssmo.service.blog;

import java.util.HashMap;
import java.util.List;

import com.hjh.ssmo.model.blog.Friend;
import com.hjh.ssmo.model.view.Pager;

public interface FriendService {

	public List<Friend> getFriendList(HashMap<String, Object> paramMap, Pager<Friend> pager);

	public Friend getFriendById(String id);

	public int editFriend(Friend friend);

	public int addFriend(Friend friend);

	public int deleteFriend(String id);

	public List<Friend> getAllFriendList();

}
