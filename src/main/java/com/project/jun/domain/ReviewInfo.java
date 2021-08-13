package com.project.jun.domain;

public class ReviewInfo {
	private int review_no;
	private String review_content;
	private int post_no;
	public ReviewInfo() {
	}
	public ReviewInfo(int review_no, String review_content, int post_no) {
		super();
		this.review_no = review_no;
		this.review_content = review_content;
		this.post_no = post_no;
	}
	public int getReview_no() {
		return review_no;
	}
	public ReviewInfo(int review_no, String review_content) {
		super();
		this.review_no = review_no;
		this.review_content = review_content;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	@Override
	public String toString() {
		return "ReviewInfo [review_no=" + review_no + ", review_content=" + review_content + ", post_no=" + post_no
				+ "]";
	}
}
