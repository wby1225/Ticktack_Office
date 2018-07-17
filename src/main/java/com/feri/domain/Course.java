package com.feri.domain;

import java.util.Date;

public class Course {
	private int id;
	private String name;
	private Date createtime;
	private int flag;
	private int week;
	private int type;

	public Course() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", createtime=" + createtime + ", flag=" + flag + ", week="
				+ week + ", type=" + type + "]";
	}

}
