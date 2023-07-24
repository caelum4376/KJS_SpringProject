package com.sist.main2;

public class MainClass {
	public static void main(String[] args) {
		Hello hello = new HelloImp1();
		String msg = hello.sayHello("홍길동");
		System.out.println(msg);
	}
}
