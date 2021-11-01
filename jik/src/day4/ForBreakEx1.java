package day4;

import java.util.Scanner;

public class ForBreakEx1 {

	public static void main(String[] args) {
		/* 0을 입력할 때까지 정수를 계속 입력받는 코드를 작성하세요. 
		 * for문과 break문을 이용.
		 * 예) 
		 * 정수를 입력하세요 : 1
		 * 정수를 입력하세요 : 1000
		 * 정수를 입력하세요 : -1
		 * 정수를 입력하세요 : -123
		 * 정수를 입력하세요 : 0
		 * 종료합니다.
		 * 힌트.
		 * Scanner는 반복문 시작전에 만들어야 함.
		 * 정수를 입력받는 코드를 반복문 안에 있어야 함.
		 * 입력받은 정수가 0과 같으면 반복문을 빠져 나옴.
		 * */
		Scanner scan = new Scanner(System.in);
		int num;
		for( ; ; ) {
			System.out.print("정수를 입력하세요 : ");
			num = scan.nextInt();
			if(num == 0) {
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
		scan.close();
	}

}
