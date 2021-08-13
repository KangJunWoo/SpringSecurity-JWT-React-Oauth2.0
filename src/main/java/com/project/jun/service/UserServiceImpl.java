package com.project.jun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.jun.dao.UserDao;
import com.project.jun.domain.UserInfo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public int inserUserInfo(UserInfo userInfo) {
		userInfo.setUser_password(bCryptPasswordEncoder.encode(userInfo.getPassword()));
		return userDao.inserUserInfo(userInfo);
	};
	@Override
	public List<UserInfo> selectAllUserInfo(){
		return userDao.selectAllUserInfo();
	};
	@Override
	public UserInfo selectOneUserInfoByUserNo(int user_no){
		return userDao.selectOneUserInfoByUserNo(user_no);
	};
	@Override
	public int updateUserInfoByUserNo(UserInfo userInfo){
		return userDao.updateUserInfoByUserNo(userInfo);
	};
	@Override
	public int deleteUserInfoByUserNo(int user_no){
		return userDao.deleteUserInfoByUserNo(user_no);
	}
	
	@Override
	public UserInfo selectOneUserInfoByUserId(String user_id) throws UsernameNotFoundException {
		return userDao.selectOneUserInfoByUserId(user_id);
	};
	
	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
		System.out.println("userService-->loadUserByUsername시작");
		System.out.println("userService-->"+user_id);
		UserInfo userInfo= userDao.selectOneUserInfoByUserId(user_id);
		System.out.println(userInfo);
		return userInfo;
	};
}