package day3;

import java.util.Scanner;

public class ScoreEx2 {

	public static void main(String[] args) {
		/* 0~100점 사이의 정수 점수를 입력받아 입력받은 점수의 학점을 출력하는 코드를 작성하세요.
		 * 이상 : 크거나 같다. 이하 : 작거나 같다. 미만 : 작다
		 * 90이상~100이하 	: A => score / 10 => 9, 10
		 * score가 90보다 크거나같고 score가 100보다 작거나 같으면 A라고 출력
		 * 80이상~ 90미만 	: B => score / 10 => 8
		 * 70이상~ 80미만 	: C => score / 10 => 7
		 * 60이상~ 70미만 	: D => score / 10 => 6
		 *  0이상~ 60미만 	: F => score / 10 => 5,4,3,2,1,0
		 * 잘못된 점수    	: 잘못된 점수입니다.
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("점수를 입력하세요(0~100 사이의 정수) : ");
		int score = scan.nextInt();
		// 0 ~ 100 => 0 ~ 10
		switch(score / 10) {
		case 10:
			switch(score) {
			case 100:	System.out.println(score + "점은 A학점");	break;
			default:	System.out.println(score + "점은 잘못된 점수");
			}
			break;
		case 9:		System.out.println(score + "점은 A학점");		break;
		case 8:		System.out.println(score + "점은 B학점");		break;
		case 7:		System.out.println(score + "점은 C학점");		break;
		case 6:		System.out.println(score + "점은 D학점");		break;
		case 5, 4, 3, 2, 1:	System.out.println(score + "점은 F학점");	break;
		case 0:
			switch(score) {
			case 0,1,2,3,4,5,6,7,8,9: System.out.println(score + "점은 F학점");	break;
			default: System.out.println(score + "점은 잘못된 점수");
			}
			break;
		default:	System.out.println(score + "점은 잘못된 점수");	break;
		}
		
		scan.close();
	}

}
