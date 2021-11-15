package day14;

public class ExaStringReplaceEx1 {

	public static void main(String[] args) {
		/* String replace(char oldCh, char newCh)
		 * : 문자열에 oldCh라는 문자가 있으면 newCh로 바꾸고 바뀐 문자열을 알려주는
		 *   메소드, 기존 문자열은 바뀌지 않음
		 * */
		String str = "I love JAVA";
		System.out.println(str.replace('A', 'a'));
		//replace를 쓰더라도 기존 문자열은 바뀌지 않음을 아래에서 확인할 수 있다.
		System.out.println(str);
		
		str = str.replace('A', 'a');
		System.out.println(str);
		
		str = str.replace("JaVa", "SPRING");
		System.out.println(str);
		
	}

}
