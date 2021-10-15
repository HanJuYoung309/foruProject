package co.kr.board.service.mapper;

import java.util.HashMap;

public interface LikeMapper {

	int insert(HashMap<String, Object> param);

	int delete(int bnum, int usernum);

	int likeCnt(int bnum);

	int likeMax();

	int likeBtn(HashMap<String, Object> param);

}
