package com.project.jun.dao;

import java.util.List;

import com.project.jun.domain.ReviewInfo;

public interface ReviewDao {

	int insertReviewInfo(ReviewInfo reviewInfo);

	List<ReviewInfo> selectALLReviewInfo();

	ReviewInfo selectReviewInfoByReviewNo(int review_no);

	int updateReviewInfoByReviewNo(ReviewInfo reviewInfo);

	int deleteReviewInfoByReviewNo(int review_no);

}