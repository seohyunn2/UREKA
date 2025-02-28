-- 1. CLERK 업무를 담당하고 급여 1000보다 많이 받는 사원의
--    사원번호, 이름, 급여, 부서명을 조회하시오

select empno, ename, sal, dname
from emp e, dept d
where e.deptno = d.deptno and job = 'CLERK' and sal > 1000;

-- 2. 사원 이름, 급여, 근무도시명을 조회하시오
select ename, sal, loc
from emp e, dept d
where e.deptno = d.deptno;

-- 3. DALLAS에 근무하는 사원 중 입사년도가 2010년도인 사원의 모든 정보 조회하시오
select * 
from emp e, dept d
where e.deptno = d.deptno and d.loc = 'DALLAS' and date_format(hiredate, '%Y') = 2010;
													-- year(e.hiredate) = 2010

-- 4. 이름에 'A' 문자를 포함한 사원의 사원번호, 이름, 업무, 급여, 급여등급을 조회하시오
select empno, ename, job, sal, grade
from emp
join salgrade
on sal between losal and hisal
where ename like '%A%';

-- 5. 사원번호, 이름, 급여, 급여 등급을 조회하시오
select empno, ename, job, sal, grade
from emp
left join salgrade
on sal between losal and hisal;

-- 6. 모든 사원번호, 사원이름, 업무, 상사번호, 상사이름
select e.empno, e.ename, e.job, e.mgr, m.ename as '상사이름'
from emp e
left join emp m
on e.mgr = m.empno;

-- 7. 게시글 번호, 작성자 아이디,  타이틀, 등록일, 내용,
-- 사용자가 올린 파일 이름, 저장된 파일 이름을 추출

-- 8. BLAKE를 관리자로 하는 사원의 모든 정보를 추출
select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno
from emp e, emp m
where e.mgr = m.empno and m.ename = 'BLAKE';

-- 9. 급여 등급이 1등급에 해당하는 사원의 모든 정보를 추출
select empno, ename, job, mgr, hiredate, sal, comm, deptno
from emp
left join salgrade
on grade = 1;

-- 10. GOODS 테이블에 등록된 총 상품 개수와 분류명별 상품 개수를 추출
select if(grouping(name) = 1, 'total', ifnull(name, '미분류')) as '카테고리', count(*) as '총 상품 개수' 
from goods
left join category
using (cno)
group by name with rollup;

        







