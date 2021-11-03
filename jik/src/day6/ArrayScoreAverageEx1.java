package day6;

import java.util.Scanner;

public class ArrayScoreAverageEx1 {

	public static void main(String[] args) {
		/* 배열을 이용하여 5명의 학생의 국어 성적을 입력받아 평균을 구하는 코드를 작성하세요.
		 * 단 성적을 배열에 저장해야 하고, 성적은 정수입니다.
		 * */
		//5개짜리 정수형 배열을 생성
		int [] score = new int[5];
		//배열에 성적을 입력
		Scanner scan = new Scanner(System.in);

		System.out.print("학생1의 국어성적 : ");
		score[0] = scan.nextInt();
		System.out.print("학생2의 국어성적 : ");
		score[1] = scan.nextInt();
		System.out.print("학생3의 국어성적 : ");
		score[2] = scan.nextInt();
		System.out.print("학생4의 국어성적 : ");
		score[3] = scan.nextInt();
		System.out.print("학생5의 국어성적 : ");
		score[4] = scan.nextInt();
		//배열의 합을 구함
		int sum = 0;
		sum += score[0];
		sum += score[1];
		sum += score[2];
		sum += score[3];
		sum += score[4];
		//합을 이용하여 평균을 구한 후 출력
		double average = sum / 5.0;
		System.out.println("5명 학생의 평균 : " + average);
		//방법2. 반복문 활용
		int score2 [] = new int[5];
		int i;
		
		for(i=0; i<5; i++) {
			System.out.print("학생"+(i+1)+"의 국어성적 : ");
			score2[i] = scan.nextInt();
		}
		
		for(i=0, sum=0; i<5; i++) {
			sum += score2[i];
		}
		average = sum / 5.0;
		System.out.println("5명 학생의 평균 : " + average);
		
		scan.close();
	}

}
