document.querySelector("#btn")?.addEventListener("click", game)

function game(): void {
  // lotto 번호를 위한 배열
  let lotto: number[] = [];

  while(lotto.length < 6) {
    let num: number = parseInt(Math.random() * 45 + 1+''); // 1부터 45 사이의 난수 발생시키기
    
    // 같은 수 배제하기
    if(lotto.indexOf(num) == -1) 
      lotto.push(num);
  }

  // 오름차순
  lotto.sort(function(a, b){return a - b});

  let view: string = "";
  
  let i: number = 0;

  let interValid = setInterval(function(){
    if(lotto.length == i) {
      clearInterval(interValid);
      return;
    }
    // 아예 div를 추가하는 거
     view += `<div class = 'ball ball${parseInt(lotto[i] / 10 + '')}'>${lotto[i++]}</div>`;

    let viewDiv = document.querySelector("#view");
    viewDiv == null ? '' : viewDiv.innerHTML = view;
  }, 1000); // 1초마다 실행
}
