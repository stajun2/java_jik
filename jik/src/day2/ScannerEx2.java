package day2;

import java.util.Scanner;

public class ScannerEx2 {

	public static void main(String[] args) {
		/* 콘솔에서 두 정수를 입력받아 입력받은 정수들의 합과 나눈 결과를 구하는 코드를 작성하세요. */
		int num1, num2;
		System.out.print("두 정수를 입력하세요(예:1 2) : ");
		Scanner scan = new Scanner(System.in);
		
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		int res1 = num1 + num2;
		double res2 = num1 / (double)num2;
		
		System.out.println(num1 + " + " + num2 + " = " + res1);
		System.out.println(num1 + " / " + num2 + " = " + res2);
		
		scan.close();
	}
}
