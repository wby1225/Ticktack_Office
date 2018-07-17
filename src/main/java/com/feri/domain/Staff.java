package com.feri.domain;

import java.util.Date;

public class Staff {
	private String no;
	private String name;
	private String did;
	private int flag;
	private String sex;
	private String email;
	private String qq;
	private String phone;
	private String heading;
	private Date entrytime;
	private String dname;

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Date getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
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

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public Staff() {
		super();
	}

	@Override
	public String toString() {
		return "Staff [no=" + no + ", name=" + name + ", did=" + did + ", flag=" + flag + ", sex=" + sex + ", email="
				+ email + ", qq=" + qq + ", phone=" + phone + ", heading=" + heading + "]";
	}

}
