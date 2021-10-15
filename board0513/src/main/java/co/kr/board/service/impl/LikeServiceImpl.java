package co.kr.board.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.service.LikeService;
import co.kr.board.service.mapper.LikeMapper;


@Service
public class LikeServiceImpl  implements LikeService{
	
	@Autowired
	public LikeMapper mapper;

	@Override
	public int insert(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.insert(param);
	}

	@Override
	public int delete(int bnum, int usernum) {
		// TODO Auto-generated method stub
		return mapper.delete(bnum,usernum);
	}

	@Override
	public int likeCnt(int bnum) {
		// TODO Auto-generated method stub
		return mapper.likeCnt(bnum);
	}

	@Override
	public int likeMax() {
		// TODO Auto-generated method stub
		return mapper.likeMax();
	}

	@Override
	public int likeBtn(HashMap<String, Object> param) {
		// TODO Auto-generated method stub
		return mapper.likeBtn(param);
	}
	
	

}
