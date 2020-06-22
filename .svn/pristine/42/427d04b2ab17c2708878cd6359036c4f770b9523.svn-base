package com.app.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.entity.admin.Collect;

/**
 * 收藏类dao
 * @author doudou
 *
 */
@Repository
public interface CollectDao {
	public int add(Collect collect);
	public List<Collect> findList(Map<String, Object> queryMap);
	public int getTotal(Long userId);
	public int delete(String ids);
	public int delete2(Long newsId);
}
