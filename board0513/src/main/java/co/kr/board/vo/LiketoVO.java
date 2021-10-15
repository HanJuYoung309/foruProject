package co.kr.board.vo;

public class LiketoVO {
	
	private int likeno;
	private int boardno;
	private int mno;
	private int like_check;
	
	public LiketoVO() {
		// TODO Auto-generated constructor stub
	}

	public int getLikeno() {
		return likeno;
	}

	public void setLikeno(int likeno) {
		this.likeno = likeno;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getLike_check() {
		return like_check;
	}

	public void setLike_check(int like_check) {
		this.like_check = like_check;
	}

	public LiketoVO(int likeno, int boardno, int mno, int like_check) {
		//super();
		this.likeno = likeno;
		this.boardno = boardno;
		this.mno = mno;
		this.like_check = like_check;
	}

	@Override
	public String toString() {
		return "LiketoVO [likeno=" + likeno + ", boardno=" + boardno + ", mno=" + mno + ", like_check=" + like_check
				+ "]";
	}
	
	
	

}
