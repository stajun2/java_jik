package day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExdTryCatchEx2 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자를 입력받아 입력받은 산술 연산자에 맞는 결과를
		 * 출력하는 코드를 작성하세요. 단, 예외처리를 이용 */
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		char op;
		double res = 0.0;
		
		System.out.print("두 정수와 산술 연산자를 입력하세요 (예 : 1 + 2) : ");
		try {
			num1 = scan.nextInt();
			op = scan.next().charAt(0);
			num2 = scan.nextInt();
			
			switch(op) {
			case '+':	res = num1 + num2; 			break;
			case '-':	res = num1 - num2; 			break;
			case '*':	res = num1 * num2; 			break;
			case '/':	res = num1 / (double)num2; 	break;
			case '%':	res = num1 % num2; 			break;
			}
			System.out.println(""+ num1 + op + num2 + "=" + res);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없다");
		}catch(InputMismatchException e) {
			System.out.println("입력을 잘못했다 ");
		}catch(Exception e) {
			System.out.println("예외 발생");
		}
		scan.close();
	}

}
