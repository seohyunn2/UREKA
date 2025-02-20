package BOJ;

import java.util.*;

public class BOJ_2839 {
    static int[] sugar = {5, 3};
    static int n, cnt;
//    static int[] result = new int[sugar.length];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

//        아래 코드처럼 짜면 3의 배수같은 경우를 해결할 수 없음! (ex. 9 -> -1 출력됨)
//        for(int i = 0; i < sugar.length; i++) {
//            result[i] = n / sugar[i];
//            n%=sugar[i];
//
//        }
//        if(n == 0) {
//            int sum = 0;
//            for(int i = 0; i < result.length; i++) {
//                sum += result[i];
//            }
//            System.out.println(sum);
//        } else {
//            System.out.println(-1);
//        }
        while (n >= 0) {
            if (n % 5 == 0) {
                cnt += (n / 5);
                System.out.println(cnt);
                return;
            }
            n -= 3;
            cnt++; // 3 하나 썼으니까
        }
        System.out.println(-1);
    }

}
