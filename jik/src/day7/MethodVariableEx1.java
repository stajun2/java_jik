package day7;

public class MethodVariableEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 10, num2 = 20;
		System.out.println("main메소드 > num1 : " 
				+ num1 + ", num2 : " + num2);
		int result = sum(num1, num2);
		System.out.println("main메소드 > num1 : " 
				+ num1 + ", num2 : " + num2);
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
	public static int sum(int num1, int num2) {
		System.out.println("sum 메소드 > num1 : " 
				+ num1 + ", num2 : " + num2);
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
		System.out.println("sum 메소드 > num1 : " 
				+ num1 + ", num2 : " + num2);
		return num1 + num2;
	}
}
