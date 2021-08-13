package com.project.jun.springsecurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.jun.domain.UserInfo;
import com.project.jun.service.UserService;

public class CustomAuthorizationFilter extends BasicAuthenticationFilter {
	
	private UserService userService;
	
	public CustomAuthorizationFilter(AuthenticationManager authenticationManager, UserService userService) {
		super(authenticationManager);
		this.userService = userService;
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("CustomAuthorizationFilter시작");
		String header=request.getHeader("Authorization");
		System.out.println("header의 Authorization:"+header);
		
		//header가 있는지 확인
		//없을 때 --> 바로 로직수행없이 체인 탐
		if (header==null || !header.startsWith("Bearer")) {
			System.out.println("header null or !header.startsWith(\"Bearer\") --> chain.dofilter실행");
			chain.doFilter(request, response);
			return;
		}
		//있을 때 --> header의 jwt검증 (header의 jwt와 서버에 저장된 jwt를 비교해서 검증(서명) --> /login처럼 과정을 하지않고 강제로 인증을 만들어줄 수 있음 )
		System.out.println("header not null");
		String jwtToken=header.replace("Bearer ","");
		System.out.println("jwtToken:"+jwtToken);
		String user_id=JWT.require(Algorithm.HMAC512("juns")).build().verify(jwtToken).getClaim("username").asString();
		System.out.println(user_id);
		if (user_id!=null) {
			//서명이 됐으면 강제로 인증만듬
			System.out.println("JWT서명완료");
			System.out.println(userService);
			UserInfo userInfo = (UserInfo)userService.loadUserByUsername(user_id);
			System.out.println("UserInfo:"+userInfo);
			Authentication authentication = new UsernamePasswordAuthenticationToken(userInfo, userInfo.getPassword(),
					userInfo.getAuthorities());
			System.out.println(authentication);
			//강제로 securityContextHolder에 저장
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		chain.doFilter(request, response);
	}
}
