package day3;

import java.util.Scanner;

public class IfMonthEx1 {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 마지막 일을 출력하는 코드를 작성하세요.
		 * 단, 2월은 28일로, 1월 : 31
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * month에 정수를 입력 받고,
		 * month가 1월이면 31일이라고 출력하고,
		 * month가 2월이면 28일이라고 출력하고,
		 * month가 3월이면 31일이라고 출력하고,
		 * month가 4월이면 30일이라고 출력하고,
		 * month가 5월이면 31일이라고 출력하고,
		 * month가 6월이면 30일이라고 출력하고,
		 * month가 7월이면 31일이라고 출력하고,
		 * month가 8월이면 31일이라고 출력하고,
		 * month가 9월이면 30일이라고 출력하고,
		 * month가 10월이면 31일이라고 출력하고,
		 * month가 11월이면 30일이라고 출력하고,
		 * month가 12월이면 31일이라고 출력하고,
		 * month가 1~12월 아니면 잘못입력했다고 출력
		 * 
		 * month에 정수를 입력 받고,
		 * month가 1월이거나, month가 3월이거나, month가 5월이거나
		 * month가 7월이거나, month가 8월이거나, month가 10월이거나
		 * month가 12월이면 31일이라고 출력하고,
		 * month가 4월이거나, month가 6월이거나, month가 9월이거나
		 * month가 11월이면 30일이라고 출력하고,
		 * month가 2월이면 28일이라고 출력하고,
		 * month가 1~12월 아니면 잘못입력했다고 출력
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("월을 입력하세요(1~12) : ");
		int month = scan.nextInt();
		
		if( month == 1 || month == 3  || month == 5 || month == 7 ||
				month == 8 || month == 10 || month == 12) {
			System.out.println(month + "월은 31일까지 있습니다.");
		}
		else if(month == 2) {
			System.out.println(month + "월은 28일까지 있습니다.");
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println(month + "월은 30일까지 있습니다.");
		}
		else {
			System.out.println("입력을 잘못했습니다.");
		}
		
		
		scan.close();
	}

}
