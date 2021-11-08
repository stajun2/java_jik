package day9;

public class MethodArithmeticEx1 {

	public static void main(String[] args) {
		/* 두 정수와 산술 연산자가 주어졌을 때 연산 결과를 출력하는 코드를 작성하세요.
		 * 단, 메소드를 이용하고, 연산자는 무조건 산술 연산자만 입력한다고 가정. 
		 * +,-,*,/,% */
		int num1 = 1, num2 = 2;
		char op = '/';
		System.out.println(""+num1+op+num2+"="+arithmetic(num1, op, num2));
		System.out.println(""+num1+op+num2+"="+arithmetic2(num1,op, num2));
	}
	/* 기능 : 두 정수와 산술 연산자가 주어졌을 때 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수와 산술 연산자 => int num1, char op, int num2
	 * 리턴타입 : 산술 연산 결과 => 실수  => double
	 * 메소드명 : arithmetic
	 * */
	public static double arithmetic(int num1, char op, int num2) {
		switch(op) {
		case '+': return num1 + num2;
		case '-': return num1 - num2;
		case '*': return num1 * num2;
		case '/': return num1 / (double)num2;
		case '%': return num1 % num2;
		default:  return 0;
		}
	}
	public static double arithmetic2(int num1, char op, int num2) {
		double res = 0.0;
		switch(op) {
		case '+': res = num1 + num2; 	break;
		case '-': res = num1 - num2;	break;
		case '*': res = num1 * num2;	break;
		case '/': res = num1 / (double)num2;	break;
		case '%': res = num1 % num2;	break;
		}
		return res;
	}
	
	
}
