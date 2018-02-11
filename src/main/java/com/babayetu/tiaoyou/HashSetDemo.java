package com.babayetu.tiaoyou;

import java.util.HashSet;
import java.util.Set;

//HashSet<T>,T如果不重载hashCode函数
//HashSet底层判断时，不认为是同一个key
public class HashSetDemo {
	public static void main(String[] args) {
		Set<Name> s1 = new HashSet<Name>();
		s1.add(new Name("xiao","ming"));
		System.out.println(s1.contains(new Name("xiao","ming")));
		
		System.out.println(s1.add(new Name("xiao","ming")));
	}
}
