package co.kr.board.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PatchMapping;

import co.kr.board.vo.BoardVO;
import co.kr.board.vo.ReplyVO;

@Mapper
public interface BoardMapper {

	List<BoardVO> list(HashMap<String, Object> hashMap);

	int total();

	BoardVO getBoard(int bnum);

	int insert(@Param("board")  BoardVO  boardVO);

	int cntMax();

	int update(int bnum);

	int delete(int bnum);

	int cntUpdate(int cnt);

	//List<ReplyVO> replyList();

}
