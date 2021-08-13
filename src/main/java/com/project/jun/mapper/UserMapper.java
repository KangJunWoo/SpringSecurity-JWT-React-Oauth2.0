package com.project.jun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.jun.domain.UserInfo;

@Mapper
public interface UserMapper {
	public int inserUserInfo(UserInfo userInfo);
	List<UserInfo> selectAllUserInfo();
	public UserInfo selectOneUserInfoByUserNo(int user_no);
	public int updateUserInfoByUserNo(UserInfo userInfo);
	public int deleteUserInfoByUserNo(int user_no);
	public UserInfo selectOneUserInfoByUserId(String user_id);
}
