package com.feri.domain;

public class Question {
	private int id;
	private String no;
	private int type;
	private String question;
	private String answer;
	private int flag;
	private int star;
	private int pageview;
	

	public int getPageview() {
		return pageview;
	}

	public void setPageview(int pageview) {
		this.pageview = pageview;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", no=" + no + ", type=" + type + ", question=" + question + ", answer=" + answer
				+ ", flag=" + flag + ", star=" + star + "]";
	}

	public Question() {
		super();
	}

}
