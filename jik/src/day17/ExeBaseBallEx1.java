package day17;

import java.util.*;

public class ExeBaseBallEx1 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크를 이용하여 숫자 야구 게임을 구현해보세요. */
		//컴퓨터가 랜덤으로 만든 숫자 3개 생성
		//생성된 숫자를 저장할 리스트 선언 및 생성
		List<Integer> com = new ArrayList<Integer>();
		List<Integer> use = new ArrayList<Integer>();
		int min = 1, max = 9;
		int count = 3;
		int strike = 0, ball = 0;
		Scanner scan = new Scanner(System.in);
		
		try {
			createRandomList(com, min, max, count);
		}catch(Exception e) {
			System.out.println("============================");
			System.out.println("예외 발생!! : "+e.getMessage());
			System.out.println("============================");
			System.out.println("숫자 생성에 실패하여 게임을 할 수 없습니다.");
			return;
		}
		
		System.out.println(com);
		//반복 : 다 맞출때까지 반복 => 3 스트라이크가 될때까지
		while(strike != count) {
			//사용자가 숫자 3개를 입력
			int i = 0;
			Set<Integer> useSet = new HashSet<Integer>();
			while(i < count) {
				int tmp = scan.nextInt();
				useSet.add(tmp);
				use.add(tmp);
				i++;
			}
			if(useSet.size() != count) {
				System.out.println("중복된 숫자를 입력했습니다.!!!!!!!!");
			}
			//스트라이크 갯수 확인
		
			//볼의 갯수 확인
		
			//판별
		}
		//프로그램 종료라고 알림
	}
	/* 기능 : 정수 리스트가 주어지면 해당 정수 리스트에 min~max 사이의 값을 중복되지
	 *       않게 count개를 저장하는 메소드
	 * 매개변수 : 주어진 정수 리스트, 정수 범위, 저장할 갯수 => 
	 * 			List<Integer> list, int min, int max, int count
	 * 리턴타입 : 없음 => void
	 * 메소드명 : createRandomList
	 * */
	public static void createRandomList(List<Integer> list, int min, int max, int count) {
		if(list == null) {
			//return ;//리스트 비어서 일 안함
			//리스트가 비어서 문제 발생함
			throw new NullPointerException("com이 null입니다.");
		}
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		if(count > max - min + 1) {
			throw new RuntimeException("범위가 배열의 크기보다 작아서 만들 수 없습니다.");
		}
		//중복되지 않은 숫자를 생성하기 위한 임시 set을 선언 및 생성
		Set<Integer> comSet = new HashSet<Integer>();
		//comSet에 3개 저장될때까지 반복
		while(comSet.size() < count) {
			//램던한 수 생성
			int r = (int)(Math.random() * (max - min + 1) + min);
			//comSet 생성한 랜덤수를 저장
			boolean isSave = comSet.add(r);
			//위에서 랜덤수가 저장이 됐다면 com리스트에 랜덤수를 저장
			if(isSave) {
				list.add(r);
			}
			/*if(comSet.add(r)) {
				com.add(r);
			}*/
		}
	}
}






