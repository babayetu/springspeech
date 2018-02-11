package com.babayetu.tiaoyou;
//-XX:PermSize=2M -XX:MaxPermSize=4M -XX:+PrintGCDetails

public class PermGenGC {

	public static void main(String[] args) {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			String t = String.valueOf(i).intern();
		}

	}

}
