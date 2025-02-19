package chapter03;

import java.util.Arrays;

public class ArrayTest3 {
	public static void main(String[] args) {
		/*
		 * System.arraycopy(src, srcPos, dest, destPos, length);
		 * src 		: 복사할 원본 
		 * srcPos 	: 복사를 시작할 위치
		 * dest		: copy본(부본)
		 * destPost : dest에서 데이타를 저장할 위치 
		 * length	: 복사할 개수
		 */
		
		int[] src= {0,1,2,3,4,5,6,7,8,9};
		int[] copy1= new int[15];  
		int[] copy2= new int[3];
		
		//전체 복사 
		System.arraycopy(src, 0, copy1, 0, src.length);
		System.out.println(Arrays.toString(copy1));
		
		//부분 복사
		System.arraycopy(src, 2, copy2, 0, copy2.length);
		System.out.println(Arrays.toString(copy2));
		
		/*
		 * Arrays.copyOf(original, newLength) : T[]
		 * original : 복사할 원본 대상
		 * newLength: copy본의 배열 크기
		 */
		
		int[] copy3 = Arrays.copyOf(src, 15);
		System.out.println(Arrays.toString(copy3));
		
		/*
		 * Arrays.copyOfRange(original, from, to):T[]
		 * original : 복사할 원본 대상
		 * from 	: 복사할 시작 위치 , 0번 부터 시작
		 * to		: 복사를 끝낼 위치 , 1번 부터 시작
		 */
		int[] copy4 = Arrays.copyOfRange(src, 2, 5);
		System.out.println(Arrays.toString(copy4));
	}
}




