package com.feri.domain;

import java.util.Date;

public class Grade {
	private int id;
	private String no;
	private String name;
	private Date createtime;
	private int flag;
	private int week;
	private String location;

	public Grade() {
		super();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", no=" + no + ", name=" + name + ", createtime=" + createtime + ", flag=" + flag
				+ ", week=" + week + ", location=" + location + "]";
	}

}
