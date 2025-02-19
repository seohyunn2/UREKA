package chapter01;

/*
 * Primitive Type
 * - 자바에서 제공하는 기본 데이타 타입 
 * - 변수를 위해서 할당한 공간에 실제 값이 저장된다.
 *            1byte  2byte   4byte 8byte 
 *   정수형	: byte=> short=> int=> long
 *   				 (2byte)
 *   문자   	:        char =>
 *   실수형 	: 						    =>float(4byte)=> double(8byte)
 *   논리		: boolean
 *   
 * ReferenceType(참조 타입, 사용자 정의 데이타 타입, 객체) 
 * - class, interface, enum, 배열 
 * - 변수를 위해 할당된 공간에 객체를 참조할 할 수 있는 참조값(hashcode)가 저장된다.
 * 
 *  변수 선언
 *  데이타타입 변수명;
 */
public class DataTypeTest {
	public static void main(String[] args) {
		int num = 100;
		String str="hello";
		System.out.println(str.charAt(2));
		System.out.println("hello".charAt(2));
		
		/* 정수의 기본 타입은 int 이다.
		 *  123 <- int 
		 *  
		 *  byte, short의 변수를 연산시 int로 형변환을 시킨다. 
		 */
		byte b1 = 1;
		byte b2 = 2;
		//byte b3 = b1+b2;
		int i1 = b1+b2;				//int로 사용하거나
		byte b3 = (byte)(b1+b2);	//byte로 형변환해서 사용한다. 
		long l1 = 2222222222l;		//int 범위를 벗어난 정수를 사용할 때는 l, L로 long임을 표시해야 한다. 
		
		// 정수 / 정수  = 정수    => 몫을 구함
		// 실수 / 정수,  정수/실수 ==> 실수 
		System.out.println(5/2);
		System.out.println(5.0/2);
		System.out.println(5/2.0);
		int num1 = 5;
		int num2 = 2;
		System.out.println((double)num1/num2);
		System.out.println(num1/(double)num2);
		
		
		float f1 = 3.14f;
		double d2= 3.14;
		
		//  0 ~ 1 사이의 무한의 실수가 있기때문에 double은 8byte로 float는 4byte로 근사치를 표현한다. 
		float  f2= 65536.123456789f;
		double d3= 65536.123456789;
		double d4= 0.1234567890123456789;
		
		System.out.println("f2:"+f2);
		System.out.println("d3:"+d3);
		System.out.println("d4:"+d4);
		
		//문자   ''
		char c1 = 'a';
		char c2 = 'b';
		
		/*
		 * 숫자, 영문자, 특수기호는 ASCII 코드이므로
		 *  
		 */
		System.out.println(c1);
		System.out.println(c2-c1);  //문자지만 내부적으로 숫자(0,1 이진수)로 되어 있으므로 연산이 가능하다. 
		System.out.println((int)'A');
		System.out.println((int)'a');
		
		//a 일때 1칸 점프 b일때 2칸 점프 c일때 3칸 점프
		char state = 'C';
		int jump = state-'A'+1;
		
		System.out.println("jump:"+jump);
		
	}
}













