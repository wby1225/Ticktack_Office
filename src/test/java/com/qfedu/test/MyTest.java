package com.qfedu.test;

import org.junit.Test;

import com.feri.common.util.MD5Utils;

public class MyTest {

	@Test
	public void test1() {
		System.out.println("admin--->"+MD5Utils.md5("admin"));
		System.out.println("123456--->"+MD5Utils.md5("123456"));
	}
}
