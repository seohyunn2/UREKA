package graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class AdjMatrix_dfs1 {
	static boolean[][] map;
	static boolean[] visit;  //노드 개수만큼만 만들기
	static int N;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("graph/AdjMatrix.txt"));
		BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <=T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new boolean[N][N];
			visit=new boolean[N];
			for (int i = 0; i <N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					if(Integer.parseInt(st.nextToken()) ==1) {
						map[i][j] = true;
					}
				}
			}
			DFS(0);
			System.out.println();
		}
	}

	/*
	 * 재귀 함수를 이용한 DFS
	 * -stack을 이용하여 함수 콜에 대한 관리를 하기 때문에
	 *  재귀 함수를 이용하면 stack 객체를 생성할 필요가 없다.
	 */
	private static void DFS(int cur) {
//		인자로 전달된 cur 노드가 stack에서 꺼내온 효과이므로

//				방문처리하고

//		추출한 노드에 대한 처리

//		현재 노드의 인접된 노드에 대한 방문 시도

//			방문한 적이 없고 		인접 되어 있다면

//			스택에 추가하기
	}
}


















