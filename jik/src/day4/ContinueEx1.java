package day4;

public class ContinueEx1 {

	public static void main(String[] args) {
		/* continue가 if문과 같이 나와야 하는 이유를 보여주는 예제 */
		int i;
		for(i = 1; i<= 5; i++) {
			continue;
			//System.out.println("Hello"); //에러 발생//continue 때문에 실행될 일이 없어서
		}
	}
}
