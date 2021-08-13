package com.project.jun.domain;

public class PaginationInfo {
	private int pageNumber;
	private int pageSize;
	public PaginationInfo() {
	}
	public PaginationInfo(int pageNumber, int pageSize) {
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PaginationInfo [pageNumber=" + pageNumber + ", pageSize=" + pageSize + "]";
	}
}
