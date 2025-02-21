package BOJ;

import java.util.*;
import java.io.*;

public class BOJ_13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        // 입력 내용 집어넣는 우선순위 큐
        PriorityQueue<int[]> homework = new PriorityQueue<>((a, b) -> {
           int result = a[0] - b[0];
           if(result == 0){
               // 데드라인이 같으면 -> 점수에 대해 내림차순
               return b[1] - a[1];
           } else {
               return result;
           }
        });
        //입력 받아서 큐에 집어넣기

        int score, deadLine;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            deadLine = Integer.parseInt(st.nextToken());
            score = Integer.parseInt(st.nextToken());

            homework.offer(new int[]{deadLine, score});
        }

        // 하나씩 우선순위 큐 select(선택할 과제들의 점수만 담음)에 집어넣기
        PriorityQueue<Integer> select = new PriorityQueue<>();

        while(!homework.isEmpty()) {
            int[] hw = homework.poll(); // 과재 하나의 데드라인과 점수를 담은 배열
            int d = hw[0];
            int s = hw[1];

            if(d > select.size()) {
                select.offer(s);
            } else {
                if(select.peek() < s) {
                    select.poll();
                    select.offer(s);
                }
            }

        }
        int sum = 0;
        while(!select.isEmpty()) {
            sum += select.poll();
        }
        System.out.println(sum);
    }

}
