package com.sist.dao;

public class BoardDAO {
	public String find(String name) {
		System.out.println("Find 수행...");
		return name;
	}
	public void aopSelect(String name) {
		System.out.println(name + " : SELECT 문장 수행"); // 핵심모듈
	}
	public void aopInsert(String name) {
		System.out.println(name + " : INSERT 문장 수행");
	}
	public void aopUpdate(String name) {
		System.out.println(name + " : UPDATE 문장 수행");
	}
	public void aopDelete(String name) {
		System.out.println(name + " : DELETE 문장 수행");
	}
}
