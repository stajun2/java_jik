package day11;

//2차원 좌표 평면의 점 하나를 나타내는 클래스
public class Point {
	private int x, y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//복사생성자
	public Point(Point pt) {
		this.x = pt.x;
		this.y = pt.y;
	}
	//좌표 이동 기능
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//좌표를 출력하는 기능
	public void print() {
		System.out.println("(" + x + " , " + y +")");
	}
}


