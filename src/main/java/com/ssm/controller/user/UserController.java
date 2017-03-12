package com.ssm.controller.user;

import com.ssm.pojo.User;
import com.ssm.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;

	@RequestMapping("/showUser")
	public String toIndex(String userId, Model model) {
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "User";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	User getJson(@PathVariable("id") String id) {
		User user = this.userService.getUserById(id);
		return user;
	}
}