package com.project.jun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.jun.domain.PaginationInfo;
import com.project.jun.domain.PostInfo;

@Mapper
public interface PostMapper {
	public int insertPostInfo(PostInfo postInfo);
	public List<PostInfo> selectALLPostInfo();
	public PostInfo selectPostInfoByPostNo(int post_no);
	public int updatePostInfoByPostNo(PostInfo postInfo);
	public int deletePostInfoByPostNo(int post_no);
	public List<PostInfo> selectPagination(PaginationInfo paginationInfo);
}
