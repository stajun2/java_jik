package day5;

public class StarEx4 {

	public static void main(String[] args) {
		/* 다음과 같이 출력되도록 코드를 작성하세요.
		 * 2n(n=1,2,3,...)
		 * 2n-1(n=1,2,3,...)
		 *     *     i=1  공백=4   *=1
		 *    ***    i=2  공백=3   *=3
		 *   *****   i=3  공백=2   *=5
		 *  *******  i=4  공백=1   *=7
		 * ********* i=5  공백=0   *=9
		 *                공백=5-i *=2*i-1
		 *     *      i=1 공백=4   *=1 *=0
		 *    ** *    i=2 공백=3   *=2 *=1
		 *   *** **   i=3 공백=2   *=3 *=2
		 *  **** ***  i=4 공백=1   *=4 *=3
		 * ***** **** i=5 공백=0   *=5 *=4
		 *                공백=5-i *=i *=i-1
		 * */
		int num = 5, i, j;
		//방법2. StarEx3의 예제를 활용
		for(i=1 ; i<=num; i++) {
			for(j=1; j<=num-i; j++) {
				System.out.print(" ");
			}
			for(j=1; j<=i; j++) {
				System.out.print("*");
			}
			for(j=1; j<=i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		//방법1.
		i = 1;
		while(i<=num) {
			j=1;
			while(j<=num-i) {
				System.out.print(" ");
				j++;
			}
			j=1;
			while(j<=2*i-1) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
