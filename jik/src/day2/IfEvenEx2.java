package day2;

public class IfEvenEx2 {

	public static void main(String[] args) {
		/* num가 짝수이면 짝수라고 출력하는 코드를 작성하세요.
		 * 조건식 : num가 짝수이다
		 *        num가 2의 배수이다
		 *        num를 2로 나누었을 때 나머지가 0이다
		 *        num를 2로 나누었을 때 나머지가 0과 같다
		 * 실행문 : 짝수라고 출력
		 * */
		int num = 11;
		if(num % 2 == 0) {
			System.out.println(num + "는 짝수");
		}else {
			System.out.println(num + "는 홀수");
		}
	}
}
