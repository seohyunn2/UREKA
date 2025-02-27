/* floor()버림   ceiling( ) 올림   round(숫자, 자리수) 반올림 */



/* dual 테이블 
   - Dumy 테이블 (1행 1열) -> 제공됨
   - 함수의 수행 결과를 조회할 경우에는 select 문을 통해서만 조회 
     ==> 그래서 함수 결과만 조회할 경우 dual 테이블을 이용해서 조회 
*/
select floor(3.1) , ceil(3.1), round(3.1), round(3.5)
from   dual; 


/* 
  문자열 연결
  mysql : concat('문자열','문자열','문자열',... )
  기타   : 문자열 || 문자열|| 문자열 ...
*/
select concat(brand, ' 상품은 ', maker, ' 제조사에서 생산한 제품입니다.')
from goods;

/*
	문자열 추출 
	left( column or 문자열, 추출할 개수)      : 왼쪽부터 지정한 개수까지의 문자열을 추출 
    right( column or 문자열, 추출할 개수)     : 오른쪽부터 지정한 개수까지의 문자열을 추출 
    substring(column or 문자, 시작위치, 개수) or substr(column or 문자, 시작위치, 개수)
    : 왼쪽의 시작 위치 부터 지정한 개수만큼 추출 
      시작 위치는 1부터 
*/
select brand, right(brand, 2), left(brand, 2)
	 , substring(brand, 1, 3)
     , substr(brand, 1, 3)
from goods;

-- repeat(column or 문자, 숫자) : 지정한 문자열을 지정할 수만큼 반복
select repeat('hello ',5) from dual;

-- length()  : 문자열 길이    
-- reverse() : 문자열을 거꾸로 표시 
-- upper()   : 문자열을 대문자로 변환 
-- lower()   : 문자열을 소문자로 변환

select email, length(email), reverse(email), upper(email), lower(email)
from members;

/*
  공백 삭제
   rtrim(column or 문자) : 오른쪽의 공백 삭제 
   ltrim(column or 문자) : 왼쪽의 공백 삭제
   trim(column or 문자)  : 좌우의 공백 삭제
*/
select rtrim('    hello     '), ltrim('    hello     '), trim('    hello     ')
from dual;

/*3. 논리 관련 함수 
    case  when ~ then     : ANSI(표준) Query 

    if(논리식, 참일때, 거짓일 때)
    - 논리식이 참이면 참일 때 값을 출력하고 논리식이 거짓이면 거짓일 때 출력한다.
*/
/* 
   상품번호, 상품명, 인상전 가격, 인상후 가격을 조회 하시오.	
   가격 인상은 다음과 같다. 
   가격이 10000원 미만이면 15%을 가격을 인상하고 10000원 이상은 10% 가격을 인상하시오
   인상된 가격을 기준으로 오름 차순으로 정렬하시오
*/
 select gno, brand, price
	  ,case
         when  price <10000  then price *1.15
         when  price >=10000 then price *1.1
	   end  as INC_price
from goods
order by INC_price asc;
       
select gno, brand, price,
	if(price < 10000, price*1.15, 
			-- 거짓일 경우
			if(price>30000, price*1.05, price*1.1)) as IncPrice
from goods;

/* 분류 번호가 10인 경우  음식
   10인 경우 음식
   20인 겨우 전자제품
   30인 경우 책
   40인 경우 가구  */
   
select gno, brand, cno,
	if(cno = '10', '음식', 
		if(cno = '20', '전자제품', 
			if(cno = '30', '책', 
				if(cno = '40', '가구', '미분류')))) as '카테고리 이름'
from goods;
   
/*
  oracle인 경우 
  decode( 논리식, 참일때,거짓일때)
  decode( 논리식, 참일때
         ,논리식, 참일때
         ,논리식, 참일때
         ..
         ,거짓일때)
*/

/* 
  상품번호, 상품명, 분류번호 조회  단, 분류번호가 null인경우 미분류로 표시
*/
select gno, brand
       , if(cno is null, '미분류', cno) as cno
from   goods;       

/*ifnull(문자 or column, 대체 정보) : null인 경우 대체 정보로 조회됨.
  oracle인 경우, nvl(), nvl2() 함수가 있음.
*/

select gno, brand, 
	ifnull(cno, '미분류') as cno
from goods;

/*4. 날짜 관련 함수 */
select  curdate(), curtime(), now(), sysdate(), current_timestamp() from dual;

-- 날짜 계산 
-- DATE_ADD(날짜, INTERVAL 기준값) ADDDATE(날짜, INTERVAL 기준값)  날짜에서 기준값 만큼 더한다.
-- DATE_SUB(날짜, INTERVAL 기준값) SUBDATE(날짜, INTERVAL 기준값)  날짜에서 기준값 만큼 뺸다.
-- 기준값 : YEAR, MONTH, DAY, HOUR, MINUTE, SECOND

-- 어제
select DATE_SUB(now(), interval 1 day) from dual;

-- 한 달 전
select DATE_SUB(now(), interval 1 month) from dual;

-- 내일
select DATE_ADD(now(), interval 1 day) from dual;

/*
DAYOFWEEK(날짜) 날짜의 주별 일자 출력(일요일(1),월요일(2)…토요일(7))
*/
select dayofweek(now()) from dual;
select curdate() as today, 
	case dayofweek(now())
		when 1 then '일요일'
        when 2 then '월요일'
        when 3 then '화요일'
        when 4 then '수요일'
        when 5 then '목요일'
        when 6 then '금요일'
        when 7 then '토요일'
	end as '요일'
from dual;


           
/*
날짜의 요일을 숫자로 반환하는 WEEKDAY(월요일(0) ~ 일요일(6) 반환) 
*/
SELECT WEEKDAY(SYSDATE())
FROM DUAL;

/*
1월1일부터 해당날짜까지의 날수를 반환하는 DAYOFYEAR
*/
SELECT DAYOFYEAR(SYSDATE()) FROM DUAL;
          
/* 오늘 부터 8월 12일까지 남은 날수 계산 */
select dayofyear('20250812') - dayofyear(now())
from dual;          

/*날짜의  년, 월, 일, 시, 분, 초를 반환
  YEAR, MONTH, DAYOFMONTH, HOUR, MINUTE, SECOND
*/
select year(sysdate()), month(sysdate())
      ,dayofmonth(sysdate())
      ,hour(sysdate()), minute(sysdate()), second(sysdate())
from dual;

-- 지난 달에 판매된 상품을 조회하세요. -> 달 + 연도까지 비교해줘야
select * from orders 
where month(odate) = month(date_sub(now(), interval 1 month))
		and year(odate) = year(now());
-- where odate >= '20250101' and odate <= '20250131';
      
/* 해당 월, 요일의 이름을 반환하는 MONTHNAME / DAYNAME */
SELECT MONTHNAME(SYSDATE()), DAYNAME(SYSDATE())
FROM DUAL;

/* 해당날짜의 분기를 반환해주는 QUARTER (1~4반환)  */
SELECT QUARTER(SYSDATE())  FROM DUAL;       
          
/*
date_format(column,  format)
%y   : 년 두자리 
%Y   : 년 네자리
%m   : 월 두자리 
%d   : 일 두자리
%H   : 24시간을 베이스로한 시간
%h   : 12시간을 베이스로한 시간
%i   : 분
%s   : 초 
*/

select date_format(sysdate(), '%y년 %m월 %d일 -  %p %h시 %i분 %s초') as today
from dual;
   





