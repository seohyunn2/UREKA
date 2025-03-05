-- 1.상사가 BLAKE인 사원들의 모든 정보를 조회하시오
select * from emp
where mgr = (select empno from emp where ename='BLAKE');

-- 2.10번 부서의 평균 급여보다 많이 받는 사원들의 모든 정보를 조회하시오
select * from emp
where sal > (select avg(sal) from emp where deptno = 10);

-- 3.ADAMS 사원과 같은 업무이면서 MILLER 사원 보다 적은 급여를 받는 사원들의 모든 정보를 조회하시오
select * from emp 
where job = (select job from emp where ename = 'ADAMS') 
	and sal < (select sal from emp where ename = 'MILLER');

-- 4.태양의 마테차를 구매한 모든 회원정보를 조회하시오.
-- goods에서 해당 상품의 gno 파악 -> orders에서 해당 gno가 있는 주문 내역들의 id 조회 -> 그 id가 members의 id인 거 다 가져와
select * from members 
where id in (select id from orders 
				where gno = (select gno from goods where brand = '태양의 마테차'));
                
select *
from members 
where id in (select distinct id
			from orders
			join goods
			using (gno)
			where brand = "태양의 마테차");

-- 5.부하직원이 있는 사원을 조회하시오.
select *
from emp
where empno in (select distinct mgr from emp);

-- 6.카테고리별 최저 가격인 상품을 조회하시오
select *
from goods 
join (select cno, min(price) as minPrice from goods group by cno) g
using (cno)
where price = minPrice;

-- cno가 없는 상품도 조회가 됨.
select *
from goods g
where price <= all (select price from goods c where g.cno = c.cno);

-- 7.2000년에 입사한 사원들 중 평균 급여보다 적게 받는 사원들의 모든 정보를 조회하시오
select * from emp 
where sal < (select avg(sal) from emp) and year(hiredate) = 2000;

-- 8.30번 부서에 근무하지 않는 사원들 중 평균 급여보다 많이 받는 사원들의 모든 정보를 조회하시오
select * from emp 
where sal > (select avg(sal) from emp) and deptno != 30;

-- 9.평사원(부하직원이 없는)을 조회하시오
select *
from emp e
where e.empno not in (select m.empno from emp m
						where m.empno in (select mgr from emp));
                        
select *
from emp
where empno not in (select distinct mgr from emp where mgr is not null);

