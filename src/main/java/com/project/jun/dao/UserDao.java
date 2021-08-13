package com.project.jun.dao;

import java.util.List;

import com.project.jun.domain.UserInfo;

public interface UserDao {

	int inserUserInfo(UserInfo userInfo);

	List<UserInfo> selectAllUserInfo();

	UserInfo selectOneUserInfoByUserNo(int user_no);

	int updateUserInfoByUserNo(UserInfo userInfo);

	int deleteUserInfoByUserNo(int user_no);

	UserInfo selectOneUserInfoByUserId(String user_id);
	

}