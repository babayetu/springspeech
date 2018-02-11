package com.babayetu.tiaoyou;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CacheDemo {

	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(
						new BufferedOutputStream(
						new FileOutputStream("1.txt")));
		dos.writeUTF("hellomazada");
		//dos.flush();
		dos.close();
		
		FileInputStream fis = new FileInputStream("1.txt");
		int len = fis.available();
		byte[] b = new byte[len];
		int actLen = fis.read(b);
		String str = new String(b);
		System.out.println("input is: " + str);
		fis.close();
	}

}
