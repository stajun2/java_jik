package day2;

public class ArithmeticEx1 {

	public static void main(String[] args) {
		int num1 = 30, num2 = 7;
		int add, sub, mul, div1, mod;
		double div2;
		
		add  = num1 + num2;
		sub  = num1 - num2;
		mul  = num1 * num2;
		div1 = num1 / num2;
		div2 = num1 / (double)num2;
		mod  = num1 % num2; 
		
		System.out.println(num1 + "+" + num2 + "=" + add);
		System.out.println(num1 + "-" + num2 + "=" + sub);
		System.out.println(num1 + "*" + num2 + "=" + mul);
		System.out.println(num1 + "/" + num2 + "=" + div1);
		System.out.println(num1 + "/" + num2 + "=" + div2);
		System.out.println(num1 + "%" + num2 + "=" + mod);
		
		System.out.println(num1 + "/" + 7.0 + "=" + (num1 / 7.0));
	}
}
