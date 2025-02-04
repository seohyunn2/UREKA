const scissor = document.querySelector("#scissor");
const rock = document.querySelector("#rock");
const paper = document.querySelector("#paper");
const resultDiv = document.querySelector("#result");
const comDiv = document.querySelector("#computer");

// 사용자가 버튼을 누르면 게임 스타트
if(scissor && rock && paper) {
  scissor.addEventListener("click", () => play(1));
  rock.addEventListener("click", () => play(2));  
  paper.addEventListener("click", () => play(3));
}

// 게임 하는 함수 (인자로 가위1 바위2 보3 중 하나 주기)
function play(select: number): void{
  let computer: number = parseInt(Math.random() * 3 + '') + 1;
  let computerSel: string = "";
  let message: string = "";

  if(computer==1) {
    if(select==1) {
      message = "비겼다";
    }
    else if(select==2) {
      message = "이겼다";
    }
    else {
      message = "졌다";
    }
  }

  if(computer==2) {
    if(select==1) {
      message = "졌다";
    }
    else if(select==2) {
      message = "비겼다";
    }
    else {
      message = "이겼다";
    }
  }

  if(computer==3) {
    if(select==1) {
      message = "이겼다";
    }
    else if(select==2) {
      message = "졌다";
    }
    else {
      message = "비겼다";
    }
  }

  if(computer == 1) {
    comDiv == null? '' : comDiv.innerHTML = `컴퓨터<div><img src = "images/scissors.png"></div>`;
  } else if (computer == 2) {
    comDiv == null? '' : comDiv.innerHTML = `컴퓨터<div><img src = "images/rock.png"></div>`;
  } else {
    comDiv == null? '' : comDiv.innerHTML = `컴퓨터<div><img src = "images/paper.png"></div>`;
  }
  
  resultDiv == null? '' : resultDiv.innerHTML = message;

  
}