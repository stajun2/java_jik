package day1;

public class PrintEx1 {

	public static void main(String[] args) {
		//println 메소드 : 콘솔에 값을 출력하고 마지막에 엔터를 쳐줌.
		//()안에 값이 없어도 가능
		//print 메소드 : 콘솔에 값을 출력함.
		//()안에 값이 없으면 에러
		System.out.println("Hello!!");
		System.out.println("Hello!!");
		System.out.print("Hello??");
		System.out.print("Hello??");
		System.out.println();//엔터
		//System.out.print();//에러 발생
		
		/* System.out.println(변수명);
		 * System.out.println("변수명 : " + 변수명);
		 */
		int num1 = 10;
		System.out.println(num1);
		System.out.println("num1 = " + num1);
		
		int num2 = 20;
		char operator = '+';
		// 계획 : 10+20=30으로 출력
		// 결과 : 73=1020으로 출력
		// 정수 + 문자 => 정수
		// 10 + '+' => 10 + 43 => 53
		// 정수 + 문자열 => 문자열 + 문자열 => 문자열
		System.out.println(num1 + operator + num2 + "=" + num1 + num2);
		// 결과 : 10+20=1020
		System.out.println(""+num1 + operator + num2 + "=" + num1 + num2);
		// 결과 : 10+20=30
		System.out.println(""+num1 + operator + num2 + "=" + (num1 + num2));
	}
}
