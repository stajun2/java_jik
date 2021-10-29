package day3;

public class ForEvenEx1 {

	public static void main(String[] args) {
		/* 1부터 10까지 짝수들만 출력하는 코드를 for문을 이용하여 작성하세요.
		 * 출력 예시)
		 * 2
		 * 4
		 * 6
		 * 8
		 * 10
		 * 방법1
		 * 반복횟수	: i는 1부터 10까지 1씩증가 
		 * 규칙성 	: i가 짝수이면 i를 출력
		 * */
		int i;
		System.out.println("---방법1---");
		for( i = 1 ; i <= 10 ; i++ ) {
			if( i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		/* 방법2
		 * 반복횟수 	: i는 2부터 10까지 2씩 증가
		 * 규칙성		: i를 출력
		 * */
		System.out.println("---방법2---");
		for( i = 2 ; i <= 10 ; i = i + 2) {
			System.out.print(i + " ");
		}
		System.out.println();
		/* 방법3
		 * 반복횟수	: i는 1부터 5까지 1씩 증가
		 * 규칙성 	: 2*i를 출력
		 * */
		System.out.println("---방법3---");
		for( i = 1 ; i <= 5 ; i++) {
			System.out.print(2*i + " ");
		}
	}

}
