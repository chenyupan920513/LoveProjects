package com.ssm.controller.login;

import com.ssm.pojo.User;
import com.ssm.service.LoginService;
import com.ssm.utils.RedisUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	private static final Logger logger = LogManager.getLogger(LoginController.class.getName());

	@Resource
	private LoginService loginService;

	/**
	 * @return
	 */
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	@ModelAttribute
	public String login() {
        return "index";
	}

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	@ResponseBody
	public User loginPost(@Param(value = "userName") String userName, @Param(value = "password") String password) {
		User user = loginService.getUser(userName, password);
		logger.info(user);
//		RedisUtils.set("u_"+user.getUserId(), user);
//		User tt = RedisUtils.get("u_"+user.getUserId(),User.class);
		logger.error(user);
		return user;
	}

}