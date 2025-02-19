package recursive;
/**
 * 재귀함수 
 *   - 함수 내에서 해당 함수를 또 호출
 *   - 반복의 depth가 랜덤일 때 사용(인자 or 배열로 depth를 컨트롤한다)
 *   - 
 *     기저조건  : 재귀 함수를 중단하는 조건 
 *     유도파트  : 재귀 함수를 진행하는 파트 
 *     
 *     
 */
public class RecursiveCallTest2 {

	static int N = 10;
	
	//Bottom -> UP
	public static int sum1(int n) {
		if(n == N) return n;
		return n + sum1(n+1);
	}
	//top -> down
	public static int sum2(int n) {
		if(n == 1) return 1; 
		return n+sum2(n-1);
	}
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <=N; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		System.out.println(sum1(1));
		System.out.println(sum2(N));
		sum = 0;
		for (int i = N; i >0; i--) {
			sum += i;
		}
		System.out.println(sum);
		
		
	}
}















