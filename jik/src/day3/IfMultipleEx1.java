package day3;

import java.util.Scanner;

public class IfMultipleEx1 {

	public static void main(String[] args) {
		/* 정수를 입력 받고,
		 * 입력받은 정수가 2의 배수이면 2의 배수입니다라고 출력하고,
		 * 아니면 2의 배수가 아닙니다라고 출력하는 코드를 작성하세요.
		 * A의 배수 : 정수를 A로 나누었을 때 나머지가 0인 수
		 * 1. 정수를 입력 받음
		 * 2. 정수가 2의 배수인지 조건문으로 판별
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		if(num % 2 == 0) {
			System.out.println(num + "는 2의 배수입니다.");
		}else {
			System.out.println(num + "는 2의 배수가 아닙니다.");
		}
		
		scan.close();
	}
}
