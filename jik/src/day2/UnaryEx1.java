package day2;

public class UnaryEx1 {

	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		System.out.println("증가 전 : num1 = " + num1 + ", num2 = " + num2);
		//num1은 전위형 증가연산자를 이용, num2는 후위형 증가연산자를 이용\
		//num1을 1 증가하고 앞의 문자열과 더함
		//num2는 문자열과 더한 후에 num2를 1 증가
		System.out.println("증가 중 : num1 = " + ++num1 + ", num2 = " + num2++);
		System.out.println("증가 후 : num1 = " + num1 + ", num2 = " + num2);
		//num1을 1 증가
		++num1; //14번째줄 코드와 같은 코드들 : num1++, num1 = num1 + 1, num1 += 1
		//num2를 1 증가
		num2++;
		//12,12
		System.out.println("증가 후2: num1 = " + num1 + ", num2 = " + num2);
		
	}

}
