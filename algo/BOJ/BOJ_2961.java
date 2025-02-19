package BOJ;


import java.util.*;

public class BOJ_2961 {
	static int N;
	static int multiply; // 신맛 
	static int sum; // 쓴 맛 
	static int min = Integer.MAX_VALUE;
	
	static List<int[]> ingredient = new ArrayList<>(); // 재료의 [신맛, 쓴맛] 리스트 

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		
		for(int i = 0; i < N; i++) {
			multiply = scanner.nextInt();
			sum = scanner.nextInt();
			ingredient.add(new int[]{multiply, sum});
		}
		
		subset(0,1,0,0);
		System.out.println(min);
		
	}
	
	public static void subset(int depth, int sour, int bitter, int cnt) {
		if(cnt > 0) {
			min = Math.min(min, Math.abs(sour - bitter));
		}
		if(depth == N) {
			return;
		}
		// 현재 재료 선택
		subset(depth+1, sour*ingredient.get(depth)[0], bitter+ingredient.get(depth)[1], cnt+1);
		
		// 현재 재료 선택 X
		subset(depth+1, sour, bitter, cnt);
	}




}