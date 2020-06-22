package com.app.controller.home;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.entity.admin.News;
import com.app.entity.admin.NewsCategory;
import com.app.service.admin.NewsCategoryService;
import com.app.service.admin.NewsService;
import com.app.util.DateUtils;

@Controller
@RequestMapping("/service")
public class AjxAppDataAction {

	@Autowired
	private NewsCategoryService newsCategoryService;

	@Autowired
	private NewsService newsService;

	// 文件下载路径
	private String SYS_FILE_DOWN_URL = "";

	@RequestMapping(value = "data", method = RequestMethod.POST)
	@ResponseBody
	@SuppressWarnings({ "unchecked", "unused", "null" })
	public Map<String, Object> getData(String type, Integer devicePlaceId, Integer deviceTypeId, Integer deviceUserId,
			HttpServletRequest req, HttpServletResponse rsp) throws Exception {
		try {
			SYS_FILE_DOWN_URL = req.getContextPath() + "/news/app?id=";
			InputStream input = req.getInputStream();
			Map<String, Object> map = new HashMap<String, Object>();
			String result = getStringByInputStream(input);
			result = (result == null ? "" : result);
			String addrIp = req.getRemoteAddr();
			System.out.println("操作指令:" + type + " 访问IP：" + addrIp);
			System.out.println("操作内容:" + result);
			System.out.println("addrIp:" + addrIp);
			System.out.println("新闻网页链接:" + SYS_FILE_DOWN_URL);

			/**
			 * 新闻资讯类接口
			 */
			if ("newsInfo".equals(type)) {
				Map<String, Object> queryMap = new HashMap<String, Object>();
				queryMap.put("bigTypeId", 1);
				List<NewsCategory> typeList = newsCategoryService.findList(queryMap);
				if (typeList != null && typeList.size() > 0) {
					List<Map<String, Object>> listTypeMap = new ArrayList<Map<String, Object>>();
					System.out.println("typeList==" + typeList.size());
					map.put("code", "0");
					map.put("msg", "成功");
					for (NewsCategory newsCategory : typeList) {
						Map<String, Object> typeMap = new HashMap<String, Object>();
						typeMap.put("id", newsCategory.getId());
						typeMap.put("name", newsCategory.getName());
						typeMap.put("bigTypeId", newsCategory.getBigTypeId());

						// 分类下的新闻
						Map<String, Object> queryNewsMap = new HashMap<String, Object>();
						queryNewsMap.put("categoryId", newsCategory.getId());
						List<News> newsList = newsService.findList(queryNewsMap);
						if (newsList != null) {
							List<Map<String, Object>> listNewsMap = new ArrayList<Map<String, Object>>();
							for (News news : newsList) {
								Map<String, Object> newsMap = new HashMap<String, Object>();
								newsMap.put("id", news.getId());
								newsMap.put("title", news.getTitle());
								newsMap.put("photo", news.getPhoto());
								newsMap.put("author", news.getAuthor());
								newsMap.put("createTime", DateUtils.toFull(news.getCreateTime()));
								newsMap.put("ciewNumber", news.getViewNumber());
								newsMap.put("commentNumber", news.getCommentNumber());
								newsMap.put("url", SYS_FILE_DOWN_URL + news.getId());

								listNewsMap.add(newsMap);
							}
							typeMap.put("news", listNewsMap);
						}
						listTypeMap.add(typeMap);
					}
					map.put("types", listTypeMap);
				} else {
					return getErrorJson("没有查询到相关数据");
				}
				return map;
			}
			/**
			 * 新闻资讯类接口
			 */
			else if ("learmsInfo".equals(type)) {
				Map<String, Object> queryMap = new HashMap<String, Object>();
				queryMap.put("bigTypeId", 2);
				List<NewsCategory> typeList = newsCategoryService.findList(queryMap);
				if (typeList != null && typeList.size() > 0) {
					List<Map<String, Object>> listTypeMap = new ArrayList<Map<String, Object>>();
					System.out.println("typeList==" + typeList.size());
					map.put("code", "0");
					map.put("msg", "成功");
					for (NewsCategory newsCategory : typeList) {
						Map<String, Object> typeMap = new HashMap<String, Object>();
						typeMap.put("id", newsCategory.getId());
						typeMap.put("name", newsCategory.getName());
						typeMap.put("bigTypeId", newsCategory.getBigTypeId());

						// 分类下的新闻
						Map<String, Object> queryNewsMap = new HashMap<String, Object>();
						queryNewsMap.put("categoryId", newsCategory.getId());
						List<News> newsList = newsService.findList(queryNewsMap);
						if (newsList != null) {
							List<Map<String, Object>> listNewsMap = new ArrayList<Map<String, Object>>();
							for (News news : newsList) {
								Map<String, Object> newsMap = new HashMap<String, Object>();
								newsMap.put("id", news.getId());
								newsMap.put("title", news.getTitle());
								newsMap.put("photo", news.getPhoto());
								newsMap.put("author", news.getAuthor());
								newsMap.put("createTime", DateUtils.toFull(news.getCreateTime()));
								newsMap.put("ciewNumber", news.getViewNumber());
								newsMap.put("commentNumber", news.getCommentNumber());
								newsMap.put("url", SYS_FILE_DOWN_URL + news.getId());

								listNewsMap.add(newsMap);
							}
							typeMap.put("news", listNewsMap);
						}
						listTypeMap.add(typeMap);
					}
					map.put("types", listTypeMap);
				} else {
					return getErrorJson("没有查询到相关数据");
				}
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将InputStream转为字符串
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 */
	private String getStringByInputStream(InputStream input) throws IOException {
		StringBuffer result = new StringBuffer();
		byte[] bytes = new byte[1024];
		int size = 0;
		while ((size = input.read(bytes)) != -1) {
			result.append(new String(bytes, 0, size, "UTF-8"));
		}
		input.close();
		return result.toString();
	}

	/**
	 * 组织成功的返回內容(简易)
	 * 
	 * @param error
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getErrorJson(String msg) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "2");
		map.put("msg", msg);
		return map;
	}
}
