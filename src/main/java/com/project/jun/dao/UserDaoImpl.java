package com.project.jun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.jun.domain.UserInfo;
import com.project.jun.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	
	UserMapper userMapper;
	
	@Override
	public int inserUserInfo(UserInfo userInfo) {
		return userMapper.inserUserInfo(userInfo);
	};
	@Override
	public List<UserInfo> selectAllUserInfo(){
		return userMapper.selectAllUserInfo();
	};
	@Override
	public UserInfo selectOneUserInfoByUserNo(int user_no){
		return userMapper.selectOneUserInfoByUserNo(user_no);
	};
	@Override
	public int updateUserInfoByUserNo(UserInfo userInfo){
		return userMapper.updateUserInfoByUserNo(userInfo);
	};
	@Override
	public int deleteUserInfoByUserNo(int user_no){
		return userMapper.deleteUserInfoByUserNo(user_no);
	};
	
	@Override
	public UserInfo selectOneUserInfoByUserId(String user_id) {
		System.out.println("UserDao --> selectOneUserInfoByUserId시작");
		System.out.println("UserDao -->"+user_id);
		return userMapper.selectOneUserInfoByUserId(user_id);
	};
}
