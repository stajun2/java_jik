package day2;

public class BitwiseEx1 {

	public static void main(String[] args) {
		int num1 = 3, num2 = 10;
		//3  : 00000000 00000000 00000000 00000011
		//10 : 00000000 00000000 00000000 00001010
		//and: 00000000 00000000 00000000 00000010 : 2
		//or : 00000000 00000000 00000000 00001011 : 11
		//xor: 00000000 00000000 00000000 00001001 : 9
		//not: 11111111 11111111 11111111 11111100 : -4
		int and = num1 & num2;
		int or = num1 | num2;
		int not = ~num1;
		int xor = num1 ^ num2;
		System.out.println(num1 + " & " + num2 + " = " + and);
		System.out.println(num1 + " | " + num2 + " = " + or);
		System.out.println(num1 + " ^ " + num2 + " = " + xor);
		System.out.println("~" + num1 + " = " + not);
	}
}
