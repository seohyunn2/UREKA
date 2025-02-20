package divideconquer;

import java.util.Scanner;
/**
 * 특정 범위를 나타내는 두 수를 입력 받고 
 * 해당 범위의 랜덤 수 하나를 맞추는 게임을 만들려고 한다. 
 * 
 */
public class NumberInCap {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1이상의 두 수를 입력하세요");
		int start = scan.nextInt();
		int end = scan.nextInt();
		if(start<1 || end<1 || end-start<1) {
			System.out.println("잘못 입력했습니다. 다시 입력하세요");
			return;
		}
		int game = (int)(Math.random()*(end+1-start))+start;
		System.out.println("game number is "+game);
		int cnt=0, mid;

		while(true) {
			mid = (start + end) >> 1; // 2로 나누기
			cnt++;

			// 얘는 범위 안에서 찾기 때문에 무조건 game==mid
			// 근데 원래는 항상 찾는 건 X => start, end 서로 역전될 때 예외처리 해줘야
			if(game==mid) {
				System.out.printf("맞췄습니다. count: %d%n", cnt);
				return;
			} else if(game>mid) {
				System.out.printf("%d UP %n", mid);
				start = mid + 1;
			} else {
				System.out.printf("%d DOWN %n",mid);
				end = mid - 1;
			}
		}
	}
}









