package com.sist.main;
/*
 * 		MainClass는 Hello클래스에 의존을한다
 * 		=> 결합성이 강한 프로그램
 * 		=> 장점 : 연결하기 쉽다, 단점은 변경시에 다른 클래스에 영향력이 강하다
 * 							 ---------------------------------
 * 			스프링에서는 방지(의존성이 낮은 프로그램을 구현)
 */
public class MainClass {
	public static void main(String[] args) {
		Hello hello = new Hello();
		String msg = hello.syaHello("홍길동");
		System.out.println(msg);
	}
}
