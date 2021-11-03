package day6;

public class ArrayMultiDimensionEx2 {

	public static void main(String[] args) {
		/* 구구단 2단에서 9단 전체를 배열에 저장하여 출력하는 코드를 작성하세요.
		 * */
		//0번지를 사용 안하기 위해. 사용 안하는 이유=> 편하게 보기위해
		int [][] multipleTable = new int[10][10];
		for(int i = 2; i<= 9; i++) {
			for(int j = 1; j<=9; j++) {
				multipleTable[i][j] = i*j;
				System.out.println(i + " X " + j + " = " + multipleTable[i][j]);
			}
		}
	}

}
