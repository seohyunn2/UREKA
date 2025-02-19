package BOJ;

import java.util.*;

public class BOJ_1062_bitMask {
	static int n, k;
	static char[][] words;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		sc.nextLine();
		
		words = new char[n][];
		for(int i = 0; i < n; i++) {
			words[i] = sc.nextLine().toCharArray();
		}
		
		int mask = (1<<'a'-'a') | (1<<'n'-'a') | (1<<'t'-'a') | (1<<'i'-'a') | (1<<'c'-'a');
		
			
	}
		
}

//boolean 배열로 처리하던 걸 비트마스크로 -> int mask
//word에 포함된 문자를 1로하는 int 
// 위 두 개 &해서 1이면 읽을 수 있음 

