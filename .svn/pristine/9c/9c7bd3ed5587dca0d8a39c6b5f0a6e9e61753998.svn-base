package com.app.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.entity.admin.Collect;

/**
 * 日志接口
 * @author doudou
 *
 */
@Service
public interface CollectService {
	public int add(Collect collect);
	public int add(Long userId,Long newsId);
	public List<Collect> findList(Map<String, Object> queryMap);
	public int getTotal(Long userId);
	public int delete(String ids);
	public int delete2(Long newsId);
}
