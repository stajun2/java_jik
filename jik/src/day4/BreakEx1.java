package day4;

public class BreakEx1 {

	public static void main(String[] args) {
		/* 반복문에서 break문이 if문 같이 써야하는지를 보여주는 예제. */
		for( ; ; ) {
			System.out.println("Hello");
			//break가 if문 없이 나왔기 때문에 반복문이 의미가 없어 짐
			break;
		}
		/* 1부터 5까지 break문을 이용하여 출력하는 예제 */
		int i;
		for(i = 1; i<=5; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for( i = 1; ; i++) {
			System.out.print(i + " ");
			if(i == 5) {
				break;
			}
		}
		System.out.println();
	}
	
}
