﻿package com.app.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.entity.admin.NewsCategory;

/**
 * 新闻分类dao
 * @author doudou
 *
 */
@Repository
public interface NewsCategoryDao {
	public int add(NewsCategory newsCategory);
	public int edit(NewsCategory newsCategory);
	public int delete(Long id);
	public List<NewsCategory> findList(Map<String,Object> queryMap);
	public List<NewsCategory> findAll();
	public int getTotal(Map<String,Object> queryMap);
	public NewsCategory find(Long id);
}
