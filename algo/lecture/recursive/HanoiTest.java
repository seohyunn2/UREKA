package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HanoiTest {
	static StringBuilder result = new StringBuilder(100);
	static void hanoi(int cnt, int from , int temp, int to) {
		//모든 판을 다 옮긴 경우 종료
		if(cnt == 0) {
			return ;
		}
		//현재 기둥에서 target(맨 아래 판)을  뺀 나머지(cnt-1)들을 임시 기둥(temp)에 옯겨 놓기 
		hanoi(cnt-1, from, to, temp );
		//target(맨 아래 판)을 목적 기둥(to)에 옮겨 놓기
		result.append(cnt+" :"+ from +" ->" +to+"\n");
		//임시 기둥에 옮겨진 나머지 판들(cnt - 1)을 목적 기둥(to) 옮겨 놓기
		hanoi(cnt-1, temp, from, to );
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		hanoi(count,1, 2, 3);
		System.out.println(result);
	}
}







