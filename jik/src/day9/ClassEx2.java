package day9;

public class ClassEx2 {

	public static void main(String[] args) {
		Point2D pt = new Point2D();
		pt.print();
		Point2D pt2 = new Point2D(3,4);
		pt2.print();
		pt2.move(10, 20);
		pt2.print();
	}
}
//좌표평면에서 점 하나를 나타내기 위한 클래스 Point2D를 만들어보세요.
/* 클래스명 : Point2D
 * 멤버변수 : 점하나 => x좌표, y좌표 => 정수 => int x, int y 
 * 멤버메소드
 *  - 현재 좌표 정보를 출력하는 메소드
 *  - 지정된 좌표(누군가 알려준 좌표)로 이동하는 메소드
 * 생성자
 * - 기본생성자 : x,y좌표를 0으로 초기화
 * - 생성자오버로딩 : 밖에러 알려준 좌표로 x,y좌표를 초기화
 * */
class Point2D{
	int x, y;
	
	Point2D(){
		x = 0; y = 0;//이 줄을 지워도 됨=> 멤버변수 x,y는 기본 초기값이 0
	}
	Point2D(int x1, int y1){
		x = x1; y = y1;
	}
	//매개변수 필요 x => 남이 알려준 좌표가 아닌, 내 x,y좌표를 출력해야 하기 때문
	void print() {
		System.out.println(x + "," + y);
	}
	/* 기능 : 지정된 좌표로 멤버변수 x,y를 이동시키는 메소드
	 * 매개변수 : 지정된 좌표(남이 알려준 좌표) => int x1, int y1
	 * 리턴타입 : 없음 => void
	 * 메소드명 : move
	 * */
	void move(int x1, int y1) {
		x = x1; y = y1;
	}
}







