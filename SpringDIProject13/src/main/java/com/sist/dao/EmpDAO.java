package com.sist.dao;
/*
 * 		service(interface) => serviceImpl => repository
 */
import java.util.*;
import com.sist.vo.*;
import org.mybatis.spring.support.SqlSessionDaoSupport;
public class EmpDAO extends SqlSessionDaoSupport {
	/*
	 <sql id="select-map">
	 	SELECT empno, ename, job, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday,
	 			sal, dname, loc
	 	FROM emp, dept
	 	WHERE emp.deptno = dept.deptno
	 </sql>
	 <select id="empdeptListData" resultMap="empMap">
	 	<include refid="select-map"></include>
	 	ORDER BY sal DESC
	 </select>
	 <select id="empdeptDetailData" resultMap="empMap" parameterType="int">
	 	<include refid="select-map"></include>
	 	AND empno = #{empno}
	 </select>
	 */
	public List<EmpVO> empdeptListData() {
		return getSqlSession().selectList("empdeptListData");
	}
	public EmpVO empdeptDetailData(int empno) {
		return getSqlSession().selectOne("empdeptDetailData", empno);
	}
}
