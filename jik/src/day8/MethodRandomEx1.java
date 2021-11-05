package day8;

public class MethodRandomEx1 {

	public static void main(String[] args) {
		/* 1부터 10사이의 랜덤한 수를 생성하여 출력하는 코드를 작성하세요.
		 * 단 랜덤한 수를 메소드를 이용하여 생성하세요. */
		//학생이 칠판에 직접 정수를 적음
		random1();
		//학생이 알려준 정수를 선생님이 칠판에 적음
		System.out.println(random2());
		//학생이 선생님이 알려준 정수의 범위 안(1~10)에 있는 정수를 적음
		random3(1,10);
		//학생이 알려준 정수(선생님이 지정한 범위의 정수)를 선생님이 칠판에 적음
		System.out.println(random4(1,10));
	}
	/* 기능 : 1부터 10사이의 랜덤한 수를 생성하여 출력하는 메소드
	 * 선생님 : "학생1에게 정수를 칠판에 적으세요."
	 * 학생  : 1에서 10사이의 정수를 칠판에 적음.
	 * 매개변수 : 없음
	 *          선생님이 학생1에게 알려준 정보가 없음 
	 * 리턴타입 : 없음 => void
	 *          학생이 선생님에게 알려준 정보가 없음
	 * 메소드명 : random1
	 * */
	public static void random1() {
		int min = 1, max = 10;
		int random = (int)(Math.random()*(max - min + 1) + min);
		System.out.println(random);
	}
	/* 기능 : 1부터 10사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 선생님: "학생1, 정수를 생각해서 나에게 말해주세요."
	 * 학생 : 1에서 10사이의 정수를 선생님에게 알려줌
	 * 매개변수 : 없음
	 *          선생님이 학생1에게 알려준 정보가 없음
	 * 리턴타입 : 정수 => int
	 *          1에서 10사이의 정수를 선생님에게 알려줌
	 * 메소드명 : random2
	 * */
	public static int random2() {
		int min = 1, max = 10;
		int random = (int)(Math.random()*(max - min + 1) + min);
		return random;
	}
	/* 기능 : min부터 max사이의 랜덤한 수를 생성하여 출력하는 메소드
	 * 선생님 : "학생1, 1부터 10사이의 정수를 생각해서 칠판에 적으세요"
	 * 학생   : 1에서 10사이의 정수를 칠판에 적음.
	 * 매개변수 : 1(최소값), 10(최대값) => int min, int max
	 *         선생님이 1과 10이라는 정보를 학생에게 알려줌. 
	 * 리턴타입 : 없음 => void
	 *          학생이 선생님에게 알려주는 정보가 없음
	 * 메소드명 : random3
	 * */
	public static void random3(int min, int max) {
		int random = (int)(Math.random()*(max - min + 1) + min);
		System.out.println(random);
	}
	
	/* 기능 : min부터 max사이의 랜덤한 수를 생성하여 알려주는 메소드
	 * 선생님: "학생1, 1부터 10사이의 정수를 생각해거 말해주세요(알려주세요)"
	 * 학생   : 1에서 10사이의 정수를 말함.(알려줌)
	 * 매개변수 : 1(최소값), 10(최대값) => int min, int max
	 *         선생님이 1과 10이라는 정보를 학생에게 알려줌. 
	 * 리턴타입 : 정수 => int
	 *         학생이 생각한 정수를 선생님에게 말해줘야함.(알려줘야함)
	 * 메소드명 : random4
	 * */
	public static int random4(int min, int max) {
		int random = (int)(Math.random()*(max - min + 1) + min);
		return random;
		//return (int)(Math.random()*(max - min + 1) + min);
	}
}









