package com.consult_system.controller;

import com.consult_system.entity.User;
import com.consult_system.service.UserService;
import com.consult_system.util.JSONUtils;
import com.consult_system.viewmodel.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacob
 */

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public ApiResult test(){
		String string = "test hello count is " + userService.findAllBy();
		Map<String,String> map = new HashMap<>();
		map.put("test1","test1");
		map.put("test2","test2");
		map.put("test3","test3");
		map.put("test4","test4");
		return ApiResult.ok(JSONUtils.toJsonString(map));
	}

	/**
	 * 页面登录
	 * @param password
	 * @param studentId
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/user/login",method = RequestMethod.GET)
	public ApiResult saveUser(String password, String studentId, String role){
		List<User> userList = userService.findUserInfo(password, studentId, role);
		if (userList.size()==1){
			return ApiResult.ok();
		}else{
			return ApiResult.error();
		}
	}

	/**
	 * 页面注册
	 * @param name
	 * @param password
	 * @param studentId
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/user/register",method = RequestMethod.GET)
	public ApiResult registerUser(String name, String password, String studentId, String role){
		List<User> userList = userService.registerUser(name, password, studentId);
		if (userList.size()>0){
			return ApiResult.error("该学号已注册");
		}else{
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			user.setStudentId(studentId);
			user.setRole(role);
			user.setCreateTime(new Date());
			userService.saveUser(user);
			return ApiResult.ok("注册成功");
		}
	}
}
