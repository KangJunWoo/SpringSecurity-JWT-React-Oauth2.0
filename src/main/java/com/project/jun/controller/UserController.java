package com.project.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.jun.domain.UserInfo;
import com.project.jun.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value="UserController")
@ApiResponses({
	@ApiResponse(code = 200, message = "OK !!"),
	@ApiResponse(code = 500, message = "Internal Server Error !!"),
	@ApiResponse(code = 404, message = "Not Found !!")
})
@Api(value="UserController")
@RestController
@RequestMapping("/userinfo")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping(value="/insert_userinfo")
	public int inserUserInfo(@ModelAttribute UserInfo userInfo) {
		userInfo.setUser_no(0);
		return userService.inserUserInfo(userInfo);
	};
	@PostMapping(value="/selectall_userinfo")
	public List<UserInfo> selectAllUserInfo(){
		return userService.selectAllUserInfo();
	};
	@GetMapping(value="/selectOne_userinfo_byuserno")
	public UserInfo selectOneUserInfoByUserNo(@RequestParam int user_no){
		return userService.selectOneUserInfoByUserNo(user_no);
	};
	@GetMapping(value="/update_userinfo_byuserno")
	public int updateUserInfoByUserNo(UserInfo userInfo){
		return userService.updateUserInfoByUserNo(userInfo);
	};
	@GetMapping(value="/delete_userinfo_byuserno")
	public int deleteUserInfoByUserNo(@RequestParam int user_no){
		return userService.deleteUserInfoByUserNo(user_no);
	};
	
	@GetMapping(value="/selectone_userinfo_byuserid")
	public UserInfo selectOneUserInfoByUserId(@RequestParam String user_id){
		return userService.selectOneUserInfoByUserId(user_id);
	};
}