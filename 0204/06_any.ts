/*
  타입스크립트의 추론
  변수 선언시 타입을 지정하지 않아도 값을 대입하면 값을 통해 타입스크립트는 해당 타입을 추론한다.
*/

// let anyValue = 10; // number 타입으로 추론
// anyValue = 'hello'; // number 타입으로 추론된 변수이므로 다른 타입을 대입할 수 없다.

// 변수의 타입을 변경해야 하는 경우 ==> any 타입을 사용하거나 union
let anyValue: any = 10;
console.log(typeof anyValue);

anyValue = 'hello';
console.log(typeof anyValue);