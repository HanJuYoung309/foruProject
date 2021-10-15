package co.kr.board.service.mapper;

import org.apache.ibatis.annotations.Mapper;

import co.kr.board.vo.MemberVO;

@Mapper
public interface MemberMapper {

	public void register(MemberVO vo);

	public MemberVO login(MemberVO vo);

	public void memberUpdate(MemberVO vo);

	public void memberDelete(MemberVO vo);

	public int passChk(MemberVO vo);

	public int idChk(MemberVO vo);

	public int maxCnt();

}
