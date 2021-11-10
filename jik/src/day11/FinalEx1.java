package day11;

public class FinalEx1 {
	public final static double PI = 3.14; 
	
	public static void main(String[] args) {
		System.out.println(PI);
		//PI = 3.141592;//상수를 수정하려 했기 때문에 에러 발생
	}
}

final class Test11_1{}
//Test11_1은 final 클래스이기 때문에 상속받을수 없어서 에러 발생
//class Test11_2 extends Test11_1{}

class Test11_3{
	public final void print() {}
}
class Test11_4 extends Test11_3{
	//final 메소드를 오버라이딩 하려 했기 때문에 에러 발생
	//public void print() {}
}



