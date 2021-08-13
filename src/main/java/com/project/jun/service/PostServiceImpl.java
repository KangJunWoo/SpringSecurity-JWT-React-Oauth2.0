package com.project.jun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.jun.dao.PostDao;
import com.project.jun.domain.PaginationInfo;
import com.project.jun.domain.PostInfo;

@Service
public class PostServiceImpl implements PostService{
	@Autowired PostDao postDao;
	
	@Override
	public int insertPostInfo(PostInfo postInfo) {
		return postDao.insertPostInfo(postInfo);
	};
	@Override
	public List<PostInfo> selectALLPostInfo(){
		return postDao.selectALLPostInfo();
	};
	@Override
	public ResponseEntity<PostInfo> selectPostInfoByPostNo(int post_no){
		PostInfo postInfo = postDao.selectPostInfoByPostNo(post_no);
		return ResponseEntity.ok(postInfo);
	};
	@Override
	public int updatePostInfoByPostNo(PostInfo postInfo){
		return postDao.updatePostInfoByPostNo(postInfo);
	};
	@Override
	public int deletePostInfoByPostNo(int post_no){
		return postDao.deletePostInfoByPostNo(post_no);
	};
	
	@Override
	public List<PostInfo> selectPagination(PaginationInfo paginationInfo) {
		return postDao.selectPagination(paginationInfo);
	};
}
