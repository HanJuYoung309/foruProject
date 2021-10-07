package co.kr.board.service.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.board.vo.BoardVO;
import co.kr.board.vo.ReplyVO;

@Mapper
public interface BoardMapper {

	List<BoardVO> list(HashMap<String, Object> hashMap);

	int total();

	BoardVO getBoard(int bnum);

	int insert(@Param("board")  BoardVO  boardVO, MultipartHttpServletRequest mpRequest);

	int cntMax();

	int update(BoardVO vo);

	int delete(int bnum);

	int cntUpdate(int cnt);

	void insertFile(Map<String, Object> map);

	//List<ReplyVO> replyList();

}
