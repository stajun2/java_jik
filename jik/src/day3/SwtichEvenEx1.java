package day3;

public class SwtichEvenEx1 {

	public static void main(String[] args) {
		/* switch문을 이용하여 정수의 홀짝 여부를 판별하는 코드를 작성하세요.
		 * */
		int num = 11;
		switch(num % 2) {
		case 0:
			System.out.println(num + "는 짝수");
			break;
		default:
			System.out.println(num + "는 홀수");
		}
	}

}
