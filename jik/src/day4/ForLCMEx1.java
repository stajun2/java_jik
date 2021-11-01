package day4;

public class ForLCMEx1 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 for문을 이용하여 작성하세요.
		 * a의 배수 : 어떤 정수를 a로 나누었을 때 나머지가 0인 수들
		 * 4의 배수 : 4, 8, 12, 16, 20, ...
		 * 6의 배수 : 6, 12, 18, 24, ...
		 * 공배수   : 두 정수의 배수 중 공통으로 있는 배수들
		 * 4와 6의 공배수 : 12, 24, 36, 48, ...
		 * 최소 공배수 : 두 정수의 공배수 중 가장 작은 수
		 * 4와 6의 최소 공배수 : 12 
		 * num는 2의 배수 => num % 2 == 0 (o)
		 *                 num * 2      (x)
		 * 방법1   : 무조건 1부터 시작하기 때문에 num1과 num2가 크면 반복횟수가 많아진다.
		 *          10000과 20000인 경우 10000을 기준으로 10000씩 증가하면 2번이면 되지만
		 *          방법1은 무조건 1씩 증가하기 때문에 20000번을 해야 한다.
		 * 반복횟수 	: i는 1부터 시작해서 num1 * num2까지 1씩 증가
		 * 규칙성  	: i가 num1의 배수이고 i가 num2의 배수이면 i를 출력하고 반복문을 종료 
		 * 조건식  	: i가 num1의 배수이고 i가 num2의 배수이다.
		 *        =>i % num1 == 0이고 i % num2 == 0
		 *        =>i % num1 == 0 && i % num2 == 0
		 * 실행문 	: i를 출력하고, 반복문 종료
		 * */
		int num1 = 8, num2 = 12;
		int i;
		for( i = 1 ; i <= num1 * num2 ; i++ ) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(num1 +"과 " + num2+ "의 최소 공배수 : " + i);
				break;
			}
		}
		/* 방법2 : num1부터 시작해서 num1 * num2까지 num1씩 증가
		 * 반복횟수	: i는 num1부터 시작해서 num1 * num2까지 num1씩 증가
		 * 규칙성  	: i가 num2의 배수이면 i를 출력하고 반복문을 종료
		 * */
		for(i = num1; i <= num1 * num2; i += num1) {
			if(i % num2 == 0) {
				System.out.println(num1 +"과 " + num2+ "의 최소 공배수 : " + i);
				break;
			}
		}
	}

}
