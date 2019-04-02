package com.test.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.test.entity.User;
import com.test.service.UserService;


@Controller
@RequestMapping("/loginContriller")
public class loginController {
	@Autowired
	UserService userservice;
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String login(@Param("userName")String userName,@Param("passWord")String passWord,Model model){
		User user=new User(userName,passWord);
		
		return JSON.toJSONString(userservice.check(user));
		
	}
}
