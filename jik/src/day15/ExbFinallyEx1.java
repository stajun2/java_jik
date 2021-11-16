package day15;

public class ExbFinallyEx1 {

	public static void main(String[] args) {
		exceptionTest();
	}
	public static void exceptionTest() {
		int num1 = 1, num2 = 0;
		try {
			int res = num1 / num2;
			System.out.println(res);
		}catch(Exception e) {
			System.out.println("예외 처리");
			return;
		}finally {
			System.out.println("파이널리");
		}
		System.out.println("메소드 마지막");
	}
}
