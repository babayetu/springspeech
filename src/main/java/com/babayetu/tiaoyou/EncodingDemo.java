package com.babayetu.tiaoyou;

import java.io.UnsupportedEncodingException;

public class EncodingDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(System.getProperty("user.country"));
		System.out.println(System.getProperty("user.language"));
		System.out.println(System.getProperty("sun.jnu.encoding"));
		System.out.println(System.getProperty("file.encoding"));
		
		System.out.println("转码后输出");
		String s = "比瓦刘";
		String s1 = new String(s.getBytes(),"UTF-8");
		String s2 = new String(s.getBytes("UTF-8"),"UTF-8");
		String s3 = new String(s.getBytes("UTF-8"));
		String s4 = new String(s.getBytes(),"UTF-8");
		String s5 = new String(s.getBytes("GBK"));
		String s6 = new String(s.getBytes("GBK"),"GBK");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);
	}

}
