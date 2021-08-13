package com.project.jun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.jun.domain.PaginationInfo;
import com.project.jun.domain.PostInfo;
import com.project.jun.mapper.PostMapper;

@Repository
public class PostDaoImpl implements PostDao{
	@Autowired PostMapper postMapper;
	
	@Override
	public int insertPostInfo(PostInfo postInfo) {
		return postMapper.insertPostInfo(postInfo);
	};
	@Override
	public List<PostInfo> selectALLPostInfo(){
		return postMapper.selectALLPostInfo();
	};
	@Override
	public PostInfo selectPostInfoByPostNo(int post_no){
		return postMapper.selectPostInfoByPostNo(post_no);
	};
	@Override
	public int updatePostInfoByPostNo(PostInfo postInfo){
		return postMapper.updatePostInfoByPostNo(postInfo);
	};
	@Override
	public int deletePostInfoByPostNo(int post_no){
		return postMapper.deletePostInfoByPostNo(post_no);
	};
	
	@Override
	public List<PostInfo> selectPagination(PaginationInfo paginationInfo) {
		return postMapper.selectPagination(paginationInfo);
	};


}
