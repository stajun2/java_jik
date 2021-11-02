package day5;

public class MutipleTableEx1 {

	public static void main(String[] args) {
		/* 2단에서 9단까지 구구단을 출력하는 코드를 작성하세요.
		 * 7단 코드를 가져와서 생각
		 * */
		int num = 2, j;
		//단을 2에서 9단까지 1씩 증가
		while(num <= 9) {
			//num단 출력하는 코드
			j= 1;
			while(j<=9) {
				System.out.println(num + " X " + j + " = " + num * j);
				j++;
			}
			num++;
		}
		
		
		
	}

}
