package day5;

public class StarEx1 {

	public static void main(String[] args) {
		/* 반복문을 이용하여 다음과 같이 출력되는 코드를 작성하세요.
		 * *****	i=1 *=5
		 * *****	i=2 *=5
		 * *****	i=3 *=5
		 * *****	i=4 *=5
		 * *****	i=5 *=5
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : *을 5번씩 출력 후 엔터를 출력
		 *        반복횟수 : j는 1부터 5까지 1씩 증가 
		 *        규칙성 : *을 출력
		 *        반복문 종료 후 : 엔터를 출력
		 * */
		int i , j;
		for(i=1; i<=3; i++) {
			for(j=1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();//엔터
		}
		/*
		for(1.i=1; 2.22.i<=3; 21.i++) {
			for(3.23.j=1; 4.7.10.13.16.19.24.j<=5; 6.9.12.15.18.26.j++) {
				5.8.11.14.17.25.System.out.print("*");
			}
			20.System.out.println();//엔터
		}
		*/
	}

}
