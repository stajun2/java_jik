package day13;

public class ExcTestEx1 {

	public static void main(String[] args) {
		/* 추상 클래스는 추상 클래스를 이용하여 객체를 만들 수 없다 */
		//추상 클래스를 이용하여 객체를 생성하려고 했기 때문에 에러 발생
		//ExcP p = new ExcP();
		//추상 클래스의 자식 클래스 객체를 이용하면 추상 클래스 객체도 만들 수 있다
		ExcP p = new ExcC();
		p.test();
	}
}
abstract class ExcP{
	public abstract void test();
}
class ExcC extends ExcP{
	@Override
	public void test() {
		System.out.println("추상 메소드");
	}
}
