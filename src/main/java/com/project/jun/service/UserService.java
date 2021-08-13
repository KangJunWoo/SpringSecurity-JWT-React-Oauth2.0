package com.project.jun.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.jun.domain.UserInfo;

public interface UserService extends UserDetailsService {

	int inserUserInfo(UserInfo userInfo);

	List<UserInfo> selectAllUserInfo();

	UserInfo selectOneUserInfoByUserNo(int user_no);

	int updateUserInfoByUserNo(UserInfo userInfo);
	
	UserInfo selectOneUserInfoByUserId(String user_id);
	
	int deleteUserInfoByUserNo(int user_no);
	
	@Override
	UserDetails loadUserByUsername(String user_id);
	
}