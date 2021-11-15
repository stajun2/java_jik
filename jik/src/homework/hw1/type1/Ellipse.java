package homework.hw1.type1;

public class Ellipse extends Shape {

	/* 도형 클래스를 상속받아 타원 클래스를 만드세요. 
	 * */
	public Ellipse(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	@Override
	public void draw() {
		System.out.println("------타원------");
		System.out.println("좌상점 : " + left + "," + top);
		System.out.println("우하점 : " + right + "," + bottom);
		System.out.println("너비 : " + getWidth());
		System.out.println("높이 : " + getHeight());
	}
}
