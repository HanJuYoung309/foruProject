package co.kr.board.service;

import co.kr.board.vo.MemberVO;

public interface MemberService {

	public void register(MemberVO vo);
	
	//로그인
	public MemberVO login(MemberVO vo);
	
	//회원정보수정
	public void memberUpdate(MemberVO vo);
	
	//회원탈퇴
	public void memberDelete(MemberVO vo);
	
	//패스워드체크
	public int passChk(MemberVO vo);
	
	//아이디 중복체크
	
	public int idChk(MemberVO vo);
}
