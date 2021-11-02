package day5;

import java.util.Scanner;

public class DoWhileBreakEx1 {

	public static void main(String[] args) {
		/* 0을 입력할 때까지 정수를 계속 입력받는 코드를 작성하세요. 
		 * */
		Scanner scan = new Scanner(System.in);
		int num = 0;
		//for문으로 작성한 경우 num의 초기값에 따라 실행이 안될 수 있다
		for( ;num != 0 ; ) {
			System.out.print("정수를 입력하세요 : ");
			num = scan.nextInt();
		}
		System.out.println("do while문");
		num = 0;
		do {
			System.out.print("정수를 입력하세요 : ");
			num = scan.nextInt();
		}while(num != 0);
		
		scan.close();
	}

}
