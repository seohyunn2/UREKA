package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 컵라면 수 최대 2^31 -> 합은 long type

public class BOJ_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        // 데드라인, 컵라면 수를 담은 PQ 선언
        // 데드라인 오름차순, 데드라인이 같으면 컵라면 수로 내림차순
        // [0]: 데드라인 [1]: 컵라면 수

        PriorityQueue<int[]> homework = new PriorityQueue<>((a, b) -> {
            int result = a[0] - b[0]; // 데드라인 비교
            if (result == 0) {
                return b[1] - a[1];
            } else
                return result;
        });

        // 데이터 입력받기
        // 1 6 입력받으면 앞은 deadLine 뒤는 cup에 저장
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int deadLine = Integer.parseInt(st.nextToken());
            int cup = Integer.parseInt(st.nextToken());

            homework.offer(new int[]{deadLine, cup});
        }

        // 선택하고 담기
        // 선택하는 숙제의 컵라면 수 저장하는 PQ
        // 데드라인이 큐에 들어있는 원소 개수보다 크거나 같으면 -> 컵라면 비교해서 (peek)
        // 큐에 있는 컵라면 더 작으면 poll하고 탐색하고 있는 컵라면 offer
        PriorityQueue<Integer> select = new PriorityQueue<>();

        while(!homework.isEmpty()) {
            int[] hw = homework.poll();
            int d = hw[0];
            int c = hw[1];
            if(select.size() < d) {
                select.offer(c);
            } else {
                if(c > select.peek()) {
                    select.poll();
                    select.offer(c);
                }
            }
        }
        Long sum = 0L;
        while(!select.isEmpty()) {
            sum += select.peek();
            select.poll();
        }
        System.out.println(sum);
    }
}
