package day10;

public class ClassShapeEx2 {
	//타원을 나타내는 클래스를 생성하고, 타원 클래스의 객체를 만들고, 테스트하세요.
	//사각형 클래스를 참고
	//Ellipse 클래스
	public static void main(String[] args) {
		Ellipse e1 = new Ellipse(0,0, 10, 10);
		e1.print();
		e1.move(10, 10);
		e1.print();
		e1.resize(5, 5);
		e1.print();
	}
}
