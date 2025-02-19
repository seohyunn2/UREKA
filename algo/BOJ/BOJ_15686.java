package BOJ;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_15686 {
	static int N, M;
	static List<int[]> house = new ArrayList<>();
	static List<int[]> chicken = new ArrayList<>();
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
        M = scanner.nextInt();
        
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 1) 
                		house.add(new int[]{i, j});  
                if (map[i][j] == 2) 
                		chicken.add(new int[]{i, j}); 
            }
        }
        
        // M이 chicken.size()와 같으면 바로 치킨거리 함수호출
//        if(M==chicken.size()) {
//        	chickenDistance(chicken);
//        }
        int [][] select = new int[M][2]; // 조합 선택된 치 좌표저장 
        combi(0,0,select);
        System.out.println(ans);
	}
	
	public static void combi(int depth, int start, int[][] select) {
    	if(depth == M) {
    		chickenDistance(select);
    		return;
    	}
    	
    	for(int i = start; i < chicken.size(); i++) {
			select[depth][0] = chicken.get(i)[0]; 
			select[depth][1] = chicken.get(i)[1]; 
			combi(depth+1, i+1, select);
		}
	
    }
    
    public static void chickenDistance(int[][] select) {
    	int distance = 0;
    	for(int i = 0; i < house.size(); i++) {
    		int[] ithHouse = house.get(i);  
    		int minDistance = Integer.MAX_VALUE;
    		
    		for(int j = 0; j <M; j++) {
    			minDistance = Math.min(minDistance, Math.abs(ithHouse[0]-select[j][0])+Math.abs(ithHouse[1]-select[j][1]));
    		}
    		distance += minDistance; 
    	} ans = Math.min(distance, ans);
    	
    }
}