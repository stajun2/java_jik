package day11;

public class Rect {
	private Point lt;//leftTop의 약자, 왼쪽위의 점
	private Point rb;//rightBottom의 약자, 오른쪽 아래 점
		
	public Point getLt() {
		return lt;
	}
	public void setLt(Point lt) {
		this.lt = lt;
	}
	public Point getRb() {
		return rb;
	}
	public void setRb(Point rb) {
		this.rb = rb;
	}
	
	public Rect(Point lt, Point rb) {
		this.lt = new Point(lt);
		//this.lt = new Point(0,0);
		//this.lt.setX(lt.getX());
		//this.lt.setY(lt.getY());
		this.rb = new Point(rb);
		
	}
	public Rect() {
		lt = new Point(0,0);
		rb = new Point(0,0);
	}
	public void move(int x, int y) {
		int width = rb.getX() - lt.getX();
		int height = rb.getY() - lt.getY();
		lt.move(x, y);
		rb.move(x + width, y + height);
	}
	public void resize(int width, int height) {
		rb.move(lt.getX() + width, lt.getY() + height);
	}
	public void print() {
		System.out.println("---사각형---");
		System.out.print("좌상점 : ");
		lt.print();
		System.out.print("우하점 : ");
		rb.print();
	}
}
