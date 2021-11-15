package homework.hw1.type2;

import java.util.Scanner;

public class DrawProgramMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//그림판 프로그램 객체 생성
		DrawProgram dp = new DrawProgram(10,scan);
		//그림판 실행
		dp.run();
		scan.close();
	}
}
