package co.kr.board.service;

import java.util.HashMap;

public interface LikeService {

	int insert(HashMap<String, Object> param);

	int delete(int bnum, int usernum);

	int likeCnt(int bnum);

	int likeMax();

	int likeBtn(HashMap<String, Object> param);

}
