package BOJ;

import java.util.*;

public class BOJ_2630 {
    static int[] res = {0, 0};
    public static void main(String[] args) {
        // 2차원 배열로 입력 저장
        // 종이의 모든 숫자가 같으면 white / blue 저장
        // 아니면 쪼개기
        int N;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] input = new int[N][N];

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input[i][j] = sc.nextInt();
            }
        }
        int end = N;

        four(0, 0, input, N);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
    // 시작 x, y, size -> 몇 개인지
    private static void four(int x, int y, int[][] input, int size) {
        // 같은 색깔인지 확인
        if(isSame(x, y, input, size)) {
            if(input[x][y] == 0) {
                res[0]++;
//                System.out.println("white++");
            }
            else {
                res[1]++;
//                System.out.println("blue++");
            }
            return;

        }
//        System.out.println("---------------");

        // 같지 않으면

        if(size==2) {
//        System.out.println("-************");
            res[input[x][y]]++;
            res[input[x+1][y]]++;
            res[input[x][y+1]]++;
            res[input[x+1][y+1]]++;
//        System.out.println("---------------");
            return;
        }
        size/=2;

//            return;

        four(x, y, input, size);
        four(x + size, y, input, size);
        four(x, y+size, input, size);
        four(x+size, y+size , input, size);


    }
    // -1 -> 다름 / 다 같을 때 반환값 0 -> white 1 -> blue
    private static boolean isSame(int x, int y, int[][] input, int size) {
        int color = input[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(color != input[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
