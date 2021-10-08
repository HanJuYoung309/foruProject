package co.kr.board.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.board.vo.ReplyVO;

@Mapper
public interface ReplyMapper {
	
	public List<ReplyVO> replyList(int bno);

	public void writeReply(ReplyVO replyVO);

	public void updateReply(ReplyVO replyVO);

	public void deleteReply(ReplyVO replyVO);

	public ReplyVO selectReply(int rno);

}
