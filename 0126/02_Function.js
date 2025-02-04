/*
함수의 인자, 리턴에 대한 타입을 지정해야 한다.

형식] function 함수명(인자: 타입, ...) : 리턴타입 {

}

void : 리턴 값이 없는 경우

인자명? : 선택적 인자 ==> 값이 안들어와도 됨
*/
function printMsg(message, isCritical) {
    console.log(message);
    if (isCritical) {
        alert(message);
    }
}
printMsg('hello', false);
printMsg("경고", true);
