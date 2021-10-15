package co.kr.board.vo;

import java.util.Date;

public class MemberVO {
	
	private int usernum;
	private String userid;
	private String userPass;
	private String userName;
	private Date regDate;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}


	public MemberVO(int usernum, String userid, String userPass, String userName, Date regDate) {
		super();
		this.usernum = usernum;
		this.userid = userid;
		this.userPass = userPass;
		this.userName = userName;
		this.regDate = regDate;
	}



	public int getUsernum() {
		return usernum;
	}



	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}



	public MemberVO(String userid, String userPass, String userName, Date regDate) {
		//super();
		this.userid = userid;
		this.userPass = userPass;
		this.userName = userName;
		this.regDate = regDate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberVO [usernum=" + usernum + ", userid=" + userid + ", userPass=" + userPass + ", userName="
				+ userName + ", regDate=" + regDate + "]";
	}
	

}
