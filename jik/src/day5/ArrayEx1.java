package day5;

public class ArrayEx1 {

	public static void main(String[] args) {
		/* 정수형 배열 선언. 크기는 5개짜리
		 * */
		//배열 선언 후, 나중에 배열을 생성하는 방법
		int arr1 [];
		arr1 = new int[5];
		//배열 선언 후, 바로 배열을 생성하는 방법
		int arr2 [] = new int[5];
		
		int []arr3;
		arr3 = new int[5];
		int [] arr4 = new int[5];
		//배열의 크기를 변수로 설정하는 방법
		int size = 5;
		int arr5[] = new int[size];
		
		//[]을 앞에 쓴 경우와 뒤에 쓴 경우의 차이
		int [] arr6, arr7;//arr6: 배열, arr7: 배열
		//int []arr6;
		//int []arr7;
		int arr8[], arr9; //arr8: 배열, arr9: 변수
		//int arr8[];
		//int arr9;
	}
}
