package co.kr.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.service.ReplyService;
import co.kr.board.service.mapper.ReplyMapper;
import co.kr.board.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	public ReplyMapper mapper;

	@Override
	public List<ReplyVO> replyList(int bno) {
		// TODO Auto-generated method stub
		return mapper.replyList(bno);
	}

	@Override
	public void writeReply(ReplyVO replyVO) {
		mapper.writeReply(replyVO);
		
	}

	//댓글 수정 
	@Override
	public void updateReply(ReplyVO replyVO) {
		mapper.updateReply(replyVO);
		
	}

	//댓글 삭제  
	@Override
	public void deleteReply(ReplyVO replyVO) {
		
		mapper.deleteReply(replyVO);
		
	}

}
