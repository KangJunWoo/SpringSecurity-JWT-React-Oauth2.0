package com.project.jun.dao;

import java.util.List;

import com.project.jun.domain.ReplyInfo;

public interface ReplyDao {

	int insertReplyInfo(ReplyInfo replyInfo);

	List<ReplyInfo> selectALLReplyInfo();

	ReplyInfo selectReplyInfoByReplyNo(int reply_no);

	int updateReplyInfoByReplyNo(ReplyInfo replyInfo);

	int deleteReplyInfoByReplyNo(int reply_no);

}