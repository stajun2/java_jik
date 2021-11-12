package day13;

public class ExgStringContainsEx1 {

	public static void main(String[] args) {
		/* boolean contains(CharSequence s) : 문자열에 s가 포함됐는지 알려주는 메소드
		 * */
		String str1 = "Hello world";
		System.out.println(str1.contains("wo"));
		System.out.println(str1.contains("He"));
		System.out.println(str1.contains("Hi"));
	}

}
