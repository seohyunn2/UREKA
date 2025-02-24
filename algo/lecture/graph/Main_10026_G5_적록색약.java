package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * - map을 구역 나누기 문제 
 *   - 같은 구역인 경우 count세기 
 *   - 모든 노드를 1번씩만 탐색하기 때문에 dfs, bfs 모두 가능 
 *   - 전체 맵을 반복하면서 (행과 열에 대해 전체 탐색 -> 구역이 어디서 끊기는지 모르니까)
 *     방문하지 않은 노드라면 그 노드 부터 같은 구역인지 (dfs, bfs) 탐색하기 
 *     
 * - 적녹색약
 *   1. 비적녹색약인을 위한 버전으로 구역 탐색하고 
 *   2. 적녹색약인을 위해 visits 초기화 하고
 *      map의 정보를 G->R로 바꾸거나 R->G으로 바꾼후 구역 탐색하기 
 */
public class Main_10026_G5_적록색약 {
	static int N;
    static char[][] map;
    static boolean[][] visits;
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,1,-1,0};
    // 새로운 구역 찾았을 때 좌표 저장
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new char[N][N];
        visits = new boolean[N][N];

        for (int i=0; i<N; i++){
            // toCharArray(): 문자열을 문자 배열로 변환하는 함수
        	map[i] = in.readLine().toCharArray();
        }

        int dltoniosm = 0, nonDltonism = 0, cnt = 0;

        // 비적록색약인을 위한 구획 탐색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visits[i][j]) { // 방문하지 않은 노드는 새로운 구역
//                    dfs(i, j);
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        nonDltonism = cnt;
        cnt = 0;

        // 적록색약인을 위한 탐색
        // visits 초기화
        // 한 번이면 이렇게 새로 생성하는 것도 ㄱㅊ
        visits = new boolean[N][N];
//        for(int i = 0; i < N; i++) {
//            Arrays.fill(visits[i], false);
//        }
        // G -> R   R -> G 변경
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }
        // 구획 탐색
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visits[i][j]) { // 방문하지 않은 노드는 새로운 구역 -> dfs 돌기
//                    dfs(i, j);
                    bfs(i, j);
                    cnt++; // 구역 개수 카운트
                }
            }
        }
        dltoniosm = cnt;
        System.out.println(nonDltonism+" " +dltoniosm);
    }
 
    public static void dfs(int r, int c ){
        visits[r][c] = true;
        char color = map[r][c];

        for(int i =0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
//              방문하지 않았고      상하좌우가 같은 컬러일 때
            if(!visits[nr][nc] && map[nr][nc] == color) {
                dfs(nr, nc); // 걔네도 들어가봐야되니까 다시 dfs 호출
            }

        }
    }

    public static void bfs(int r, int c) {
        q.offer(new int[] {r, c});
        visits[r][c] = true;
        char color = map[r][c];
        int nr, nc;

        while(!q.isEmpty()) {
            // 현재 위치 꺼내서
            int[] cur = q.poll();
            // 상하 좌우 탐색
            for(int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];
                // 경계 안에 있고 방문 안했고 같은 색상인 경우에만 큐에 추가
                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visits[nr][nc]) continue;
                if(map[nr][nc] != color) continue;
                bfs(nr, nc);
            }

        }
    }
}
