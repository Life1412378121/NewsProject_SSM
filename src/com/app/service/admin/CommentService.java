﻿package com.app.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.entity.admin.Comment;

/**
 * 新闻评论接口
 * @author doudou
 *
 */
@Service
public interface CommentService {
	public int add(Comment comment);
	public int edit(Comment comment);
	public int delete(String ids);
	public List<Comment> findList(Map<String,Object> queryMap);
	public List<Comment> findAll();
	public int getTotal(Map<String,Object> queryMap);
}
