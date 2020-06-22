package com.app.service.admin.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.admin.CollectDao;
import com.app.entity.admin.Collect;
import com.app.service.admin.CollectService;
@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectDao collectDao;

	@Override
	public int add(Collect collect) {
		// TODO Auto-generated method stub
		return collectDao.add(collect);
	}

	@Override
	public List<Collect> findList(Map<String, Object> queryMap) {
		// TODO Auto-generated method stub
		return collectDao.findList(queryMap);
	}

	@Override
	public int getTotal(Long userId) {
		// TODO Auto-generated method stub
		return collectDao.getTotal(userId);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return collectDao.delete(ids);
	}
	
	public int delete2(Long newsId) {
		// TODO Auto-generated method stub
		return collectDao.delete2(newsId);
	}


	@Override
	public int add(Long userId,Long newsId) {
		// TODO Auto-generated method stub
		Collect collect = new Collect();
		collect.setUserId(userId);
		collect.setNewsId(newsId);
		collect.setCreateTime(new Date());
		return collectDao.add(collect);
	}
	
	

}
