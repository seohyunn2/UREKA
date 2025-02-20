var scissor = document.querySelector("#scissor");
var rock = document.querySelector("#rock");
var paper = document.querySelector("#paper");
var resultDiv = document.querySelector("#result");
var comDiv = document.querySelector("#computer");
// 사용자가 버튼을 누르면 게임 스타트
if (scissor && rock && paper) {
    scissor.addEventListener("click", function () { return play(1); });
    rock.addEventListener("click", function () { return play(2); });
    paper.addEventListener("click", function () { return play(3); });
}
// 게임 하는 함수 (인자로 가위1 바위2 보3 중 하나 주기)
function play(select) {
    var computer = parseInt(Math.random() * 3 + '') + 1;
    var computerSel = "";
    var message = "";
    if (computer == 1) {
        if (select == 1) {
            message = "비겼다";
        }
        else if (select == 2) {
            message = "이겼다";
        }
        else {
            message = "졌다";
        }
    }
    if (computer == 2) {
        if (select == 1) {
            message = "졌다";
        }
        else if (select == 2) {
            message = "비겼다";
        }
        else {
            message = "이겼다";
        }
    }
    if (computer == 3) {
        if (select == 1) {
            message = "이겼다";
        }
        else if (select == 2) {
            message = "졌다";
        }
        else {
            message = "비겼다";
        }
    }
    if (computer == 1) {
        comDiv == null ? '' : comDiv.innerHTML = "\uCEF4\uD4E8\uD130<div><img src = \"images/scissors.png\"></div>";
    }
    else if (computer == 2) {
        comDiv == null ? '' : comDiv.innerHTML = "\uCEF4\uD4E8\uD130<div><img src = \"images/rock.png\"></div>";
    }
    else {
        comDiv == null ? '' : comDiv.innerHTML = "\uCEF4\uD4E8\uD130<div><img src = \"images/paper.png\"></div>";
    }
    resultDiv == null ? '' : resultDiv.innerHTML = message;
}
