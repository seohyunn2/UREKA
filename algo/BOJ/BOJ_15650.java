package BOJ;

import java.util.*;

public class BOJ_15650 {
	static int n, r;
	static int[] input;
	static int[] numbers;
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		n = scanner.nextInt();
		r = scanner.nextInt();
		
		input = new int[n];
		numbers =  new int[r];
		
		for (int i = 0; i < n; i++) {
			input[i]= i+1;
		}
		
		combi(0,0);
	}
	public static void combi(int depth, int start) {
		if(depth == r) {
			for(int i = 0; i < r; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < n; i++) {
			numbers[depth] = input[i];
			combi(depth+1, i + 1);
		}
	}
}