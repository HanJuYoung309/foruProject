package co.kr.board.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.service.MemberService;
import co.kr.board.service.mapper.MemberMapper;
import co.kr.board.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper mapper;
	
	@Override
	public void register(MemberVO vo) {
		mapper.register(vo);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		
		return mapper.login(vo);
	}

	@Override
	public void memberUpdate(MemberVO vo) {
		mapper.memberUpdate(vo);
		
	}

	@Override
	public void memberDelete(MemberVO vo) {
		mapper.memberDelete(vo);
		
	}

	@Override
	public int passChk(MemberVO vo) {
		
		return mapper.passChk(vo);
	}

	@Override
	public int idChk(MemberVO vo) {
		
		return mapper.idChk(vo);
	}

	@Override
	public int maxCnt() {
		// TODO Auto-generated method stub
		return mapper.maxCnt();
	}

}
