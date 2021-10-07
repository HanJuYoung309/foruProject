package co.kr.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.board.vo.BoardVO;
import co.kr.board.vo.ReplyVO;

public interface BoardService {

	List<BoardVO> list(int page, String type, String keyword);

	int total();

	BoardVO getBoard(int bnum);

	int insert(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception;

	int cntMax();

	int update(BoardVO vo);

	int delete(int bnum);
	
	int cntUpdate(int cnt);

	//public List<ReplyVO> replyList(int bno);

}
