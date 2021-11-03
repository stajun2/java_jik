package day6;

public class ArrayCopyEx1 {

	public static void main(String[] args) {
		int num1 = 10;
		//정수형 변수 num2를 선언하고, num2에 num1에 값을 저장하세요.
		//일반 변수는 =를 이용하여 값을 복사한 후에 원본 값이 바뀌면 복사본 값이 안바뀜
		//원본 : num1, 복사본 : num2
		int num2 = num1;
		System.out.println("num1 : " + num1 + ", num2 : " + num2);
		num1 = 20;
		System.out.println("num1 : " + num1 + ", num2 : " + num2);
		
		/* 참조 변수는 =을 이용하여 복사를 하면, 값이 복사되는게 아니라 주소를 공유한다.
		 * 값이 바뀌면 같이 바뀜*/
		int arr1[] = {1, 2, 3};
		/*
		int arr1[] = new int[3];
		arr1[0] = 1;
		arr1[1] = 2;
		arr1[2] = 3;
		*/
		int arr2[] = arr1;
		arr1[0] = 10;
		System.out.print("arr1 : ");
		for(int tmp : arr1) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		System.out.print("arr2 : ");
		for(int tmp : arr2) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		/* 배열을 제대로 복사하기 위해서(원본을 수정해도 복사본이 바뀌지 않기 위해서)는
		 * 배열을 새로 생성하여 모든 번지에 있는 값을 하나씩 복사해야한다. */
	}

}
