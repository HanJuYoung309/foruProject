package co.kr.board.service.mapper;

import org.apache.ibatis.annotations.Mapper;

import co.kr.board.vo.MemberVO;

@Mapper
public interface MemberMapper {

	public void register(MemberVO vo);

	public MemberVO login(MemberVO vo);

}
