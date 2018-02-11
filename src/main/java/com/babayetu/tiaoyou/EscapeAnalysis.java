package com.babayetu.tiaoyou;

public class EscapeAnalysis {
	public static B b;
	public void globalVarPointerEscape() {
		//给全局变量赋值，发生逃逸
		b = new B();
	}
	public B methodPointerEscape() {
		//方法返回值，发生逃逸
		return new B();
	}
	public void instancePassPointerEscape() {
		//实例引用发生逃逸
		methodPointerEscape().printClassName(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class B {
		public void printClassName(EscapeAnalysis g) {
			System.out.println(g.getClass().getName());
		}
	}

}
