package com.ssm.controller.login;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.User;
import com.ssm.service.LoginService;
import com.ssm.utils.StringUtils;

@Controller
public class LoginController {

	private Logger logger = Logger.getLogger(LoginController.class);

	@Resource
	private LoginService loginService;
/**
 * 用户登录：若用户名为空，则返回error
 * @param request
 * @param userName
 * @param password
 * @param model
 * @return
 */
	@RequestMapping("/login")
	public String login(HttpServletRequest  request,String userName, String password,Model model) {
		HttpSession session = request.getSession();
		if(!session.isNew()&&session.getAttribute(userName)!=null){
			User  user = (User)session.getAttribute(userName);
			model.addAttribute(user);
			logger.info("用户："+user.getUserName()+" 登录成功！");
			return "index";
		}
		User user=null;
			user = loginService.getUser(userName, StringUtils.toMD5(password));
		if (user == null) {
			return "login";
		} else {
			session.setAttribute(userName, user);
			logger.info("用户："+user.getUserName()+"登录成功！");
			return "index";
		}

	}
}