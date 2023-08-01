package com.sist.main;
/*
 * 		AOP : trigger와 유사
 */
public class MainClass {
	public static void main(String[] args) {
		Sawon s = new Sawon();
		s.display();
		Proxy p = new Proxy(s);
		p.display();
	}
}
