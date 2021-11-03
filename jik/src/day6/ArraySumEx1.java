package day6;

public class ArraySumEx1 {

	public static void main(String[] args) {
		/* 2부터 10사이의 짝수들을 배열에 저장하고, 배열에 저장된 값의 합을 출력하는
		 * 코드를 작성하세요.
		 * */
		//정수형 5개짜리 배열 선언
		int [] arr = new int[5];
		//배열에 2부터 10까지 저장
		arr[0] = 2;
		arr[1] = 4;
		arr[2] = 6;
		arr[3] = 8;
		arr[4] = 10;
		
		//배열에 있는 값을 꺼내서 더함(누적)
		int sum = 0;
		sum += arr[0];
		sum += arr[1];
		sum += arr[2];
		sum += arr[3];
		sum += arr[4];
		System.out.println("2부터 10까지 합 : " + sum);
		
		int arr2[] = new int[5];
		int i;
		for(i = 0; i < 5; i++) {
			arr2[i] = 2 * i + 2;
		}
		for(i = 0, sum=0; i < 5; i++) {
			sum += arr2[i];
		}
		System.out.println("2부터 10까지 합 : " + sum);
	}

}
