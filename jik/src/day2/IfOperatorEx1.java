package day2;

public class IfOperatorEx1 {

	public static void main(String[] args) {
		//조건 선택연산자를 이용한 A학점 확인
		int score = 95;
		char isA = ((score <= 100) && (score >= 90)) ? 'Y' : 'N';
		
		System.out.println(score+"점은 A학점인가요? " + isA);
		
		//num1이 홀수인가로 물어보면 홀수이면 yes를 짝수이면 no을 출력하는 코드를 작성하세요.
		int num1 = 11;
		String isOdd = num1 % 2 != 0 ? "yes" : "no" ;
		
		System.out.println(num1 + "은 홀수인가요? " + isOdd);
	}
}
