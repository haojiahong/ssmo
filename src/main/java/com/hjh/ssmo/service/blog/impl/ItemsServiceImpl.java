package com.hjh.ssmo.service.blog.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hjh.ssmo.mapper.blog.ItemsMapper;
import com.hjh.ssmo.model.blog.Items;
import com.hjh.ssmo.service.blog.ItemsService;

@Component("itemsService")
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;

	public List<Items> findAllItems() {
		return itemsMapper.findAllItems();
	}
}
