package recursive;

public class RecursiveCallTest3 {
	static int fac = 10;
	
	public static void main(String[] args) {
		
		int result = 1;
		for (int i = 1; i <=fac; i++) {
			result *= i;
		}
		System.out.println(result);
		
		System.out.println(fac1(1));
		
		result = 1;
		for (int i = fac; i>=1; i--) {
			result *= i;
		}
		
		System.out.println(fac2(fac));
		
	}
	
	public static int fac2(int n) {
		if(n == 1) return 1;
		return n*fac2(n-1);
	}

	public static int fac1(int n) {
		if(n==fac) return n;
		return n * fac1(n+1); 
	}

}







