package com.sist.main2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Member {
	private String id;
	private String name;
	private String address;
	private String phone;
	private String sex;
	
	// 개발자가 호출
	public void print() {
		System.out.println("ID : "+id);
		System.out.println("NAME : "+name);
		System.out.println("ADDRESS : "+address);
		System.out.println("PHONE : "+phone);
		System.out.println("SEX : "+sex);
	}
}
