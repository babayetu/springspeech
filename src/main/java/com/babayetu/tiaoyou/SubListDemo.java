package com.babayetu.tiaoyou;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo {

	public static void main(String[] args) {
		List<String> paList = new ArrayList<String>();
		
		for (int i = 0; i < 5; i++) {
			paList.add(String.valueOf(i));
		}
		
		List<String> subList = paList.subList(1, 3);
		for (String s : subList) {
			System.out.println(s);
		}
		
		System.out.println("-----------------");
		
		//非结构性set，影响父List
		subList.set(0, "new 1");
		for (String s : paList) {
			System.out.println(s);
		}
		
		//结构性add，影响父List
		subList.add(String.valueOf(2.5));
		for (String s : paList) {
			System.out.println(s);
		}		
		
		System.out.println("-----------------");
		
		//父List非结构性修改，影响子List
		paList.set(2, "new 2");
		
		for (String s : subList) {
			System.out.println(s);
		}
		System.out.println("-----------------");
		
		//结构性add，影响子List
		paList.add("undefined");
		for (String s : subList) {
			System.out.println(s);
		}
		
		System.out.println("-----------------");
		subList.get(0);
	}

}
