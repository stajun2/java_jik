package day1;

public class VariableEx1 {
	/**
	 * */
	public static void main(String[] args) {
		// 한줄 주석
		/* 여러줄
		 * 주석
		 * */
		/* 성적을 관리하는 변수를 선언하려 한다. 성적은 A, B, C, D, F로 관리.
		 * 이 성적을 관리하기 위한 변수를 선언해보세요.
		 * */
		char score1;
		char score2 = 'F';
		//나이를 관리하는 변수를 선언해보세요.
		int age1;
		int age2 = 1;
		//성적의 평균을 관리하는 변수를 선언해보세요. 단, 성적은 0~100점까지입니다.
		double avg1;
		double avg2 = 0.0;
		float avg3 = 0.0f;
		
		//성인인지 아닌지를 판별하기 위한 변수를 선언해보세요.
		boolean isAdult1;
		boolean isAdult2 = true;//true : 참, false : 거짓
		
		int num1 = 1000;
		//byte num2 = 1000; //에러 발생 
		
		score1 = 'A';
		//System.out.println(isAdult1);//에러 발생 : 변수 초기화를 하지 않아서
		
		int num2 = 0x11;//16진수 11
		System.out.println("num2 = " + num2);
		int num3 = 011;//8진수 11
		System.out.println("num3 = " + num3);
		int num4 = 0b11;//2진수 11
		System.out.println("num4 = " + num4);
	}
}
