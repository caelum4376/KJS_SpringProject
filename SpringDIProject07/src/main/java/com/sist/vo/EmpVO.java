package com.sist.vo;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmpVO {
	private int empno, sal, deptno, comm;
	private String ename, job, dbday, dbsal;
	private Date hiredate;
}
