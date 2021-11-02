package day5;

public class PrimeNumEx1 {

	public static void main(String[] args) {
		/* 2부터 100이하의 모든 소수를 출력하는 예제
		 * 소수 판별 예제 참고. 
		 * */
		int num = 2;
		int i = 1, count = 0;
		
		while(num <= 100) {//num=4
			//약수는 1부터 num까지 확인
			i=1;
			count = 0;
			while(i<=num) {
				if(num % i == 0) {
					count++;
				}
				i++;
			}
			if(count == 2) {
				System.out.print(num + " ");
			}
			num++;
		}
		
		
	}

}
