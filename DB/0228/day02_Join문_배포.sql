/*
 Join 
 - 두개 이상의 테이블을 연결해서 질의하는 것
 - 종류 
    1. 데이타 추출되는 것에 따라 
      Inner Join : 
        - 조인을 위해 사용하는 비교 조건에 맞는 데이타만 조회
        - 조인 조건에 맞지 않은 데이타는 조회 되지 않는다. 
        - join할 때  outer join으로 표시 하지 않으면 기본적으로 
          Inner join으로 조회된다. 
      Outer Join 
        - 조인을 위해 사용하는 비교 조건에 맞지 않는 데이타도 조회된다. -> 기준이 되는 테이블이 있으면 조건에 맞지 않아도 다 보여줌 
		- 종류 
          left outer join  : 비교 조건에 맞지 않은 왼쪽 테이블의 데이타도 조회됨
          right outer join : 비교 조건에 맞지 않은 오른쪽 테이블의 데이타도 조회됨
          full outer join  : 비교 조건에 맞지 않은 양쪽 테이블의 모든 데이타가 조회됨 (지원 X)
    2. 비교 조건에 따라서 
	  Equi join 
        - 비교하는 두 컬럼의 데이타가 정확하게 일치할 경우 
        - join 조건으로 = 비교 연산자를 이용할 경우 
      Non Equi join 
        - 비교하는 두 컬럼의 데이타가 정확하게 일치하지 경우 
        - join 조건으로  >, < , >= , <=, != 등
    3. 비교 테이블에 따라서 
	     self join 
        - join할 테이블이 다른 테이블이 아닌 self(한개의 테이블로 join)
        - 테이블을 구별하기 위해 반드시 alias를 사용해야 한다. 
        
    4.Natural join - 잘 안씀
    		- 두 테이블에서 동일한 컬럼명을 갖는 컬럼을 조인 조건으로 사용한다. 
    		- inner join과 같은 결과를 갖는다
    		 
    		
    5.카티시안 곱 (Cross Join) - 잘 안씀
      - 조인 조건을 생략했을 때 두 테이블의 모든 row를 연결한 결과가 조회된다. 
	  - N * M의 수만큼 행이 조회된다. 
	  
	   
*/

-- 카티시안 곱 
select gno, brand, price, goods.cno as cno
     , category.cno as 분류번호 ,  name
from   goods, category; 

/*
 inner join 
 -DB 벤더 전용 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias], 테이블명 [alias] , 
  [where  조건]
  [group by 컬럼명, .. [having 조건]]
  [order by 컬럼명 [asc|desc]], ...]
  
 -ANSI query 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias]
  join   테이블명 [alias]
  on 조인 조건 | using(조인 컬럼)
  ,...
  [where  조건]
  [group by 컬럼명, .. [having 조건]]
  [order by 컬럼명 [asc|desc]], ...]	
 
  using 
   - 조인을 위한 비교 컬럼명이 동일 할 때 사용 
   - alias 없이 사용해야 한다. => 다른 DB는 alias를 사용할 경우 error발생 
   - 비교 조건은 기본적으로 = 이 적용된다. 
   
  on
   - 조인을 위한 비교 컬럼명이 다르거나 비교 조건이 = 이 아닐때 사용한다. 
   - 조인을 위한 비교 컬럼이 같을 경우 alias를 사용해서 구분한다. 
*/

-- 상품번호, 상품명, 상품금액, 카테고리번호, 카네고리이름을 조회한다.
-- inner join  벤더 전용
select gno, brand, price, goods.cno, name
from goods, category
where goods.cno = category.cno
order by gno;

-- 테이블에 alias를 적용
select gno, brand, price, g.cno, name
from goods g, category c
where g.cno = c.cno
order by gno;

-- ansi query
select gno, brand, price, g.cno, name
from goods g
join category c
on g.cno = c.cno
order by gno;

select gno, brand, price, cno, name
from goods
join category
using (cno) -- column 명이 동일할 때, equi join 할 때 => alias 안줘도 알아서 해줌 
order by gno;


-- 주문일, 주문 번호, 주문한 상품 번호, 상품명, 주문자, 상품가격, 주문 수량, 주문 금액을 조회하시오.
-- 주문 금액: goods.price와 orders.quantity 곱
-- vender 전용
select date_format(odate, '%y-%m-%d') as date, ono, o.gno, brand, id, price, quantity,
	price * quantity as totalPrice -- 구별 안해도 되니까 
from orders o, goods g
where o.gno = g.gno
order by odate desc;


-- ansi 
select date_format(odate, '%y-%m-%d') as date, ono, gno, brand, id, price, quantity,
	price * quantity as totalPrice
from orders
join goods
using (gno)
order by odate desc;


-- 이번달에 주문한 상품에 대한 정보 조회 
-- 주문일, 주문 번호, 주문한 상품 번호, 상품명, 주문자, 상품가격, 주문 수량, 주문 금액을 조회하시오.

-- vender 전용
select date_format(odate, '%y-%m-%d') as date, o.gno, g.brand, o.id, g.price, o.quantity, 
	price * quantity as totalPrice
