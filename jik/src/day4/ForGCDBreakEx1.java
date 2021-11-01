package day4;

public class ForGCDBreakEx1 {

	public static void main(String[] args) {
		/* 두 정수의 최대 공약수를 break문을 이용하여 작성하세요.
		 * 공약수를 큰수부터 구하기 시작해서 처음 구한 공약수를 출력하고 반복문을 종료 
		 * */
		int i;
		int num1 = 12, num2 = 8;
		for(i = num1; i >= 1; i--) {
			if(num1 % i == 0 && num2 % i == 0) {
				System.out.println(num1 + "과 " + num2 + "의 최대 공약수 : " + i);
				break;
			}
		}
	}

}
