package com.project.jun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jun.dao.ReplyDao;
import com.project.jun.domain.ReplyInfo;


@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired ReplyDao replyDao;
	
	@Override
	public int insertReplyInfo(ReplyInfo replyInfo) {
		return replyDao.insertReplyInfo(replyInfo);
	};
	@Override
	public List<ReplyInfo> selectALLReplyInfo() {
		return replyDao.selectALLReplyInfo();
	};
	@Override
	public ReplyInfo selectReplyInfoByReplyNo(int reply_no) {
		return replyDao.selectReplyInfoByReplyNo(reply_no);
	};
	@Override
	public int updateReplyInfoByReplyNo(ReplyInfo replyInfo) {
		return replyDao.updateReplyInfoByReplyNo(replyInfo);
	};
	@Override
	public int deleteReplyInfoByReplyNo(int reply_no) {
		return replyDao.deleteReplyInfoByReplyNo(reply_no);
	};
}
