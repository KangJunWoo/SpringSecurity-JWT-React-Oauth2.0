package com.project.jun.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.jun.domain.UserInfo;
import com.project.jun.service.UserService;
import com.project.jun.springsecurity.CustomAuthenticationManager;


@RestController
@RequestMapping("/oauth")
public class OauthController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="/getMyServerToken", method=RequestMethod.POST)
	public String getMyServerToken(HttpServletResponse response ,@RequestBody Map<String, String> map) {
		System.out.println("getMyServerToken시작");
		System.out.println(map);
		System.out.println(map.get("email"));
		String email=map.get("email");
		List<UserInfo> userInfos=userService.selectAllUserInfo();
		System.out.println("Kakao사용자 정보에서 받은 email과 DB의 ID와 비교 후 일치하면 Token생성");
		System.out.println(userInfos.get(2).getUser_id());
		for (UserInfo userInfo : userInfos) {
			if (userInfo.getUser_id().equals(email)) {
				System.out.println("=======================ID일치=======================");
				System.out.println("=======================JWT토큰 생성=======================");
				String jwtToken = JWT.create()
						.withSubject("juns")
						.withExpiresAt(new Date(System.currentTimeMillis()+(60000*10)))
						.withClaim("username", userInfo.getUsername())
						.sign(Algorithm.HMAC512("juns"));
				response.addHeader("Authorization", "Bearer "+jwtToken);
			}
		}
		System.out.println("=======================ID 불일치=======================");
		System.out.println("=======================사용자 정보 email을 통하여 DB에 ID insert=======================");
		
		return "asdfasdfasdfsda";
	}
}
