/*
 DML문(Data Manipulation language)
 - data를 insert, update, delete하는 문장
 - dml문을 수행하면 수행된 내용이 임시저장소에 저장되어 실제 DB에는 반영되지 않는다. 
 - DML문을 수행후 TCL(Transaction Controll language)을 수행해야한다. 
	TCL문 
     commit         	 	: 디비에 반영
     savepoint 이름  	 		: 임시 저장 위치 
     rollback       	 	: 작업한 모든 dml문 수행 취소
     rollback to 세이브포인트이름: 지정한 savepoint까지 취소 
 - update, delete문을 수행하면 commit 또는 rollback하기 전까지 
   해당 Record는 lock된다.
   
   
*** 레코드 락(Record Lock)
Record Lock이란 row의 index를 기준으로 Lock을 거는 것으로  아래와 같은 쿼리에 해당 Lock이 걸립니다. (commit이나 rollback 하기 전까지)
트랜잭션에서 해당 index의 row에 insert, update, delete 구문 사용이 락이 걸려있는 동안은 불가능해집니다.      
*/

-- insert into emp (empno, ename, sal) values(3, '이서현', 10000);
select * from emp; 

update emp set job="ANALYST" where empno = 2;
commit;
/*
데이타 추가 
insert into 테이블명(컬럼명, ....) values(값,...)
- 테이블에 지정한 컬럼에 지정한 값으로 추가 

insert into 테이블명 values(값,...)
- 개발할 때 이거 쓰지 X -> 테이블 구조 달라지면 오류가 남
- 테이블 구조에 설정된 모든 컬럼에 구조에 지정된 순서대로 값이 설정되서 insert됨

-- mysql만
insert into 테이블명 (컬럼명, ....)
values
(값, ....),
(값, ....),
...;
*/

insert into emp(empno, ename, sal) values (3, 'lsh', 10000);
-- select * from emp;
insert into goods(brand, price, maker, cno)
values('LG 모니터', 200000, 'LG전자', 20);
select * from goods;

savepoint s1;

update goods set price = 140000 where gno = 9;

rollback to s1;			-- s1 이후에 작업한 dml문은 취소됨. (현재지점부터 s1까지)
select * from goods;
select * from emp;
commit; 		     	-- 커밋 통해서 저장소에 반영
/*
delete 문 
- 전체 데이타 삭제 
  delete from 테이블명;
   edit=> preference => sql editor => safe update 체크 해제 
   
- 조건에 맞는 데이타만 삭제 
  delete from 테이블명  where 조건;
*/

delete from emp;
select * from emp;
rollback;

/*
-전체 데이타 수정 
update 테이블명 set 컬럼명=value;   
-조건에 맞는 데이타만 수정 
update 테이블명 set 컬럼명=value where 조건;   
*/
update emp set sal = 10000;
select * from emp;
rollback;
update goods set price = 5000 where gno=2;
commit;

/*
 테이블 copy
 - 구조만 copy
 create table 테이블명
 as
 select from 테이블명 wehre 1=0;
 
 - data + 구조 copy
 create table 테이블명
 as
 select from 테이블명
*/

create table empcopy
as
select * from emp;

select * from empcopy;

-- truncate는 dml문이 아니라서 commmit, rollback 대상이 아님
truncate empcopy; 		-- 데이터가 싹 날라감 
rollback;

/*sub query를 이용한 update
  insert, update 문에는  scala sub query 만 사용할 수 있다. 
  [mysql 형식]
  update 테이블명 set 컬럼명 ( select * from ( 스칼라 서브 쿼리) alias) 
  
  scala sub query - sub query의 결과가 단일행 단일열
 */









