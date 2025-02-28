-- 부서별   사원수,  급여 평균, 커미션을 받는 사원 수를 조회 하시오
select deptno, count(*) as '사원수', avg(comm) as '급여 평균', count(comm) as '커미션을 받는 사원 수'
from emp
group by deptno;

-- 업무별   평균 급여, 최저 급여, 최고 급여를 조회 하시오
select job, round(avg(sal),2) as '평균 급여', min(sal) as '최저 급여', max(sal) as '최고 급여'
from emp
group by job;

-- 부서별, 업무별 통계  : 사원수,  급여 평균, 커미션을 받는 사원 수를 조회 하시오
select deptno, job, count(*) as '사원수', avg(sal) as '급여 평균', count(comm) as '커미션 사원 수'
from emp
group by deptno, job
order by deptno, job;

-- 부서별 총 급여가 10000이하인 부서의 총 사원수, 총 급여를 조회
select deptno, count(*) as '사원수', sum(sal) as '총 급여'
from emp
group by deptno
order by deptno;

-- 부서별 총 급여를 조회,  급여가 1000이상인 사원들의 급여 합계를 구함.
select deptno, sum(sal) as '급여 합계'
from emp
where sal >= 1000
group by deptno
order by deptno;

-- 상품별 수량이 10개 초과인 제품에 대해 상품별 총 판매 수량 조회
-- ?????????????
select gno, sum(quantity) as '총 판매 수량'
from orders
where quantity > 10
group by gno;

-- 건당 판매 수량이 2개 이상인 판매 건수를 상품별 조회
select gno, count(ono) as '판매 건수'
from orders
where quantity >= 2
group by gno;


