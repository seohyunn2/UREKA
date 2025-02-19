package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class bfs {
    static boolean[][] map;
    static boolean[] visited;  //노드 개수만큼만 만들기
    static int N;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("algo/self/graph/AdjMatrix.txt"));
        BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
//		입력 받기
        for (int tc = 1; tc <=T; tc++) {
//			그래프를 담을 인접 배열 생성하기

//			그래프를 방문 처리 하기 위한 배열 생성하기

//			그래프 정보 입력 받기

        }
    }

    /**
     * 너비 우선 탐색
     */
    private static void BFS(int cur) {
//		너비를 우선으로 탐색하기 위한 큐 선언

//		첫 노드 방문 처리

//		큐에 첫 노느 추가하기

//		큐에 더이상 노드가 없을때까지 탐색하기
//			탐색할 노드를 큐에서 추출하기

//			노드에 대한 처리하기
//
//			현재 탐색하는 노드의 인접 모든 노드들을 방문시도
//				   인접됐고				방문한적이 없다면
//				    방문 처리 하고 큐에 추가하기

    }
}


















