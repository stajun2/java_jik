package day10;

public class Rect2 {
	//양 끝점을 이용한 사각형(그림판기준 : 위의점 y < 아래점 y)
	private int left;	//왼쪽위점의 x좌표
	private int top;	//왼쪽위점의 y좌표
	private int right;	//오른쪽아래점의 x좌표
	private int bottom;	//오른쪽아래점의 y좌표
	
	public Rect2() {}

	public Rect2(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}
	//사각형 정보 출력 기능
	public void print() {
		System.out.println("---사각형2---");
		System.out.println("시작점 : " + left + "," + top);
		System.out.println("가로  : " + (right-left));
		System.out.println("세로  : " + (bottom-top));
		System.out.println("----------");
	}
	//사각형 이동 기능(시작점을 이동)
	public void move(int x, int y) {
		int width = right - left;
		int height= bottom - top;
		left = x;			top = y;
		right = x + width;	bottom = y + height;
	}
	
	//사각형 크기 변경 기능(왼쪽 위의점을 기준으로 크기변경)
	public void resize(int width, int height) {
		right = left + width;	bottom = top + height;
	}
	
}








