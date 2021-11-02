package day5;

public class StarEx3 {

	public static void main(String[] args) {
		/*     * i=1 공=4 *=1 엔터
		 *    ** i=2 공=3 *=2 엔터
		 *   *** i=3 공=2 *=3 엔터
		 *  **** i=4 공=1 *=4 엔터
		 * ***** i=5 공=0 *=5 엔터
		 *           공=5-i *=i
		 * 위와 같이 출력되도록 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 실행문 : 공백을 5-i개 출력하고, *을 i개 출력하고, 엔터를 출력
		 *        반복횟수 : j는 1부터 5-i까지 1씩 증가 " "을 출력 
		 *        실행문 : 공백을 출력
		 *        반복횟수 : j는 1부터 i까지 1씩 증가
		 *        실행문 : *을 출력
		 *        엔터를 출력
		 * */
		int num = 5, i, j;
		for(i=1 ; i<=num; i++) {
			for(j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for(j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
