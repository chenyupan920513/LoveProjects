package com.ssm.controller.login;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ssm.utils.RedisUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.User;
import com.ssm.service.LoginService;
import com.ssm.utils.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private Logger logger = Logger.getLogger(LoginController.class);

	@Resource
	private LoginService loginService;
	@Resource
	private RedisUtils redisUtils;


	/**
	 *登录页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest  request) {
		return "login";
	}
	/**
	 * 用户登录：若用户名为空，则返回error
	 * @param request
	 * @param userName
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(HttpServletRequest  request,String userName, String password,Model model) {
		HttpSession session = request.getSession();

		redisUtils.set("foo","bar");
		System.out.print(redisUtils.get("foo"));

		if(!session.isNew()&&session.getAttribute(userName)!=null){
			User  user = (User)session.getAttribute(userName);
			model.addAttribute(user);
			logger.info("用户："+user.getUserName()+" 登录成功！");
			return "index";
		}
		User user=null;
		try {
			user = loginService.getUser(userName, StringUtils.toMD5(password));
		} catch (NoSuchAlgorithmException e) {
			logger.error("MD5加密失败！"+e.getMessage());
		}
		if (user == null) {
			return "login";
		} else {
			session.setAttribute(userName, user);
			logger.info("用户："+user.getUserName()+"登录成功！");
			return "index";
		}

	}

}