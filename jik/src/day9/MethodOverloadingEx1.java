package day9;

public class MethodOverloadingEx1 {

	public static void main(String[] args) {
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
		System.out.println(sum(1.2,2.5));
		System.out.println(sum(1,2.5));
		System.out.println(1);
		System.out.println('1');
		System.out.println("1");
	}
	//1
	public static int sum(int num1, int num2) {
		System.out.println("메소드1");
		return num1 + num2;
	}
	//매개변수의 갯수가 다른 경우,2
	public static int sum(int num1, int num2, int num3) {
		System.out.println("메소드2");
		return num1 + num2 + num3;
	}
	//매개변수의 타입(자료형)이 다른 경우,3
	public static double sum(double num1, double num2) {
		System.out.println("메소드3");
		return num1 + num2;
	}
	//안되는 경우 : 리턴타입만 다른경우
	/*public static double sum(int num1, int num2) {
		return num1 + num2;
	}*/
}





