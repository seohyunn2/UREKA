-- 1. CLERK 업무를 담당하고 급여 1000보다 많이 받는 사원의
--    사원번호, 이름, 급여, 부서명
   SELECT EMPNO, ENAME, SAL, DNAME, JOB
   FROM EMP E, DEPT D
   WHERE  E.DEPTNO = D.DEPTNO AND JOB='CLERK' AND SAL>1000;

-- ANSI JOIN
   SELECT EMPNO, ENAME, SAL, DNAME, JOB
   FROM EMP E
   JOIN DEPT D
   ON   E.DEPTNO = D.DEPTNO
   WHERE JOB='CLERK' AND SAL>1000;

   SELECT EMPNO, ENAME, SAL, DNAME, JOB
   FROM EMP E
   JOIN DEPT D
   USING  (DEPTNO)
   WHERE JOB='CLERK' AND SAL>1000;

-- 2. 사원 이름, 급여, 근무도시명을 조회
   SELECT ENAME, SAL, E.DEPTNO, LOC
   FROM EMP E, DEPT D
   WHERE E.DEPTNO = D.DEPTNO;

   SELECT ENAME, SAL, DEPTNO, LOC
   FROM EMP E
   JOIN DEPT D
   USING(DEPTNO);

-- 3. DALLAS에 근무하는 사원 중 입사년도가 2010 년도인 사원의 모든 정보 조회
   SELECT *
   FROM EMP E, DEPT D
   WHERE E.DEPTNO = D.DEPTNO AND LOC='DALLAS'
         AND  date_format(HIREDATE,'%Y')='2010';

   SELECT *
   FROM EMP E
   JOIN DEPT D
   USING(DEPTNO)
   WHERE LOC='DALLAS'  AND  year(HIREDATE)='2010';

-- 4. 이름에 'A' 문자를 포함한 사원의 사원번호, 이름, 업무, 급여, 급여등급

  SELECT EMPNO, ENAME, JOB, SAL, GRADE
   FROM EMP
   JOIN SALGRADE
   ON SAL BETWEEN LOSAL AND HISAL
  WHERE ENAME LIKE '%A%';




-- NONE EQUI JOIN : 두 테이블의 컬럼 정보가 일치하지 않아도
--                  주어진 조건에 맞으면 추출됨.
-- 5. 사원번호, 이름, 급여, 급여 등급
SELECT EMPNO, ENAME, SAL, GRADE, HISAL, LOSAL
FROM EMP, SALGRADE
WHERE SAL BETWEEN LOSAL AND HISAL;

SELECT * FROM EMP;


SELECT *
FROM EMP
WHERE SAL  < ANY ( SELECT AVG(SAL)
	              FROM EMP
                  GROUP BY DEPTNO ) ;

-- self join : join 할 테이블 대상이 자신
-- 6. 사원번호, 사원이름, 업무, 상사번호, 상사이름 (상사가 없는 경우에도 조회)
SELECT  e.empno, e.ename, e.job, e.mgr, m.ename
FROM   EMP e  				/*사원정보 */
left join   EMP m  			/*상사 정보 */
on     e.mgr = m.empno;


-- 7. 게시글 번호, 작성자 아이디,  타이틀, 등록일, 내용,
-- 사용자가 올린 파일 이름, 저장된 파일 이름을 추출
-- 모든 게시글 정보를 추출
SELECT b.NO, id, title, regdate, contents, rfilename, sfilename
FROM  board b
left join boardfile
on  b.NO = bno;

SELECT b.NO, id, title, regdate, contents, rfilename, sfilename
FROM boardfile
right join board b
on  b.NO = bno;

-- 8. BLAKE를 관리자로 하는 사원의 모든 정보를 추출
SELECT e.empno, e.ename,e.mgr, e.sal, e.job, e.hiredate, e.comm, e.deptno
FROM EMP e, EMP m
WHERE e.mgr = m.EMPNO AND m.ENAME='BLAKE';

SELECT * FROM EMP;
SELECT * FROM EMP WHERE MGR = 7698;

SELECT e.empno, e.ename,e.mgr, e.sal, e.job, e.hiredate, e.comm, e.deptno
FROM EMP e
JOIN EMP m
ON e.mgr = m.EMPNO
WHERE m.ENAME='BLAKE';

-- 9. 급여 등급이 1등급에 해당하는 사원의 모든 정보를 추출
   SELECT EMPNO, ENAME, MGR, SAL, JOB, HIREDATE, COMM, DEPTNO, GRADE
   FROM EMP,   SALGRADE
   WHERE SAL BETWEEN LOSAL AND HISAL AND GRADE = 1;

   SELECT EMPNO, ENAME, MGR, SAL, JOB, HIREDATE, COMM, DEPTNO, GRADE
   FROM EMP
   JOIN SALGRADE
   ON SAL BETWEEN LOSAL AND HISAL
   WHERE GRADE = 1;


SELECT * FROM EMP;

SELECT * FROM SALGRADE;




-- 10. GOODS 테이블에 등록된 총 상품 개수와 분류명별 상품 개수를 추출
select  if(grouping(name)=1, '총 상품 수', ifnull(name,'미분류')) name
		,  count(*) "등록된 상품 수"
from GOODS g
left JOIN  CATEGORY c
USING (cno)
group by name with rollup ;
