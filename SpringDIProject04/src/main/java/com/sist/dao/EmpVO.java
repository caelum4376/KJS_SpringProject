package com.sist.dao;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpVO {
	private int empno, mgr, sal, deptno, comm;
	private String ename, job, dbday;
	private Date hiredate;
}
