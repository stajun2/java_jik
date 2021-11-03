package day6;

import java.util.Arrays;

public class ArraySortEx2 {

	public static void main(String[] args) {
		//다음과 같은 배열이 있을 때 정렬하는 코드를 작성하세요.
		int num [] = {1, 10, 9, 3, 6, 2, 3, 4};
		
		//Arrays.sort(num); //오름차순
		Arrays.sort(num, 0,5);//0번지부터 5번지까지 오른차순으로 정렬
		
		for(int tmp : num) {
			System.out.print(tmp + " ");
		}
	}

}
