package day2;

public class CastEx1 {

	public static void main(String[] args) {
		//자동 자료형변환이 일어남. 0이 0.0이 되고 num1에 저장
		//정수를 실수에 저장하는 경우 자동자료형 변환이 됨
		//크기가 작은 정수를 크기가 큰 정수에 저장하는 경우 자동자료형 변환이 됨
		//문자를 큰 정수나 실수에 저장하는 경우
		double num1 = 0;
		byte num2 = 1;
		int num3 = num2;
		char ch = 'a';
		int num4 = ch;
		int num5 = (int)0.0;//자동 자료형 변환이 안되는 경우 명시적형변환을 해야 함
		//float num6 = 1.23;//에러 발생. 1.23은 double형이기 때문에
	}
}
