package com.project.jun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.jun.domain.ReplyInfo;
import com.project.jun.mapper.ReplyMapper;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	@Autowired ReplyMapper replyMapper;
	@Override
	public int insertReplyInfo(ReplyInfo replyInfo) {
		return replyMapper.insertReplyInfo(replyInfo);
	};
	@Override
	public List<ReplyInfo> selectALLReplyInfo() {
		return replyMapper.selectALLReplyInfo();
	};
	@Override
	public ReplyInfo selectReplyInfoByReplyNo(int reply_no) {
		return replyMapper.selectReplyInfoByReplyNo(reply_no);
	};
	@Override
	public int updateReplyInfoByReplyNo(ReplyInfo replyInfo) {
		return replyMapper.updateReplyInfoByReplyNo(replyInfo);
	};
	@Override
	public int deleteReplyInfoByReplyNo(int reply_no) {
		return replyMapper.deleteReplyInfoByReplyNo(reply_no);
	};
}
