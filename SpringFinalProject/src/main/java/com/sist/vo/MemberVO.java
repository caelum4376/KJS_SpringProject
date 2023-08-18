package com.sist.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
/*
 * id varchar2(1000),
	pwd varchar(1000) CONSTRAINT psm_pwd_nn NOT NULL,
	name varchar2(51) CONSTRAINT psm_name_nn NOT NULL,
	sex varchar2(10),
	birthday varchar2(30) CONSTRAINT psm_birth_nn NOT NULL,
	email varchar2(120),
	post varchar2(10) CONSTRAINT psm_post_nn NOT NULL,
	addr1 varchar2(300) CONSTRAINT psm_addr1_nn NOT NULL,
	addr2 varchar2(300),
	phone varchar2(15),
	content clob,
	admin char(1) DEFAULT 'n',
	regdate DATE DEFAULT sysdate,
	CONSTRAINT psm_id_pk PRIMARY KEY(id),
	CONSTRAINT psm_sex_ck check(sex IN('남자', '여자')),
	CONSTRAINT psm_email_uk UNIQUE(email),
	CONSTRAINT psm_phone_uk UNIQUE(phone)
 */
@Getter
@Setter
public class MemberVO {
	private String id, pwd, name, sex, birthday, email, post, addr1, addr2, content, admin;
	private String phone, phone1, phone2, dbday, msg;
	private Date regdate;
	private String role;
}
