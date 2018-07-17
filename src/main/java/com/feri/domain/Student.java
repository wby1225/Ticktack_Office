package com.feri.domain;

import java.util.Date;

public class Student {
	private String no;
	private String name;
	private String sex;
	private Date birthday;
	private String cardno;
	private String schoolname;
	private String education;
	private String phone;
	private String email;
	private String qq;
	private String cno;
	private String introno;
	private int flag;
	private Date entrytime;
	private String gname;

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Date getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}

	public Student() {
		super();
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getIntrono() {
		return introno;
	}

	public void setIntrono(String introno) {
		this.introno = introno;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", cardno=" + cardno
				+ ", schoolname=" + schoolname + ", education=" + education + ", phone=" + phone + ", email=" + email
				+ ", qq=" + qq + ", cno=" + cno + ", introno=" + introno + ", flag=" + flag + ", entrytime=" + entrytime
				+ ", gname=" + gname + "]";
	}

}
