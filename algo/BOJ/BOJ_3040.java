package BOJ;


import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3040 {
	// 7개 선택(조합) -> 합 100되는지 확인
	static int[] numbers = new int[9];	// 입력받은 9개의 숫자들 저장해둠 
	static int[] select = new int[7]; // 선택한 7개의 숫자 저
	static boolean isFound = false;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		// 정수 9개 입력받기 
		for(int i = 0; i < 9; i++) {
			numbers[i] = scan.nextInt();
		}
		scan.close();
		// 시작 
		combi(0, 0);
	}
	
	public static void combi(int depth, int start) {
		if(isFound)
			return;
		
		if(depth==7) {
			int sum = 0;
			for(int num:select) {
				sum += num;
			}
			if(sum == 100) {
				
				for(int i = 0; i < 7; i++) {
					System.out.println(select[i]);
				}
				isFound = true;
			}
			return;
		}
			
		for(int i = start; i < 9; i++) {
			select[depth] = numbers[i];
			combi(depth+1, i+1);
		}
	}
	
}