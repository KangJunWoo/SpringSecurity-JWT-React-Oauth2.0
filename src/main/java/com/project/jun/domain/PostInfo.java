package com.project.jun.domain;

public class PostInfo {
	private int post_no;
	private String post_title;
	private String post_content;
	private String post_writer;
	private int post_views;
	
	public PostInfo() {
	}

	public PostInfo(int post_no, String post_title, String post_content, String post_writer, int post_views) {
		super();
		this.post_no = post_no;
		this.post_title = post_title;
		this.post_content = post_content;
		this.post_writer = post_writer;
		this.post_views = post_views;
	}
	

	public PostInfo(int post_no, String post_title, String post_content) {
		super();
		this.post_no = post_no;
		this.post_title = post_title;
		this.post_content = post_content;
	}

	public int getPost_no() {
		return post_no;
	}

	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public String getPost_writer() {
		return post_writer;
	}

	public void setPost_writer(String post_writer) {
		this.post_writer = post_writer;
	}

	public int getPost_views() {
		return post_views;
	}

	public void setPost_views(int post_views) {
		this.post_views = post_views;
	}

	@Override
	public String toString() {
		return "PostInfo [post_no=" + post_no + ", post_title=" + post_title + ", post_content=" + post_content
				+ ", post_writer=" + post_writer + ", post_views=" + post_views + "]";
	}
	
	
}
