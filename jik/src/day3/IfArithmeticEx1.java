package day3;

import java.util.Scanner;

public class IfArithmeticEx1 {

	public static void main(String[] args) {
		/* 두 정수와 산술연산자(+,-,*,/,%) 중 하나를 입력하여 입력한 
		 * 연산자가 +이면 두 정수의 합을,
		 * 연산자가 -이면 두 정수의 차를,
		 * 연산자가 *이면 두 정수의 곱을,
		 * 연산자가 /이면 두 정수의 나눗셈을
		 * 연산자가 %이면 두 정수의 나머지를 출력하고,
		 * 산술연산자가 아니면 산술연산자가 아닙니다라고 출력하는 코드를 작성하세요.
		 * 예시1)
		 * 두 정수와 산술 연산자를 입력하세요(예: 1 + 2) : 1 + 2
		 * 1 + 2 = 3 
		 * 예시2)
		 * 두 정수와 산술 연산자를 입력하세요(예: 1 + 2) : 1 / 2
		 * 
		 * 1. 두 정수와 산술 연산자를 입력 : Scanner
		 * 2. 조건문
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("두 정수와 산술 연산자를 입력하세요(예: 1 + 2) : ");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		
		
		/* 입력한 연산자가 +이면 두 정수의 합을 출력
		 * 조건식 : 입력한 연산자가 +이다
		 *        operator가 +와 같다
		 * 실행문 : 두 정수의 합을 출력; 
		 */
		if(operator == '+') {
			System.out.println(num1 + " " + operator+ " " + num2 + " = " 
					+ (num1 + num2));
		}
		else if(operator == '-') {
			System.out.println(num1 + " " + operator+ " " + num2 + " = " 
					+ (num1 - num2));
		}
		else if(operator == '*') {
			System.out.println(num1 + " " + operator+ " " + num2 + " = " 
					+ (num1 * num2));
		}
		else if(operator == '/') {
			System.out.println(num1 + " " + operator+ " " + num2 + " = " 
					+ ((double)num1 / num2));
		}
		else if(operator == '%') {
			System.out.println(num1 + " " + operator+ " " + num2 + " = " 
					+ (num1 % num2));
		}
		else {
			System.out.println(operator + "는 산술 연산자가 아닙니다.");
		}
		scan.close();
	}
}
