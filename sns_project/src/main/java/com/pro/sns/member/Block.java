package com.pro.sns.member;

public class Block {
	/* 1. block을 하면 차단한 사람을 차단목록에서 보여주고 : select문에서 member.img, block.target을 가져온다.
	 *  -> block.jsp에서 보여줘야 함 ArrayList<Block>으로 출력해서 그 목록을 보여줘야 한다.
	 *  -> select sns_member.img, sns_personal_block.target, sns_personal_block.num(삭제 버튼을 눌렀을 때 그 번호가
	 *  전달 되어야 한다)
	 *  
	 * 2. 차단한 사람이 작성한 게시글을 보지 않는다 : target이랑 똑같은 writer를 가졌을 경우 해당 게시물은 보여주지 않는다.
	 *  -> index에서 해야할 일
	 *   
	 * 3. 삭제할때 table에서 있는 num을 가져 와야 한다. 
	 */
	
	private int num;
	private String requester;
	private String target;
	private Member member;
	
	public Block(int num, String requester, String target, Member member) {
		super();
		this.num = num;
		this.requester = requester;
		this.target = target;
		this.member = member;
	}

	public Block(int num, String requester, String target) {
		super();
		this.num = num;
		this.requester = requester;
		this.target = target;
	}

	public Block() {
		super();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Block [num=" + num + ", requester=" + requester + ", target=" + target + ", member=" + member + "]";
	}
	
	

}
