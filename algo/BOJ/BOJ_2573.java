package BOJ;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2573 {

    // ice[][] -> 맞닿아있는 면의 개수 넣기 -> 바다: -1
    // map[][] -> dfs 한 번 돌 때 마다 ice[][]를 빼준 값으로 업데이트, year++
    //              => 0보다 작아지면 0으로 설정
    //              => ice[][]가 -1이 아닌 경우만 실행하도록

    // 구획탐색 dfs 돌 때마다 cnt로 구역 개수 세기 -> 구역 개수가 2보다 크거나 같아지면 종료하고 출력
    // 빙하 다 녹으면 (map[][] 값이 전부 다 0) -> 0 출력

    static int N, M, cnt, year;
    static int[][] map, sea;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        sea = new int[N][M];

        // map 입력값으로 초기화
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            year++;
//            System.out.println("year++");
            sea = new int[N][M];
            for(int  i = 0; i < N; i++) {
                for(int j = 0; j  < M; j++) {
                    if(map[i][j] > 0) {
                        updateSea(i, j);
                    }
                }
            }
            // 접한 개수 업데이트한 걸로 map 업데이트
            newMap();

            // 구역 개수 dfs 호출
            cnt = 0;
            visited = new boolean[N][M];
            for(int i =0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(!visited[i][j] && map[i][j] > 0){
                        dfs(i, j);
                        cnt++;
//                        System.out.printf("map[%d][%d]에서 cnt 업데이트 됨\n", i, j);
                    }
                }
            }

            // 끝나는 조건
            // cnt가 2이상일 때 -> cnt 출력
            if(cnt >= 2) {
                System.out.println(year);
                return;
            }
            boolean isZero = true;
            // 다 0일때 -> 0출력
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] != 0) {
                        isZero = false;
                        break;
                    }
                }
            }
            if(isZero) {
                System.out.println(0);
                return;
            }
        }
    }

    public static void newMap() {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(map[r][c] > 0) {
                    map[r][c] -= sea[r][c];
                    if(map[r][c] < 0) {
                        map[r][c] = 0;
                    }
                }
            }
        }
    }

    public static void updateSea(int r, int c) {
        //sea 업데이트
        int nr, nc;
        for(int i = 0; i < 4; i++) {
            nr = r + dr[i];
            nc = c + dc[i];

//            if(map[nr][nc] == 0) {
//                sea[r][c]++;
//            }
//            if(map[nr][nc] < 0) {
//                sea[r][c] = 0;
//            }
            if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                sea[r][c]++;
            }
        }
    }
    // 구역 개수 세기
    public static void dfs(int r, int c){
        //dfs 구현
        visited[r][c] = true;
        int nr, nc;
        for(int i = 0; i < 4; i++) {
            nr = r + dr[i];
            nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] == 0) continue;

            dfs(nr, nc);
        }
    }
}
