/*

  let             타입선언부
  const 변수명: {속성명: 타입} = {속성명: 값}
  var
*/

let myInfo :{
  name: string,
  height: number,
  isConditionGood: boolean,
  gender?: string // 선택적 속성, 해당 속성이 없을 경우 값은 undefined
} = {
  name:"lsh",
  height: 160,
  isConditionGood: true
}
console.log('myInfo: ', myInfo);
console.log('myInfo.gender: ', myInfo.gender);
/*
  interface
    인터페이스는 타입을 정의한 규칙을 의미한다.
    
    형식] interface 인터페이스 이름 {
      속성명: 타입,
      ...
    }
    사용] let, const, var 변수명: 인터페이스 이름 = {}     => 이 변수는 이 인터페이스야
*/

interface User {
  age: number,
  name: string
}

var p1: User = {age:2, name: 'uplus'};
let p2: User = {age:25, name: 'uuplus'};

function getUser(user: User) {
  console.log(user);
}

getUser(p1);
// getUser(p2);

/*
  인터페이스 확장
  기존의 인터페이스의 속성을 재사용해서 원하는 속성을 추가해서 새로운 인터페이스를 생성
  
  interface 이름 extends 확장받을 인터페이스 이름{}
*/

interface Vip extends User {
  hobby: string
}

var cust: Vip = {
  age: 30,
  name: 'aa',
  hobby: 'coding'
}

console.log(cust);