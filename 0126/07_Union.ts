/*
  Union
  변수의 값이 지정한 여러개의 타입 중 한 개의 타입의 값을 저장할 수 있다.

  변수명: 타입1|타입2|...
*/

let anyVal: number|string|boolean = 10; // 이 시점에서 anyVal은 Number 타입

anyVal = 'hello';                       // 이 시점에서 anyVald은 string 타입
anyVal = false;                         // 이 시점에서 anyVald은 boolean 타입
// anyVal = {name: 'hello'};

let lateVal: string|undefined|null = undefined;
lateVal = 'hello';

/*
  자주 사용하는 유니온 타입들을 별칭으로 지정해서 재사용하기
  type 타입명 = 타입|타입|...
*/

type nsb = number|string|boolean;

let anyV: nsb = 10;
anyV = 'hello';
anyV = true;

// 타입 별칭 추가
type nullNsb = nsb|null

let nullAbleValue: nullNsb = null;