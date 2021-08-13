package com.project.jun.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.jun.domain.PaginationInfo;
import com.project.jun.domain.PostInfo;

public interface PostService {

	int insertPostInfo(PostInfo postInfo);

	List<PostInfo> selectALLPostInfo();

	ResponseEntity<PostInfo> selectPostInfoByPostNo(int post_no);

	int updatePostInfoByPostNo(PostInfo postInfo);

	int deletePostInfoByPostNo(int post_no);

	List<PostInfo> selectPagination(PaginationInfo paginationInfo);

}