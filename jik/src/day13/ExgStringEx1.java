package day13;

public class ExgStringEx1 {

	public static void main(String[] args) {
		/* 문자열 String 객체 생성 방법
		 * 1. ""를 이용하여 생성
		 * 2. new 연산자를 이용하여 생성
		 * */
		String str1 = "Hi";
		String str2 = new String("Hi"); 
		String str3 = "Hi";
		/* str1과 str3는 A지점에 있는 Hi라는 문자열을 공유
		 * str2는 B지점에 있는 Hi라는 문자열을 사용
		 * */
		System.out.println("str1과 str2의 주소가 같다? " + (str1 == str2));
		System.out.println("str1과 str3의 주소가 같다? " + (str1 == str3));
		System.out.println("str2과 str3의 주소가 같다? " + (str2 == str3));
		
		System.out.println("----------------------------");
		
		System.out.println("str1과 str2의 문자열 같다? " + str1.equals(str2));
		System.out.println("str1과 str3의 문자열 같다? " + str1.equals(str3));
		System.out.println("str2과 str3의 문자열 같다? " + str2.equals(str3));
	}

}
