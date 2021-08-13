package com.project.jun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jun.dao.ReviewDao;
import com.project.jun.domain.ReviewInfo;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired ReviewDao reviewDao;
	@Override
	public int insertReviewInfo(ReviewInfo reviewInfo) {
		return reviewDao.insertReviewInfo(reviewInfo);
	};
	@Override
	public List<ReviewInfo> selectALLReviewInfo(){
		return reviewDao.selectALLReviewInfo();
	};
	@Override
	public ReviewInfo selectReviewInfoByReviewNo(int review_no){
		return reviewDao.selectReviewInfoByReviewNo(review_no);
	};
	@Override
	public int updateReviewInfoByReviewNo(ReviewInfo reviewInfo){
		return reviewDao.updateReviewInfoByReviewNo(reviewInfo);
	};
	@Override
	public int deleteReviewInfoByReviewNo(int review_no){
		return reviewDao.deleteReviewInfoByReviewNo(review_no);
	};

}
