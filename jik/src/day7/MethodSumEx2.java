package day7;

public class MethodSumEx2 {

	public static void main(String[] args) {
		/* 1부터 10까지 합을 출력하는 코드를 메소드를 이용하여 작성해보세요. */
		//sumAll1은 1부터 10까지 합이 고정이기 때문에 5부터 10까지 합을 구할 수 없다
		sumAll1();
		//sumAll2는 sumAll1보다는 낫다. 1에서 5까지의 합을 구할수 있다.
		//5에서 10까지의 합을 구할수 없다
		sumAll2(10);
		//1에서 10까지의 합과 21에서 30까지의 합을 더한 값을 구할 때 사용할 수 없다.
		sumAll3(1,10);
		int begin = 1, end = 10;
		System.out.println(begin + "부터 " + end + "까지 합 : " + sumAll4(begin,end));
		int sum = sumAll4(1,10) + sumAll4(21,30);
		System.out.println("1에서 10까지의 합과 21에서 30까지의 합을 더한 값 : "+sum);
	}
	/* 기능 : 1부터 10까지 합을 콘솔에 출력하는 메소드(1과 10은 고정)
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메소드명 : sumAll1
	 * */
	public static void sumAll1() {
		int begin = 1, end = 10;
		int sum = 0;
		for(int i = begin; i <=end; i++) {
			sum += i;
		}
		System.out.println(begin + "부터 " + end + "까지 합 : " + sum);
	}
	/* 기능 : 1부터 end까지 합을 콘솔에 출력하는 메소드
	 * 매개변수 : 마지막수 => int end
	 * 리턴타입 : 없음 => void
	 * 메소드명 : sumAll2
	 * */
	public static void sumAll2(int end) {
		int begin = 1;
		int sum = 0;
		for(int i = begin; i <=end; i++) {
			sum += i;
		}
		System.out.println(begin + "부터 " + end + "까지 합 : " + sum);
	}
	/* 기능 : begin부터 end까지 합을 콘솔에 출력하는 메소드
	 * 매개변수 : 시작수와 마지막수 =>int begin, int end
	 * 리턴타입 : 없음 => void
	 * 메소드명 : sumAll3 
	 * */
	public static void sumAll3(int begin, int end) {
		int sum = 0;
		for(int i = begin; i <=end; i++) {
			sum += i;
		}
		System.out.println(begin + "부터 " + end + "까지 합 : " + sum);
	}
	/* 기능 : begin부터 end까지 합을 알려주는 메소드
	 * 매개변수 : 시작수와 마지막수 =>int begin, int end
	 * 리턴타입 : 누적합 => 정수 => int
	 * 메소드명 : sumAll4 
	 * */
	public static int sumAll4(int begin, int end) {
		int sum = 0;
		for(int i = begin; i <=end; i++) {
			sum += i;
		}
		return sum;
	}
}
