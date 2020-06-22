package com.app.controller.home;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.entity.admin.Account;
import com.app.entity.admin.Collect;
import com.app.entity.admin.News;
import com.app.service.admin.AccountService;
import com.app.service.admin.CollectService;
import com.app.service.admin.NewsCategoryService;
import com.app.service.admin.NewsService;

/**
 * 前台页面首页控制器
 * @author doudou
 *
 */
@RequestMapping("/index")
@Controller
public class IndexController {

	@Autowired
	private NewsCategoryService newsCategoryService;
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CollectService collectService;
	
	/**
	 * 系统首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index(ModelAndView model){
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("offset", 0);
		queryMap.put("pageSize", 10);
		model.addObject("newsCategoryList", newsCategoryService.findAll());
		model.addObject("newsList", newsService.findList(queryMap));
		model.setViewName("home/index/index");
		return model;
	}
	
	
	/**
	 * 退出
	 */
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(ModelAndView model,HttpServletRequest request){
		request.getSession().removeAttribute("account");
		model.setViewName("redirect:../index/index");
		return model;
	}
	
	/**
	 * 获取网站基本信息
	 * @return
	 */
	@RequestMapping(value="/get_site_info",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getSiteInfo(){
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("type", "success");
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("offset", 0);
		queryMap.put("pageSize", 99999);
		retMap.put("totalArticle", newsService.getTotal(queryMap));
		retMap.put("siteDays", getDays("2019-11-10"));
		return retMap;
	}
	
	private long getDays(String data){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		try {
			startDate = sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date endDate = new Date();
		long time = (endDate.getTime() - startDate.getTime())/1000/3600/24;
		return time;
	}
	
	/**
	 * 用户登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView login(ModelAndView model){
		model.addObject("title", "用户登录");
		model.setViewName("home/index/login");
		return model;
	}
	
	/**
	 * 用户登录页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView register(ModelAndView model){
		model.addObject("title", "用户注册");
		model.setViewName("home/index/register");
		return model;
	}
	
	/**
	 * 提交注册信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> register(Account account,String code,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("type", "error");
		if(account == null){
			ret.put("msg", "请填写正确的用户信息");
			return ret;
		}
		if(StringUtils.isEmpty(account.getName())){
			ret.put("msg", "请填写用户名");
			return ret;
		}
		if(StringUtils.isEmpty(account.getPassword())){
			ret.put("msg", "请填写密码");
			return ret;
		}
		if(StringUtils.isEmpty(account.getEmail())){
			ret.put("msg", "请填写邮箱");
			return ret;
		}
		if(StringUtils.isEmpty(code)){
			ret.put("msg", "请填写验证码");
			return ret;
		}
		Object codeObject = request.getSession().getAttribute("userRegisterCpacha");
		if(codeObject == null){
			ret.put("msg", "验证码已过期，请刷新页面后重试!");
			return ret;
		}
		if(!code.equalsIgnoreCase((String)codeObject)){
			ret.put("msg", "验证码错误!");
			return ret;
		}
		Account findByName = accountService.findByName(account.getName());
		if(findByName != null){
			ret.put("msg", "该用户名已存在!");
			return ret;
		}
		account.setStatus(1);
		account.setCreateTime(new Date());
		if(accountService.add(account) <= 0){
			ret.put("msg", "注册失败，请联系管理员!");
			return ret;
		}
		ret.put("type", "success");
		return ret;
	}
	
	/**
	 * 提交注册信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> login(Account account,String code,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("type", "error");
		if(account == null){
			ret.put("msg", "请填写正确的用户信息");
			return ret;
		}
		if(StringUtils.isEmpty(account.getName())){
			ret.put("msg", "请填写用户名");
			return ret;
		}
		if(StringUtils.isEmpty(account.getPassword())){
			ret.put("msg", "请填写密码");
			return ret;
		}
		if(StringUtils.isEmpty(code)){
			ret.put("msg", "请填写验证码");
			return ret;
		}
		Object codeObject = request.getSession().getAttribute("userLoginCpacha");
		if(codeObject == null){
			ret.put("msg", "验证码已过期，请刷新页面后重试!");
			return ret;
		}
		if(!code.equalsIgnoreCase((String)codeObject)){
			ret.put("msg", "验证码错误!");
			return ret;
		}
		Account findByName = accountService.findByName(account.getName());
		if(findByName == null){
			ret.put("msg", "该用户名不存在!");
			return ret;
		}
		if(!account.getPassword().equals(findByName.getPassword())){
			ret.put("msg", "密码错误!");
			return ret;
		}
		if(findByName.getStatus() == 0){
			ret.put("msg", "该用户已被冻结，请联系管理员!");
			return ret;
		}
		request.getSession().setAttribute("userLoginCpacha", null);
		request.getSession().setAttribute("account", findByName);
		ret.put("type", "success");
		return ret;
	}
	
	/**
	 * 收藏
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/saveCollect",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveCollect(String userId,String newsId,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("type", "error");
		if ( StringUtils.isEmpty(userId) || StringUtils.isEmpty(newsId)){
			ret.put("msg", "参数不正确");
			return ret;
		}
		// 插入
		this.collectService.add(Long.parseLong(userId),Long.parseLong(newsId));
		ret.put("type", "success");
		return ret;
	}
	
	/**
	 * 个人中心页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/center",method = RequestMethod.GET)
	public ModelAndView center(ModelAndView model){
		model.setViewName("home/index/center");
		return model;
	}
	
	/**
	 * 收藏一览
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/collect",method = RequestMethod.GET)
	public ModelAndView collect(ModelAndView model,HttpServletRequest request){
		
		Account account = (Account) request.getSession().getAttribute("account");
		
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("userId", account.getId());
		
		List<Collect> colist = this.collectService.findList(queryMap);
		List<News> newsList = null;
		if ( colist != null && !colist.isEmpty() ){
			newsList = new ArrayList<News>();
			for(Collect co:colist){
				newsList.add(this.newsService.find(co.getNewsId()));
			}
		}
		model.addObject("newsList", newsList);
		model.setViewName("home/index/collect");
		return model;
	}
	
	
	/**
	 * 删除收藏
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/delCollect",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delCollect(String newsId,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("type", "error");
		if ( StringUtils.isEmpty(newsId) ){
			ret.put("msg", "参数不正确");
			return ret;
		}
		// 删除
		this.collectService.delete2( Long.parseLong(newsId));
		ret.put("type", "success");
		return ret;
	}
	
	/**
	 * 密码修改页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/chgpass",method = RequestMethod.GET)
	public ModelAndView chgpass(ModelAndView model){
		model.setViewName("home/index/chgpass");
		return model;
	}
	
	/**
	 * 保存mi'ma
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/savepass",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> savepass(String password,HttpServletRequest request){
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("type", "error");
		if ( StringUtils.isEmpty(password) ){
			ret.put("msg", "参数不正确");
			return ret;
		}
		Account account = (Account) request.getSession().getAttribute("account");
		this.accountService.uptpass(account.getId(), password);
		ret.put("type", "success");
		return ret;
	}
	
	
}
