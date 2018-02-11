package com.babayetu.tiaoyou;

public class StackDepthEval {
	private static int count = 0;
	
	private void recursion(long a,long b,long c) {
		long d=0,e=0,f=0;
		count++;
		recursion(a,b,c);
	}
	
	public static void main(String[] args) {
		StackDepthEval sde = new StackDepthEval();
		try {
			sde.recursion(1L,2L,3L);
		} catch (Throwable e) {
			System.out.println("stack depth is " + count);
			e.printStackTrace();
		}

	}

}
