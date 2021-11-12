package day13;

public class ExeTestEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
//ExeTest라는 인터페이스가 자바에서 배포해서 여러 개발자가 널리 활용하고 있다
interface ExeTest{
	public void func1();
	public void func2();
	public void func3();
	//인터페이스에서 새로운 기능을 추가할 때 추상 메소드로 하면
	//이전에 인터페이스를 이용하여 개발중이던 모든 클래스에 오버라이딩해야한다.
	public default void func4() {}
}

class ExeA implements ExeTest{
	
	public void func1() {}
	public void func2() {}
	public void func3() {}
}


