package subset;

import java.util.Arrays;

public class SubsetTest2 {
	static String[] input= "abcd".split("");;
	static int N= input.length;
	static int[] subset;
	
	public static void main(String[] args) {
//		N=21;
//		input = new String[N];
		subset =  new int[N];
//		for (int i = 0; i < N; i++) {
//			input[i] = (char)('a'+i)+"";
//		}
		long stime = System.currentTimeMillis();
		
		/*
		 * subset의 개수는 2의 n승 개이므로 
		 * 0 : 원소를 선택 안함    1:원소를 선택함      
		 * 
		 * 0      0000:  원소 하나도 선택안한 서브셋
		 * 1      0001:  맨 끝의 원소 하나를 선택한 서브셋
		 * 2      0010:  맨 끝에서 두번째 원소 하나를 선택한 서브셋   
		 * 3      0011:  맨 끝의 두개의 원소를 선택한 서브셋 
		 * ...
		 * size-1 1111 : 모든 원소를 선택한 서브셋    
		 * 
		 * 결국 0 ~ 2^n-1까지 수의 bit를   1은 선택 0은 비선택으로  하면   수 자체가 부분 집합이 된다. 
		 * 수에서 bit값이 1인지를 확인해서 부분집합으로 표현하자
		 * 
		 * 시간 복잡도  2^n*n
		 *
		 */
		
		// O(n * 2^n)
		for(int i = 0, size = 1<<N; i < size; i++) {
//			i라는 숫자 자체가 subset이므로 i를 이진수로 표현해서 
//			bit 하나가 0이면 해당 원소를 선택 X, 1이면 선택 O
			
//			bit 하나가 원소에 대한 선택 여부를 의미하므로 모든 bit를 다확인할 필요 없이
//			원소 개수만 확인하면 된다.         
			for(int j = 0; j < N; j++) {
//				if((i & 1<<j) != 0) { // 선택했다는 거 
//					subset[j] = 1; // => 1로 바꿔줌  
//				}
				subset[j] = (i>>j) & 1; // 이걸 하면 subset을 다시 0으로 초기화해주지 않아도 
			}
			// 부분 집합이 완성됐으므로 부분집합 이후의 필요한 코드 작성 
			print();
			
			// 다음 부분 집합을 구하기 위해서 subset을 0으로 초기화한다.
//			Arrays.fill(subset, 0);   
		}
		long etime = System.currentTimeMillis();
		System.out.printf("%dms\n", etime-stime);
	}
	public static void print() {
		System.out.print("[");
		for (int i = 0; i <N; i++) {
//			System.out.print(subset[i]+" ");
			if(subset[i]==1)
				System.out.print(input[i]+" ");
		}
		System.out.println("]");
	}
}




