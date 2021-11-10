package day11;

public class ClassSuperEx1 {

	public static void main(String[] args) {
		Child1 c1 = new Child1(1,2,3);
		c1.print();
	}
}
class Parent1{
	private int x, y;
	public void print() {
		System.out.println("클래스 입니다.");
		System.out.println("x : " + x);
		System.out.println("y : " + y);
	}
	public Parent1(int x, int y){
		this.x = x;	this.y = y;
	}
	public Parent1() {}
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
	
}
class Child1 extends Parent1{
	
	private int z;
	
	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Child1(int x, int y, int z) {
		//부모에게 물려받은 x,y를 매개변수 x,y의 값으로 설정하려 하는데
		//setter를 이용해서 할 수 있지만, setter를 이용하는 것보다
		//부모 클래스에 있는 생성자를 이용하는게 편하다
		//setX(x);		setY(y);
		super(x, y);
		this.z = z;
	}
	/* 클래스 안에 멤버 변수, 메소드, 생성자가 하나도 없으면
	 * 자동으로 기본 생성자가 생성되고,
	 * 기본 생성자 안에 부모 클래스의 기본 생성자가 호출된다.
	 * 이 때, 부모 클래스의 기본 생성자가 없는 경우 호출할 수 없어서 에러가 발생
	 */
	/*public Child1() {
		super();
	}*/
	@Override
	public void print() {
		//부모에 있는 print를 이용하여 x,y를 출력하고 뒷부분은 직접 출력
		super.print();
		System.out.println("z : " + z);
	}
}












