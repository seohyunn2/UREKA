var _a;
(_a = document.querySelector("#btn")) === null || _a === void 0 ? void 0 : _a.addEventListener("click", game);
function game() {
    // lotto 번호를 위한 배열
    var lotto = [];
    while (lotto.length < 6) {
        var num = parseInt(Math.random() * 45 + 1 + ''); // 1부터 45 사이의 난수 발생시키기
        // 같은 수 배제하기
        if (lotto.indexOf(num) == -1)
            lotto.push(num);
    }
    // 오름차순
    lotto.sort(function (a, b) { return a - b; });
    var view = "";
    var i = 0;
    var interValid = setInterval(function () {
        if (lotto.length == i) {
            clearInterval(interValid);
            return;
        }
        view += "<div class = \"ball ball".concat(parseInt(lotto[i] / 10 + ''), "\">").concat(lotto[i++], "</div>");
        var viewDiv = document.querySelector("#view");
        viewDiv == null ? '' : viewDiv.innerHTML = view;
    }, 1000); // 1초마다
}
