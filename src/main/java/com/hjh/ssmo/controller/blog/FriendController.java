package com.hjh.ssmo.controller.blog;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjh.ssmo.model.blog.Friend;
import com.hjh.ssmo.model.view.Pager;
import com.hjh.ssmo.model.view.Result;
import com.hjh.ssmo.service.blog.FriendService;
import com.hjh.ssmo.util.Constant;
import com.hjh.ssmo.util.JsonUtil;

@Controller
public class FriendController {

	@Autowired
	private FriendService friendService;

	/**
	 * 跳转列表
	 */
	@RequestMapping(value = "/admin/friend/list")
	public String list(HttpSession session, ModelMap map) {
		return "/admin/friend/friend_list";
	}

	/**
	 * 获取分页列表
	 */
	@RequestMapping(value = "/admin/friend/load")
	public String loadFriendPageList(HttpSession session, ModelMap map, String param, Pager<Friend> pager) {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		Friend friend = JsonUtil.fromJson(param, Friend.class);
		paramMap.put("friend", friend);
		List<Friend> friendList = friendService.getFriendList(paramMap, pager);
		map.put("friendList", friendList);
		map.put("pager", pager);
		return "/admin/friend/friend_pager_list";
	}

	/**
	 * 跳转编辑页面
	 */
	@RequestMapping(value = "/admin/friend/editJump/{id}")
	public String editJump(HttpSession session, ModelMap map, @PathVariable String id) {
		Friend friend = friendService.getFriendById(id);
		map.put("friend", friend);
		map.put("friendId", id);
		return "/admin/friend/edit_friend";
	}

	/**
	 * 编辑
	 */
	@RequestMapping(value = "/admin/friend/edit")
	public @ResponseBody
	Result editFriend(Friend friend, HttpSession session) {
		if (friendService.editFriend(friend) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 跳转添加页面
	 */
	@RequestMapping(value = "/admin/friend/addJump")
	public String addJump(HttpSession session, ModelMap map) {
		return "/admin/friend/add_friend";
	}

	/**
	 * 添加
	 */
	@RequestMapping(value = "/admin/friend/add")
	public @ResponseBody
	Result addFriend(Friend friend, HttpSession session) {
		if (friendService.addFriend(friend) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}

	/**
	 * 删除
	 */
	@RequestMapping(value = "/admin/friend/delete/{id}")
	public @ResponseBody
	Result deleteFriend(@PathVariable String id) {
		if (friendService.deleteFriend(id) > 0) {
			return new Result("success", Constant.DEAL_SUCCESS);
		} else {
			return new Result("fail", Constant.DEAL_FAIL);
		}
	}
}
