package subset;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author 
 * 시간 복잡도 2^n
 *
 */
public class SubsetTest3 {
	static int N, totalCnt;
	static int[] input;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		input = new int[N];
//		numbers = new int[N];
//		for (int i = 0; i < N; i++) {
//			input[i] = sc.nextInt();
//		}
		N = 20;
		input = new int[N];
		numbers = new int[N];
		
		// O(2^n) -> 각 원소에 대해 선택 / 비선택 총 2가지 경우의 수 
		for (int i = 0; i < N; i++) {
			input[i] = i + 1;
		}
		long start = System.currentTimeMillis();
		subset(0,0);
		long end = System.currentTimeMillis();
		System.out.printf("총 경우의 수 : %d\n시간	: %dms", totalCnt, end-start);
		
	}
	
	// 재귀 (원소 하나 하나에 대해 선택할지 안할지를 depth로 처리) 
	/*
	 * depth		:  
	 * len		: 집합에서 선택한 원소의 개수 (부분집합의 원소 수)
	 * */
	private static void subset(int depth, int len) {
		// 모든 원소에 대해서 선택 / 비선택을 통해 subset을 만들기 때문에
		// depth가 N이 됐을 때 1개의 subset이 완성이 됨 
		if(depth == N) {
			// subset이 완성됐으므로 필요한 코드 작성
			totalCnt++;
			// copyOfRange(배열,start, len): 시작 위치부터 len 개수를 배열 복사
//			System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, 0, len)));
			return;
		}
		// 끝나지 않았다면 아래 두 가지
		// 원소 선택
		numbers[len] = input[depth]; 
		subset(depth+1, len+1);
		
		// 원소 비선택 
		subset(depth+1, len);
	}
}
