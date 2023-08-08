package com.sist.vo;

import lombok.Getter;
import lombok.Setter;
/*
 * 		1. 페이지 기법
 * 		2. Cookie
 * 		3. Session
 * 		4. 로그인 => password 암호화 / 복호화
 * 		5. Front => Vue => watch / computed / component / filter
 */
@Getter
@Setter
public class GoodsVO {
	private int no, discount, hit, account;
	private String name, sub, price, first_price, delivery, poster;
}
