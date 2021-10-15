package co.kr.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import co.kr.board.service.BoardService;
import co.kr.board.service.mapper.BoardMapper;
import co.kr.board.util.FileUtils;
import co.kr.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	public BoardMapper mapper;
	

	@Autowired
	private FileUtils fileUtils;

	@Override
	public List<BoardVO> list(int page, String type, String keyword) {
	
		//String -> 보내줄값의이름
		//Object-> 넣어줄값의이름 
		HashMap<String, Object> hashMap= new HashMap<String,Object>();
		//한페이지에서 10개의 게시물을 보여줄거라고 선언해준다 
		int amount=10;
		
		hashMap.put("startRn", (page-1)*amount);
		hashMap.put("endRn", page*amount);
		hashMap.put("type", type);
		hashMap.put("keyword", keyword);
		
		return mapper.list(hashMap);
	}

	@Override
	public int total() {
		
		return mapper.total();
	}

	@Override
	public BoardVO getBoard(int bnum) {
		// TODO Auto-generated method stub
		return mapper.getBoard(bnum);
	}

	@Override
	public int insert(BoardVO boardVO) throws Exception {

		
		return mapper.insert(boardVO);
	
		
	}

	@Override
	public int cntMax() {
		
		return mapper.cntMax();
	}

	@Override
	public int update(BoardVO vo) {
		
		return mapper.update(vo);
	}

	@Override
	public int delete(int bnum) {
		
		return mapper.delete(bnum);
	}

	@Override
	public int cntUpdate(int cnt) {
		// TODO Auto-generated method stub
		return mapper.cntUpdate(cnt);
	}


	

}
