package co.kr.board.service;

import java.util.List;

import co.kr.board.vo.ReplyVO;

public interface ReplyService {
	//댓글조회
	public List<ReplyVO> replyList(int bno);
	
	//댓글작성
	
	public void writeReply(ReplyVO replyVO);
	
	//댓글 수정
	public void updateReply(ReplyVO replyVO);
	
	//댓글삭제
	public void deleteReply(ReplyVO replyVO);

}
