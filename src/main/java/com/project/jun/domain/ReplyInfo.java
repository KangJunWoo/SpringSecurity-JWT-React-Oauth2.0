package com.project.jun.domain;

public class ReplyInfo {
	private int reply_no;
	private String reply_content;
	private int review_no;
	public ReplyInfo() {
	}
	public ReplyInfo(int reply_no, String reply_content, int review_no) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
		this.review_no = review_no;
	}
	public ReplyInfo(int reply_no, String reply_content) {
		super();
		this.reply_no = reply_no;
		this.reply_content = reply_content;
	}
	public int getReply_no() {
		return reply_no;
	}
	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	@Override
	public String toString() {
		return "ReplyInfo [reply_no=" + reply_no + ", reply_content=" + reply_content + ", review_no=" + review_no
				+ "]";
	}
}

