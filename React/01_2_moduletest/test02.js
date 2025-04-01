/*
export default로 내보낸 모듈을 import 방식
형식]
import 객체명 from 'url'


import {속성명, 함수명} from 'url'  
==> 안되다. export default로 객체 이름을 지정하지 않고 모듈을 내보냈기 때문에 
    import할 때 객체 이름을 지정해야 한다. 
*/

import cal from "./test02_module.js";

let { title, add, sub } = cal; // 로컬변수로 구조분해 할당은 가능
console.log(title);
console.log(add(10, 20));
console.log(sub(20, 10));

//단 객체로 import 했기 때문에  내부에서 필요한 속성이나 함수를 구조분해 할당 할 수 있다.
