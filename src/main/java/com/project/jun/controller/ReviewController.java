package com.project.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.jun.domain.ReviewInfo;
import com.project.jun.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value="ReviewController")
@ApiResponses({
	@ApiResponse(code = 200, message = "OK !!"),
	@ApiResponse(code = 500, message = "Internal Server Error !!"),
	@ApiResponse(code = 404, message = "Not Found !!")
})
@Api(value="ReviewController")
@RestController
public class ReviewController {
	@Autowired ReviewService reviewService;
	
	@GetMapping(value="/insert_reviewinfo")
	public int insertReviewInfo(@ModelAttribute ReviewInfo reviewInfo) {
		reviewInfo.setReview_no(0);
		return reviewService.insertReviewInfo(reviewInfo); 
	};
	
	@GetMapping(value="/selectall_reviewinfo")
	public List<ReviewInfo> selectALLReviewInfo(){
		return reviewService.selectALLReviewInfo();
	}
	@GetMapping(value="/select_reviewinfo_byreviewno")
	public ReviewInfo selectReviewInfoByReviewNo(@RequestParam int review_no) {
		return reviewService.selectReviewInfoByReviewNo(review_no);
	}
	
	@GetMapping(value="/update_reviewinfo_byreviewno")
	public int updateReviewInfoByReviewNo(@RequestParam int review_no, @RequestParam String review_content) {
		ReviewInfo reviewInfo = new ReviewInfo(review_no, review_content);
		return reviewService.updateReviewInfoByReviewNo(reviewInfo);
	}
	@GetMapping(value="/delete_reviewinfo_byreviewno")
	public int deleteReviewInfoByReviewNo(@RequestParam int review_no) {
		return reviewService.deleteReviewInfoByReviewNo(review_no);
	}
}