package chapter01;

import java.util.Iterator;

public class BitMaskTest {

	public static void main(String[] args) {
		/*
		 * Bit Mask
		 * - 기존의 bit를 &, |, ^, << , >> 를 이용해서 다른 값으로 변경(masking)하는 작업
		 * 
		 * int a = 0b1000;
		 * int b = 0b0010;
		 * 
		 * a &= b; 	//0000   1이었던 비트가 0으로 masking 됨. 
		 * a |= b;  //1010   0이었던 비트가 1로 masking 된다.
		 * 
		 * - 정수의 이진수 표현을 자료 구조로 쓰는 기법  => boolean 배열을 대체하는 효과 
		 *     - 보통 어떤 비트가 1이면 '켜져 있다,  true, 해당 위치에 원소가 있다.' 
		 *                    0이면  '꺼져 있다, false, 해당 위치에 원소가 없다.'
		 *                    
		 * - 장점
		 * 1. 수행 시간이 빠르다.
		 *   비트 마스크 연산은 bit 연산(&, | ^, ~)이므로 O(1)로 구현되는 것이 많다. 
		 *   ==> 다른 자료 구조(boolean 배열)를 이용하는 것보다 따르게 동작된다. 
		 *   ex) 10만개의 word에  a k g가 있는지 check
		 *       boolean 배열  
		 *       10만 * word의 크기                         => O(n*word 크기)
		 *       int result = 0; 	   
		 *       for(int i =0; i<10만; i++){
		 *          int count = 0;
		 *       	for(int j=0, size = word.length(); j<size; j++){
		 *       	   if(word.charAt(j) =='a'|| word.charAt(j) =='k'||word.charAt(j) =='g'){
		 *       		count++;
		 *       	   }
		 *          }
		 *          if(count ==3){
		 *           result++;
		 *          }
		 *       }
		 *       
		 *       bitmask 이용하면 10만으로 성능을 높이를 수 있다.  => O(n)
		 *       
		 *       int result=0; 
		 *       for(int i =0; i<10만; i++){
		 *          if(word&key == key){
		 *          	result++;
		 *          }
		 *       }
		 *  2. 코드가 짧다
		 *  	boolean 배열을 모두 순회해서 체크하는 코드가 bit연산 하나로 대체 될 수 있으므로 코드가 간결해 진다.
		 *  
		 *  3. 메모리 사용량이 적다. 
		 *  ex) 문이 잠긴 행, 열로 구성된 map에서 key(a, b, c, d, e, f)를 이용해서 
		 *      문열 열어야 도착점으로 탈출 할 수 있는 경우 방문 체크 배열
		 *      [행][열][a][b][c][d][e][f] 배열 선언			//8차원 필요
		 *      
		 *      bitmask 사용시 
		 *      [행][열][key]									//3차원 배열
		 *       
		 */
		
		/*1. 공집합과 꽉 찬 집합 구하기
		 *  A = 0;				//32개의 원소가 모두 0이므로 공집합
		 *  n = 10; 			//10개인 원소
		 *  A = (1<<n)-1;		//꽉 찬 집합
		 *  	  0000000001 << 10 ==>10000000000
		 *  
		 *       10000000000 -1 = 1111111111  
		 *   
		 */
		int n = 10; 
		int A = (1<<n) -1;
		System.out.println(Integer.toBinaryString(A));
		
		
		/* 2. 특정 위치에 1이 있는지 check로 & 사용 
		 * 
		 *  &    and  : 연산하려는 두 비트가 모두 1일때 1이고 나머지는 0
		 *              특정 위치에 1이 있는지 체크 용도로 사용,  data & 0 => 0으로 초기화   
		 * */
		int a1 = 0b1000;
		int b1 = 0b0010;
		int c1 = 0b1110;
		System.out.println(Integer.toBinaryString(a1&b1));
		System.out.println(Integer.toBinaryString(a1&c1));
		System.out.println(Integer.toBinaryString(b1&c1));
		
		/* 3.원소 추가 : k번째 위치에 원소를 추가(1로 마스킹)하기 
		 * A |= (1<<k)
		 * 
		 * k번째는 뒤에서 부터 세기 (0번째 부터~)
		 * */
		A = 0;			
		
		int k = 5;     //   5 4 3 2 1 0  <뒤에서 부터 0번째부터 세기
		A |= (1<<k);   //   1 0 0 0 0 0   
		System.out.println(Integer.toBinaryString(A));
		
		/*
		 * 4. 원소 삭제 
		 *    k번째의 위치에 있는 원소를 삭제(0)
		 *    A &= ~(1<<k)
		 */
		A&= ~(1<<k);
		System.out.println(Integer.toBinaryString(A));
		
		/*
		 * 5. 마지막 1의 위치 찾기 
		 * A&-A    : A의 인지수에서 1의 마지막 위치를 찾기  ==> 펜위 트리 구현시 사용  
		 */
		A = 0b1100111000;
		System.out.println(Integer.toBinaryString(A));
		System.out.println(Integer.toBinaryString(A&-A));
		int m = 0b11010;
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(m&-m));
		
		/*
		 * 6. 최소 원소 지우기 => 모든 부분 집합 순회에 응용
		 * A & (A-1)
		 */
		System.out.println("A:"+Integer.toBinaryString(A));
		System.out.println("A:"+Integer.toBinaryString(A &(A-1)));
		
		String[] str = {"a","b","c","d"};
		/*
		 * 7. 모든 부분 집합 순회하기 
		 */
		System.out.println("부분 집합 출력");
		int s = 0b1101;
		for (int subset = s; subset!=0;  subset= (subset-1)&s) {
			System.out.println(Integer.toBinaryString(subset));
		}
		
		
	}
}