from orders o, goods g
where o.gno = g.gno and 
	date_format(odate, '%y-%m') = date_format(now(), '%y-%m');

-- ansi
select date_format(odate, '%y-%m-%d') as date, gno, brand, id, price, quantity, 
	price * quantity as totalPrice
from orders
join goods
using (gno)
where date_format(odate, '%y-%m') = date_format(now(), '%y-%m');

-- 사원번호, 이름, 업무, 급여, 급여등급을 조회
-- 범위 => using이 아니라 on을 써야됨 (ansi)
-- vender
select empno, ename, job, sal, grade
from emp e, salgrade s
where sal between losal and hisal;


-- where  sal >= losal and sal<=hisal;
-- ansi
select empno, ename, job, sal, grade
from emp
join salgrade
on sal between losal and hisal;

-- 사원번호, 이름, 업무, 급여, 급여등급, 부서번호, 부서명을 조회
-- vender
select empno, ename, job, sal, grade, e.deptno, dname
from emp e, dept d, salgrade
where e.deptno = d.deptno and sal between losal and hisal;

-- ansi
select empno, ename, job, sal, grade, deptno, dname
from emp
join dept
using (deptno)
join salgrade
on sal between losal and hisal
where deptno = 20;

-- 주문번호, 주문일자, 상품명, 주문자명, 가격, 수량, 주문가격을 조회
-- vender 


-- ansi


-- 상품별 주문 수량을 조회하려 한다. 
-- 상품 번호(gno), 상품명(brand), 총 주문된 수량을 조회
-- vender 


/*
 outer join
 -left join 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias] 
  left [outer] join   테이블명 [alias]
  on 조인 조건 | using(조인 컬럼)

 - right join 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias] 
  right [outer] join   테이블명 [alias]
  on 조인 조건 | using(조인 컬럼)
*/

-- inner join으로 dept가 없는 사원은 조회되지 않음 
insert into emp(empno, ename, sal) values(2, 'uplus', 3000); -- 부서 번호가 없는 데이터 추가

select empno, ename, job, deptno, dname
from emp
join dept
using (deptno); 


-- emp테이블을 기준으로 left join하면 deptno가 없는 사원도 조회됨. 
select empno, ename, job, deptno, dname
from emp
left join dept -- from dept right join emp 와 같음
using (deptno); 


-- goods의 모든 상품에 대해 상품번호, 이름, 가격, 분류번호, 분류명을 조회
select gno, brand, price, cno, name
from goods
left join category
using (cno);


-- 모든 상품에 대하여 상품별 주문 수량을 조회하려 한다. 
-- 상품 번호(gno), 상품명(brand), 총 주문된 수량을 조회
select gno, brand, ifnull(sum(quantity), 0) as quantity -- 3
from goods -- 1
left join orders
using (gno)
group by gno with rollup; -- 2

-- 총 주문 수량 rollup까지 하려면...
select if(grouping(gno) = 1, 'total', gno) as goodsNo, 
	if(grouping(gno) = 1, NULL, max(brand)) as brand, ifnull(sum(quantity), 0) as quantity -- 3
from goods -- 1
left join orders
using (gno)
group by gno with rollup; -- 2



select gno, brand, ifnull(quantity, 0) as quantity -- 3
from goods
left join(
	select gno, sum(quantity) as quantity
	from orders
	group by gno) o
using (gno); -- 이렇게 해주면 네 개만 나옴 => 이걸로 조인

/*
self join 
 - 한개의 테이블로 join 
 - 테이블에 alias를 이용해서 구별한다. 
*/
-- 대분류, 중분류, 소분류 

-- 사원번호, 사원이름, 업무, 급여, 상사번호, 상사이름 조회 
-- e로 지정: <사원번호, 사원이름, 업무, 급여>, m으로 지정: <상사번호, 상사이름> 조회 

-- vender
select e.empno, e.ename, e.job, e.sal, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno; 

-- ansi
select e.empno, e.ename, e.job, e.sal, e.mgr, m.ename
from emp e
join emp m
on e.mgr = m.empno; 

-- 모든 사원에 대한 사원번호, 사원이름, 업무, 급여, 상사번호, 상사이름 조회
-- (상사가 없는 사원도 조회) -> null도 같이 조회 
-- 상사번호가 사원번호인 걸로 조인 

select e.empno, e.ename, e.job, e.sal, e.mgr, m.ename
from emp e
left join emp m
on e.mgr = m.empno; 



-- 네이버 면접 질문 
-- weather (ymd : date, temp : int, city : string ) 1년치 데이터가 있다고 할때, 
-- 전날보다 온도가 높아진 날이 가장 많았던 도시를 출력하시오       
-- 어제: 오늘 - 1	-> 오늘: 어제 + 1
-- self join


-- 전날(어제)보다 판매 개수가 많은 날이 가장 많았던 상품을 조회하시오



-- Natural join
-- join 조건을 주지 않고 Natural join이 알아서 조인해줌
-- 동일한 컬럼명을 조인 조건으로 사용 -> 조인 (equi join)
select empno, ename, deptno, dname
from emp 
natural join dept; -- deptno가 같으니까 이걸 조인 조건으로 사용



