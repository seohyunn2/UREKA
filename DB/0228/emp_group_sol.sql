-- 1.부서별   사원수,  급여 평균, 커미션을 받는 사원 수를 조회 하시오
SELECT  deptno, COUNT(*)  "총사원수",
        COUNT(comm) "커미션 사원수",
        AVG(sal)  "급여 평균"
FROM EMP
GROUP BY deptno;

-- 2.업무별   평균 급여, 최저 급여, 최고 급여를 조회 하시오
SELECT  job,  AVG(sal)  "급여 평균",
        MAX(sal)  "최고 급여 금액", MIN(sal) "최저 급여"
FROM EMP
GROUP BY job;

-- 3.부서별, 업무별 통계  : 사원수,  급여 평균, 커미션을 받는 사원 수를 조회 하시오
SELECT  deptno, job, COUNT(*)  "총사원수",
        COUNT(comm) "커미션 사원수",
        SUM(sal)  "총급여",   AVG(sal)  "급여 평균"
FROM EMP
GROUP BY deptno,job
ORDER BY deptno ;


-- 4.부서별 총 급여가 10000이하인 부서의 총 사원수, 총 급여를 조회
SELECT  deptno,  COUNT(*)  "총사원수",
        COUNT(comm) "커미션 사원수",
        SUM(sal)  "total",   AVG(sal)  "급여 평균"
FROM EMP
GROUP BY deptno
HAVING  total<10000;

-- 5.부서별 총 급여를 조회,  급여가 1000이상인 사원들의 급여 합계를 구함.
SELECT  deptno,  COUNT(*)  "총사원수",
        COUNT(comm) "커미션 사원수",
        SUM(sal)  "총급여",   AVG(sal)  "급여 평균"
FROM EMP
WHERE sal>=1000
GROUP BY deptno
ORDER BY deptno;


-- 6.상품별 수량이 10개 초과인 제품에 대해 상품별 총 판매 수량 조회
SELECT gno, SUM(quantity)
FROM ORDERS
GROUP BY gno
HAVING SUM(quantity)>10;

-- 7.건당 판매 수량이 2개 이상인 판매 건수를 상품별 조회
SELECT gno, COUNT(quantity)
FROM ORDERS
WHERE quantity >= 2
GROUP BY gno;


