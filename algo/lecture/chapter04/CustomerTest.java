package chapter04;

public class CustomerTest {
	public static void main(String[] args) {
		/*
		 * 객체 선언		클래스명 변수명;
		 * 객체 생성		변수명 =	new 클래스명([인자]); 
		 * 객체 접근		변수명.속성명			변수명.함수명
		 * 
		 * 선언 & 생성
		 * 클래스명 변수명 = new  클래스명([인자]);
		 */
//		Customer cust1 = new Customer();
//		cust1.name="UPlus";
//		cust1.age = 2;
//		cust1.address="서초구 선릉역";
		
		Customer cust1 = new Customer("UPlus", "서초구", 2);
		
		System.out.println(cust1);
		System.out.println(new Customer("kdg", "성북구",37 ));
		System.out.println(new Customer());
		
		Customer cust2 = new Customer("1", "1", 1);
		System.out.println(cust1.equals(cust2));
	}
}
