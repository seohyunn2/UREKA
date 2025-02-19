package chapter01;

/*
 * 형변환(Cast)
 * - 데이타 타입을 변환 
 * - 논리(boolean) 타입은 어떤 타입으로도 형변환이 안된다. 
 *   어떤 타입도 논리 타입으로 형변환이 안된다. 
 * - 자동 형변환 
 *   JVM에서 자동으로 형변환이 된다. 
 *   byte=> short => int => long => float => double
 *          char
 *          
 * - 명시적 형변환
 *   자동으로 형변환 안되므로 명식적으로 형환을 한다.
 *   형식 ]  (변환타입)값;  
 */
public class CastTest {
	public static void main(String[] args) {
		byte b1 = 127;
		short s1 = b1;
		int  i1 = s1;
		long l1 = i1;
		float f1 = l1;
		float f2 = 2222222222l;
		double d1 = 2222222222l;
		System.out.println("f2:"+f2);
		System.out.println("d1:"+d1);
		
		char c1 ='a';
		int  i2 = c1;
		System.out.println("i2:"+i2);
		
		float f3 =(float)d1;
		long  l3 =(long)f3;
		System.out.println("l3:"+l3);
		int   i3 = (int)l3;
		//음수로 나오는 이유는 8byte의 앞에 4byte는 제거 된 후 
		//남은 4byte의 첫 bit가 1인 경우 음수로 표현된다. 
		System.out.println("i3:"+i3);
		short s3 = (short)i3;
		System.out.println("s3:"+s3);
		System.out.println(Integer.toBinaryString(s3));
		byte b3 = (byte)s3;
		System.out.println("b3:"+b3);
		char c3 =(char)s3;
		System.out.println("c3:"+c3);
		s3 =(short)c3;
	}	
}









