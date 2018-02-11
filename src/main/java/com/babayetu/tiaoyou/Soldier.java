package com.babayetu.tiaoyou;

import java.util.Iterator;
import java.util.TreeMap;

public class Soldier implements Comparable<Soldier>{
	private String name;
	private int score;
	
	
	public Soldier(String name, int score) {
		this.name = name;
		this.score = score;
	}


	@Override
	public String toString() {
		return "Soldier [name=" + name + ", score=" + score + "]";
	}


	public static void main(String[] args) {
		TreeMap<String, Soldier> tm = new TreeMap<String, Soldier>();
		tm.put("2", new Soldier("maly",20));
		tm.put("1", new Soldier("jill",10));
		tm.put("3", new Soldier("bot",30));
		
		for (Iterator<String> it = tm.keySet().iterator(); it.hasNext();) {
			String key = (String) it.next();
			System.out.println(key+"->"+tm.get(key));
			
		}
	}


	@Override
	public int compareTo(Soldier o) {
		if (this.score > o.score) {
			return 1;
		} else if (this.score < o.score) {
			return -1;
		} else {
			return 0;
		}
	}

}
