package day11;

public class ClassInitEx1 {

	public static void main(String[] args) {
		Test11 t = new Test11();
		System.out.println(t.num);
		System.out.println(Test11.cnt);
	}
}
class Test11{
	/* 객체 멤버변수 num의 초기화 순서
	 * 1. num는 int의 기본값인 0으로 초기화
	 * 2. num는 10으로 초기화(명시적 초기화)
	 * 3. num는 20으로 초기화(초기화 블록에 초기화)
	 * 4. num는 30으로 초기화(생성자 초기화)
	 * */
	public int num = 10;
	{
		num = 20;
	}
	public Test11() {
		num = 30;
	}
	/* 클래스 멤버변수 cnt의 초기화 순서
	 * 1. cnt는 0으로 초기화(자료형의 기본값으로 초기화)
	 * 2. cnt는 11로 초기화(명시적 초기화)
	 * 3. cnt는 21로 초기화(초기화 블록)
	 * */
	public static int cnt = 11;
	static {
		cnt = 21;
	}
}




