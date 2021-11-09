package day10;

public class ClassShapeEx1 {

	public static void main(String[] args) {
		/* 도형 직사각형을 나타내는 클래스를 생성하고, 객체를 만들어 테스트하세요. */
		Rect1 r1 = new Rect1(0, 0, 10, 20);
		r1.print();
		r1.move(10, 10);
		r1.print();
		r1.resize(30, 40);
		r1.print();
		Rect2 r2 = new Rect2(0, 0, 10, 20);
		r2.print();
		r2.move(10, 10);
		r2.print();
		r2.resize(30, 40);
		r2.print();
	}
}








