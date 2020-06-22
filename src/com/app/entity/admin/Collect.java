package com.app.entity.admin;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 系统日志
 * @author doudou
 *
 */
@Component
public class Collect {
	private Long id;
	private Long userId;//会员id
	private Long newsId;//新闻id
	private Date createTime;//创建时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getNewsId() {
		return newsId;
	}

	public void setNewsId(Long newsId) {
		this.newsId = newsId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	
}
