package BOJ;
import java.lang.reflect.Array;
import java.util.*;
public class BOJ_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int wait = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            wait += arr[i];
            sum += wait;
        }

        System.out.println(sum);
    }
}
