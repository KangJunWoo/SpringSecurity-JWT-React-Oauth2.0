package com.project.jun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.jun.domain.ReplyInfo;
import com.project.jun.service.ReplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiOperation(value="ReplyController")
@ApiResponses({
	@ApiResponse(code = 200, message = "OK !!"),
	@ApiResponse(code = 500, message = "Internal Server Error !!"),
	@ApiResponse(code = 404, message = "Not Found !!")
})
@Api(value="ReplyController")
@RestController
public class ReplyController {
	@Autowired ReplyService replyService;
	
	@GetMapping(value="/insert_replyinfo")
	public int insertReplyInfo(@ModelAttribute ReplyInfo replyInfo) {
		replyInfo.setReply_no(0);
		return replyService.insertReplyInfo(replyInfo);
	};
	
	@GetMapping(value="/selectall_replyinfo")
	public List<ReplyInfo> selectALLReplyInfo(){
		return replyService.selectALLReplyInfo();
	}
	@GetMapping(value="/select_replyinfo_byreplyno")
	public ReplyInfo selectReplyInfoByReplyNo(@RequestParam int reply_no) {
		return replyService.selectReplyInfoByReplyNo(reply_no);
	}
	
	@GetMapping(value="/update_replyinfo_byreplyno")
	public int updateReplyInfoByReplyNo(@RequestParam int reply_no, @RequestParam String reply_content) {
		ReplyInfo replyInfo = new ReplyInfo(reply_no, reply_content);
		return replyService.updateReplyInfoByReplyNo(replyInfo);
	}
	@GetMapping(value="/delete_replyinfo_byreplyno")
	public int deleteReplyInfoByReplyNo(@RequestParam int reply_no) {
		return replyService.deleteReplyInfoByReplyNo(reply_no);
	}
}
