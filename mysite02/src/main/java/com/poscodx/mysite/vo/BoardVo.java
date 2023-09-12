package com.poscodx.mysite.vo;

public class BoardVo {
	private Long no;
	private String title;
	private String contents;
	private Long hit;
	private String date;
	private Long gNo;
	private Long oNo;
	private Long depth;
	private Long userNo;
	private String userName;

	public BoardVo() {
	}

	

	public BoardVo(Long no, String title, String contents, Long hit, String date, Long gNo, Long oNo, Long depth,
			Long userNo, String userName) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.hit = hit;
		this.date = date;
		this.gNo = gNo;
		this.oNo = oNo;
		this.depth = depth;
		this.userNo = userNo;
		this.userName = userName;
	}



	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Long getHit() {
		return hit;
	}

	public void setHit(Long hit) {
		this.hit = hit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getgNo() {
		return gNo;
	}

	public void setgNo(Long gNo) {
		this.gNo = gNo;
	}

	public Long getoNo() {
		return oNo;
	}

	public void setoNo(Long oNo) {
		this.oNo = oNo;
	}

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	
	

	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", contents=" + contents + ", hit=" + hit + ", date=" + date
				+ ", gNo=" + gNo + ", oNo=" + oNo + ", depth=" + depth + ", userNo=" + userNo + ", userName=" + userName
				+ "]";
	}




}
