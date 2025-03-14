package BOJ;
import java.util.*;

public class BOJ_1541 {
    public static void main(String[] args) {

    }
}
// 입력을 일단 다 문자열 -> toCharArray로 받고 경우에 따라 나눔
/*
[5, 5, -, 5, 0, +, 4, 0]
* 가능한 경우

* 일단 입력이 숫자인지 부호인지에 따라 서로 다르게 처리해야..
* 1. 부호 +니 -가 입력될 때까지는 다 숫자
    => 부호가 나오는 인덱스를 찾아서 숫자 단위를 계산
    ex. 첫 부호 인덱스: 2 => 2자리수
        두 번째 부호 인덱스: 5 => 5 - (앞 부호 인덱스 + 1)


10+20+30+40
[2,5,8] -> 숫자 개수는 부호 배열 원소 개수 + 1
        -> 첫 번째 숫자 개수: 첫번째원소 / 나머지: 현재 인덱스 - 앞 인덱스 + 1\

이걸 읽어서 숫자들 계산
-> -나오면 괄호시작 -> 다음 부호가 -면 괄호끝괄호시작  +면 계속  입력 끝이면 괄호끝
*/