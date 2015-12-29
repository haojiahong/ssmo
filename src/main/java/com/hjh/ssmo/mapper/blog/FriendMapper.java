package com.hjh.ssmo.mapper.blog;

import java.util.HashMap;
import java.util.List;

import com.hjh.ssmo.model.blog.Friend;

public interface FriendMapper {

	int getFriendCount(HashMap<String, Object> paramMap);

	List<Friend> getFriendList(HashMap<String, Object> paramMap);

	Friend getFriendById(String id);

	int addFriend(Friend friend);

	int editFriend(Friend friend);

	int deleteFriend(String id);

	List<Friend> getAllFriendList();
}
