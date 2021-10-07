package co.kr.board.vo;

import java.util.Date;

public class ReplyVO {
	
	private int bnum;
	private int rnum;
	private String content;
	private String writer;
	private Date regdate;
	
	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public ReplyVO(int bnum, int rnum, String content, String writer, Date regdate) {
		//super();
		this.bnum = bnum;
		this.rnum = rnum;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ReplyVO [bnum=" + bnum + ", rnum=" + rnum + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + "]";
	}
	

}
