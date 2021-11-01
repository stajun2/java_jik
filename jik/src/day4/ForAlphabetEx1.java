package day4;

public class ForAlphabetEx1 {

	public static void main(String[] args) {
		/* 문자에 숫자를 더하면?? 
		 * 문자와 숫자를 더하면 문자에 맞는 유니코드값에서 1을 더한다.
		 * 'a'는 코드값이 97이고, 'a'에 1을 더한 값은 98이된다.
		 * 이 값을 문자료 변환하면 해당 유니코드값에 맞는 문자 'b'가 된다.*/
		char ch1 = 'a';
		int num = 1;
		char ch2 = (char)(ch1 + 1);  //97 + 1 = 98(int)
		char ch3 = 'a' + 1;  //98(char) = 'b'
		char ch4 = (char)(ch1 + num);//97 + 1 = 98(int)
		System.out.println("ch2 : " + ch2 );
		System.out.println("ch3 : " + ch3 );
		System.out.println("ch4 : " + ch4 );
	}

}
