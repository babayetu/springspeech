package com.babayetu.misc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * 演示使用自定义的网络ClassLoader动态加载远程的class文件
 * @author jingjing03.liu
 *
 */
public class NetworkClassLoader extends ClassLoader{
	
	public Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] classContent = downloadClassBytes(name);
		if (classContent == null) {
			super.findClass(name);
		} else {
			return defineClass(name, classContent, 0, classContent.length);
		}
		
		return null;
	}
	
	private byte[] downloadClassBytes(String name) {
		int lastDotPos = name.lastIndexOf(".");
		String className = "";
		if (lastDotPos != -1) {
			className = name.substring(lastDotPos);
			System.out.println("last class name " + className);
		} else {
			System.out.println("not dot is found in class name");
			return null;
		}
		String urlPath = "http://10.199.199.63:10888/"+className+".class";
		
		try {
			URL url = new URL(urlPath);
			InputStream openStream = url.openStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int byteNumRead = 0;
			while((byteNumRead=openStream.read(buffer)) != -1) {
				baos.write(buffer, 0, byteNumRead);
			}
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public String getName() {
		return "MyNetworkLoader";
	}

	public static void main(String[] args) {
		NetworkClassLoader nlc = new NetworkClassLoader();
		try {
			Class<?> myClass = nlc.loadClass("com.babayetu.misc.MyMediaPlayer");
			System.out.println(myClass.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
