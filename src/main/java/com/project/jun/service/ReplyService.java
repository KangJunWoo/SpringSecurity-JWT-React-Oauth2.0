package com.project.jun.service;

import java.util.List;

import com.project.jun.domain.ReplyInfo;

public interface ReplyService {

	int insertReplyInfo(ReplyInfo replyInfo);

	List<ReplyInfo> selectALLReplyInfo();

	ReplyInfo selectReplyInfoByReplyNo(int reply_no);

	int updateReplyInfoByReplyNo(ReplyInfo replyInfo);

	int deleteReplyInfoByReplyNo(int reply_no);

}