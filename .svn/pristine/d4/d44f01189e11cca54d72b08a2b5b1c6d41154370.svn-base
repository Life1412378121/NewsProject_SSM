package com.app.dao.admin;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.app.entity.admin.Account;

/**
 * 会员dao层
 * @author Administrator
 *
 */
@Repository
public interface AccountDao {
	/**
	 * 添加会员
	 * @param account
	 * @return
	 */
	public int add(Account account);
	
	/**
	 * 编辑会员
	 * @param account
	 * @return
	 */
	public int edit(Account account);
	
	/**
	 * 删除会员
	 * @param id
	 * @return
	 */
	public int delete(Long id);
	
	/**
	 * 多条件搜索词查询会员
	 * @param queMap
	 * @return
	 */
	public List<Account> findList(Map<String, Object> queryMap);
	
	/**
	 * 获取符合条件的总记录数
	 * @param queryMap
	 * @return
	 */
	public Integer getTotal(Map<String, Object> queryMap);
	
	/**
	 * 根据id查询会员
	 * @param id
	 * @return
	 */
	public Account findById(Long id);
	
	/**
	 * 根据用户名查找会员
	 * @param name
	 * @return
	 */
	public Account findByName(String name);
	
}
