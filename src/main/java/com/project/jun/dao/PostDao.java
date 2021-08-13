package com.project.jun.dao;

import java.util.List;

import com.project.jun.domain.PaginationInfo;
import com.project.jun.domain.PostInfo;

public interface PostDao {

	int insertPostInfo(PostInfo postInfo);

	List<PostInfo> selectALLPostInfo();

	PostInfo selectPostInfoByPostNo(int post_no);

	int updatePostInfoByPostNo(PostInfo postInfo);

	int deletePostInfoByPostNo(int post_no);

	List<PostInfo> selectPagination(PaginationInfo paginationInfo);

}