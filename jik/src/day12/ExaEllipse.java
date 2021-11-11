package day12;

public class ExaEllipse extends ExaShape {

	/* 도형 클래스를 상속받아 타원 클래스를 만드세요. 
	 * */
	public ExaEllipse(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	@Override
	public void print() {
		System.out.println("------타원------");
		System.out.println("좌상점 : " + left + "," + top);
		System.out.println("우하점 : " + right + "," + bottom);
		System.out.println("너비 : " + getWidth());
		System.out.println("높이 : " + getHeight());
	}
	public void testE() {
		System.out.println("타원");
	}
}
