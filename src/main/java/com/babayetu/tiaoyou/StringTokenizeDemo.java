package com.babayetu.tiaoyou;

import java.util.StringTokenizer;

public class StringTokenizeDemo {
	private final static int ROUNDS = 10000;

	public static void main(String[] args) {
		String orgStr = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ROUNDS; i++) {
			sb.append(i);
			sb.append(",");
			
		}
		
		orgStr = sb.toString();
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < ROUNDS; i++) {
			orgStr.split(",");
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
		
		start = System.currentTimeMillis();
		String orgStr1 = sb.toString();
		
		StringTokenizer st = new StringTokenizer(orgStr1,",");
		for (int i = 0; i < ROUNDS; i++) {
			st.nextToken();
		}
		
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		start = System.currentTimeMillis();
		String orgStr2 = sb.toString();
		String temp = orgStr2;
		
		while(true) {
			String splitStr = null;
			int j = temp.indexOf(",");
			if (j<0) break;
			splitStr = temp.substring(0,j);
			temp = temp.substring(j+1);
		}
		
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
