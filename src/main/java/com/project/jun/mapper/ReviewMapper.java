package com.project.jun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.jun.domain.ReviewInfo;

@Mapper
public interface ReviewMapper {
	public int insertReviewInfo(ReviewInfo reviewInfo);
	public List<ReviewInfo> selectALLReviewInfo();
	public ReviewInfo selectReviewInfoByReviewNo(int review_no);
	public int updateReviewInfoByReviewNo(ReviewInfo reviewInfo);
	public int deleteReviewInfoByReviewNo(int review_no);
}
