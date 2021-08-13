package com.project.jun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.jun.domain.ReviewInfo;
import com.project.jun.mapper.ReviewMapper;

@Repository
public class ReviewDaoImpl implements ReviewDao {
	@Autowired ReviewMapper reviewMapper;
	@Override
	public int insertReviewInfo(ReviewInfo reviewInfo) {
		return reviewMapper.insertReviewInfo(reviewInfo);
	};
	@Override
	public List<ReviewInfo> selectALLReviewInfo(){
		return reviewMapper.selectALLReviewInfo();
	};
	@Override
	public ReviewInfo selectReviewInfoByReviewNo(int review_no){
		return reviewMapper.selectReviewInfoByReviewNo(review_no);
	};
	@Override
	public int updateReviewInfoByReviewNo(ReviewInfo reviewInfo){
		return reviewMapper.updateReviewInfoByReviewNo(reviewInfo);
	};
	@Override
	public int deleteReviewInfoByReviewNo(int review_no){
		return reviewMapper.deleteReviewInfoByReviewNo(review_no);
	};

}
