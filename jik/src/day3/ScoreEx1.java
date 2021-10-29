package day3;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		/* 0~100점 사이의 정수 점수를 입력받아 입력받은 점수의 학점을 출력하는 코드를 작성하세요.
		 * 이상 : 크거나 같다. 이하 : 작거나 같다. 미만 : 작다
		 * 90이상~100이하 	: A
		 * score가 90보다 크거나같고 score가 100보다 작거나 같으면 A라고 출력
		 * 80이상~ 90미만 	: B
		 * 70이상~ 80미만 	: C
		 * 60이상~ 70미만 	: D
		 *  0이상~ 60미만 	: F
		 * 잘못된 점수    	: 잘못된 점수입니다.
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력하세요(0~100 사이의 정수) : ");
		int score = scan.nextInt();

		if(score >= 90  && score <= 100 ) {
			System.out.println(score + "점은 A학점");
		}
		else if(score >= 80  && score < 90 ) {
			System.out.println(score + "점은 B학점");
		} 
		else if(score >= 70  && score < 80 ) {
			System.out.println(score + "점은 C학점");
		}
		else if(score >= 60  && score < 70 ) {
			System.out.println(score + "점은 D학점");
		}
		else if(score >= 0  && score < 60 ) {
			System.out.println(score + "점은 F학점");
		}
		else {
			System.out.println(score + "점은 잘못된 점수입니다.");
		}
		
		scan.close();
	}

}
