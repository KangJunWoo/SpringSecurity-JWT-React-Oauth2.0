package com.project.jun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.jun.domain.ReplyInfo;
@Mapper
public interface ReplyMapper {
	public int insertReplyInfo(ReplyInfo replyInfo);
	public List<ReplyInfo> selectALLReplyInfo();
	public ReplyInfo selectReplyInfoByReplyNo(int reply_no);
	public int updateReplyInfoByReplyNo(ReplyInfo replyInfo);
	public int deleteReplyInfoByReplyNo(int reply_no);
}
