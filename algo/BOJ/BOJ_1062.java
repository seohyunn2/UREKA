package BOJ;

import java.util.*;

public class BOJ_1062 {
	static int n, k;
	static boolean[] alphabet = new boolean[256]; // 아스키코드 생각해서 이렇게 할 예정? 
	// 그냥 바로 알파벳으로 체크할 수 있게...? 
	static List<String> words = new ArrayList<>();
	static List<Character> possible = new ArrayList<>(); // 조합 선택 가능한 알파벳 담은 배열 
	static int maxAns = Integer.MIN_VALUE;
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		k = scanner.nextInt();
		scanner.nextLine();
		for(int i = 0; i < n; i++) {
			words.add(i, scanner.nextLine());
		}
		
		if(k < 5) {
			System.out.print("0");
			return;
		}
		alphabet['a' - 'a'] = true;
		alphabet['n' - 'a'] = true;
		alphabet['t' - 'a'] = true;
		alphabet['i' - 'a'] = true;
		alphabet['c' - 'a'] = true;
		
		// antic 제외하고 조합 선택 가능한 알파벳
		// 근데 이렇게 하면 시간 오래걸림 (ArrayList는 Heap -> 여기 계속 왔다갔다 오래걸림) 
		// => 그냥 alphabet에서 false인 거 중 조합 고르는 게 더 빠름  
		for(char c = 'a'; c <= 'z'; c++) {
			if(c!='a' && c!='n' && c!='t' && c!='i' && c!='c') {
				possible.add(c);
			}
		}
		// 함수 호출해서 조합 고르고 단어 읽기 
		combi(0,0,possible, alphabet);
		System.out.println(maxAns);
	}
	
	// possible 중에 k-5개 골라야함 
	public static void combi(int depth, int start, List<Character> possible, boolean[] alphabet) {
		if(depth == k-5) {
			readWords(alphabet);
			return;
		}
		
		for(int i = start; i < possible.size(); i++) {
			char ch = possible.get(i);
			alphabet[ch - 'a'] = true; 
	        combi(depth+1, i+1, possible, alphabet);
	        alphabet[ch - 'a'] = false;
		}
		
//		for(int i = start; i < possible.size(); i++) {
//			char ch = possible.get(i);
//			boolean[] alphabetCopy = alphabet.clone();
//			alphabetCopy[ch - 'a'] = true; 
//	        combi(depth+1, i+1, possible, alphabetCopy);
//	        // 어차피 반복 돌 때마다 배열 복사하니까 굳이 true로 바꾼 걸 다시 false로 바꿀 필요는 없
//		}
	}
	
	public static void readWords(boolean[] alphabet) {
		// charAt으로 각 문자의 alphabet[] 원소값 찾아보고
		// false 나오면 count = 0
		// 다 true면 count++
		// words n개 다 읽으면 wordCount 개수 늘리고 maxAns에 저장 
		
		int wordCount = 0;
		for(int i = 0; i < words.size(); i++) {
			int count = 0;
			String word = words.get(i);
			for(int j = 0, size = word.length(); j < size; j++) {
				if(alphabet[word.charAt(j) - 'a'] == true) {
					count++;
				}
			}
			if(count == word.length()) {
				wordCount++;
			}
		} 
		maxAns = Math.max(maxAns, wordCount);
	}
	
	
}


// anta tica -> a n t i c 5개
// k<5 ->답은 무조건 0
// else -> bool array에다가체크
// 각 조합별로 읽을 수 있는 단어 개수 저장해두고 가장 많은 거 출력하면 됨 