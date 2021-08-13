package com.project.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.jun.domain.PaginationInfo;
import com.project.jun.domain.PostInfo;
import com.project.jun.service.PostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value="PostController")
@ApiResponses({
	@ApiResponse(code = 200, message = "OK !!"),
	@ApiResponse(code = 500, message = "Internal Server Error !!"),
	@ApiResponse(code = 404, message = "Not Found !!")
})
@Api(value="PostController")
@RestController
@RequestMapping("/postinfo")
public class PostController {
	@Autowired PostService postService;
	
	@PostMapping("/insert_postinfo")
	public int insertPostInfo(@RequestBody PostInfo postInfo) {
		postInfo.setPost_no(0);
		return postService.insertPostInfo(postInfo);
	};
	
	@GetMapping(value="/selectall_postinfo")
	public List<PostInfo> selectALLPostInfo(){
		return postService.selectALLPostInfo();
	}
	
	@GetMapping(value="/select_postinfo_bypostno/post_no/{post_no}")
	public ResponseEntity<PostInfo> selectPostInfoByPostNo(@PathVariable int post_no) {
		return postService.selectPostInfoByPostNo(post_no);
	}
	
	@PostMapping(value="/update_postinfo_bypostno")
	public int updatePostInfoByPostNo(@RequestBody PostInfo postInfo) {
		return postService.updatePostInfoByPostNo(postInfo);
	}
	@GetMapping(value="/delete_postinfo_bypostno")
	public int deletePostInfoByPostNo(@RequestParam int post_no) {
		return postService.deletePostInfoByPostNo(post_no);
	}
	@PostMapping(value="/select_pagination")
	public List<PostInfo> selectPagination(@RequestBody PaginationInfo paginationInfo) {
		return postService.selectPagination(paginationInfo);
	}
}