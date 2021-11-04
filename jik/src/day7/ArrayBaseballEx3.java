package day7;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayBaseballEx3 {

	public static void main(String[] args) {
		/* 숫자 야구 게임에서 컴퓨터가 랜덤한 수를 생성하도록 코드를 작성하세요. */
		int [] com = new int[3];
		Scanner scan = new Scanner(System.in);
		
		//컴퓨터가 1~9사이의 중복되지 않은 세 수를 저장하는 코드를 작성
		int min = 1, max = 9;
		int count = 0;
		do {
			//랜덤한 수 생성
			int random = (int)(Math.random()*(max-min+1)+min);
			//배열에 중복된 값이 있는지 확인하는 반복문
			int i;
			/* count가 0, 반복문이 한번도 실행 안됨
			 * count가 1, 중복된 수가 있으면 반복문 종료 후 i는 0
			 * count가 2, 중복된 수가 있으면 반복문 종료 후 i는 0 or 1
			 * */
			for(i = 0; i < count ;i++) {
				//중복된 수가 있으면 반복문을 중단
				if(com[i] == random) {
					break;
				}
			}
			//반복문 종료 후 i값이 count와 같다는 건 중복된 수가 없어서 break문이 실행 안된
			//경우
			if(i == count) {
				com[i] = random;
				count++;
			}
		}while(count != 3);
		
		//사용자가 무한히 세 수를 입력 받음
		int user[] = new int[3];
		int strike = 0, ball = 0;
		
		do {
			System.out.print("사용자 : ");
			for(int i = 0; i<user.length; i++) {
				user[i] = scan.nextInt();
			}
			//스트라이크 갯수를 계산하여 스트라이크 갯수를 출력
			strike = 0;
			
			for(int i = 0; i<com.length; i++) {
				if(com[i] == user[i]) {
					strike++;
				}
			}
			//볼의 갯수를 계산하여 볼의 갯수를 출력
			ball = 0;
			for(int i =0; i<com.length; i++) {
				for(int j=0; j<user.length; j++) {
					//com[i], user[j]
					//스트라이크인 경우는 생략
					if(i == j) {
						continue;
					}
					if(com[i] == user[j]) {
						ball++;
					}
				}
			}
			//스트라이크가 있으면 xS
			//볼이 있으면 xB
			//스트라이크와 볼이 없으면 3O이 출력되도록 작성해보세요.
			if(strike != 0) {
				System.out.print(strike + "S");
			}
			if(ball != 0) {
				System.out.print(ball + "B");	
			}
			if(strike == 0 && ball == 0) {
				System.out.print("3O");
			}
			System.out.println();
			
		}while(strike != 3);
		
		System.out.println("정답입니다. 프로그램을 종료합니다.");
		
		scan.close();
	}

}
