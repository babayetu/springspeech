package com.babayetu.misc;

public class HelloClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		HelloClassLoader helloClassLoader = new HelloClassLoader();
		helloClassLoader.loadClass();

	}
	
	public void loadClass() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("com.babayetu.misc.MyMediaPlayer");
		ClassLoader classLoader = clazz.getClassLoader();
		System.out.println(classLoader.getClass().getSimpleName());
		
		while(classLoader.getParent() != null) {
			classLoader = classLoader.getParent();
			System.out.println("parent is " + classLoader.getClass().getSimpleName());
		}
	}

}
