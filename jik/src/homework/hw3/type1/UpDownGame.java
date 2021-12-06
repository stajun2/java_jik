package homework.hw3.type1;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		
		int min = 1, max = 100;
		Scanner scan = new Scanner(System.in);
		//1~100사이 랜덤 생성
		int com = (int)(Math.random() * (max - min + 1) + min);
		int user;
		do {
			System.out.print("정수 : ");
			user = scan.nextInt();
			if(user > com) {
				System.out.println("DOWN");
			}else if(user < com) {
				System.out.println("UP");
			}
		}while(user != com);
		System.out.println("정답입니다.!!");
		scan.close();
	}

}
