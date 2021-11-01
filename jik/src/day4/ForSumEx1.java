package day4;

public class ForSumEx1 {

	public static void main(String[] args) {
		/* 1부터 10까지 합을 구하는 코드를 for문을 이용하여 작성하세요.
		 * 1. 1부터 5까지 출력하는 예제
		 * 			sum = 0
		 * i=1	sum = sum + 1 
		 * i=2	sum = sum + 2
		 * i=3	sum = sum + 3
		 * ..		
		 * i=9	sum = sum + 9
		 * i=10	sum = sum + 10
		 * 			sum = sum + i
		 * 반복횟수	: i는 1부터 10까지 1씩 증가
		 * 규칙성  	: sum = sum + i
		 * 반복문 종료 후 : sum을 출력
		 * */
		int sum = 0;
		//for문에서만 사용할 수 있는 변수 i를 선언. for문 밖에서 i를 사용하려면 
		//다시 선언해야해야 하고, for문에 사용했던 값을 이어 사용할 수 없다.
		for(int i = 1 ; i <= 10 ; i++ ) {
			sum = sum + i;//sum += i;
		}
		System.out.println("1부터 10까지 합 : " + sum);
	}
}
