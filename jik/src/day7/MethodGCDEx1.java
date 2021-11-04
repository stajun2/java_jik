package day7;

public class MethodGCDEx1 {

	public static void main(String[] args) {
		/* 최대 공약수를 구하는 메소드를 정의하고, 호출하여 최대 공약수를 출력하는 
		 * 코드를 작성하세요.
		 * 최소 공배수를 구하는 메소드를 정의하고, 호출하여 최소 공배수를 출력하는 
		 * 코드를 작성하세요.
		 * */
		int num1 = 12, num2 = 8;
		int result = gcd(num1, num2);
		System.out.println(num1 + "과 "+ num2 +"의 최대 공약수 : " + result);
		result = lcm1(num1,num2);
		System.out.println(num1 + "과 "+ num2 +"의 최소 공배수 : " + result);
		result = lcm2(num1,num2);
		System.out.println(num1 + "과 "+ num2 +"의 최소 공배수 : " + result);
	}
	/* 기능 : 두 정수가 주어졌을 때 두 정수의 최대공약수를 계산하여 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 두 정수의 최대 공약수 => 정수 => int
	 * 메소드명 : gcd 
	 * */
	public static int gcd(int num1, int num2) {
		int i , gcd = 0;
		for( i = 1 ; i <= num1 ; i++ ) {
			if(num1 % i == 0 && num2 % i == 0 ) {
				gcd = i;
			}
		}
		return gcd;
	}
	/* 기능 : 두 정수가 주어졌을 때 두 정수의 최소공배수를 계산하여 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 두 정수의 최소 공배수 => 정수 => int
	 * 메소드명 : lcm1
	 * */
	public static int lcm1(int num1, int num2) {
		for(int i = num1; i<=num1 * num2; i += num1) {
			if(i % num2 == 0) {
				return i;
			}
		}
		return num1*num2;
	}
	public static int lcm2(int num1, int num2) {
		return num1 * num2 / gcd(num1, num2);
	}
}




