﻿package com.app.service.admin.impl;
/**
 * 新闻评论service实现类
 */
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.admin.CommentDao;
import com.app.entity.admin.Comment;
import com.app.service.admin.CommentService;
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public int add(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.add(comment);
	}

	@Override
	public int edit(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.edit(comment);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return commentDao.delete(ids);
	}

	@Override
	public List<Comment> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return commentDao.findList(queryMap);
	}

	@Override
	public List<Comment> findAll() {
		// TODO Auto-generated method stub
		return commentDao.findAll();
	}

	@Override
	public int getTotal(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return commentDao.getTotal(queryMap);
	}
	
	

}
