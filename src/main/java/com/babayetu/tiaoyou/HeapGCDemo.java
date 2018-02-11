package com.babayetu.tiaoyou;

public class HeapGCDemo {

	public static void main(String[] args) {
		byte[] b1 = new byte[1024 * 1024 /2];
		byte[] b2 = new byte[1024 * 1024 * 8];
		b2 = null;
		b2 = new byte[1024 * 1024 * 8]; //空间不够了，进行youngGC
		System.gc();

	}

}
