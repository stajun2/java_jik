package day17;

import java.util.*;

public class ExaLottoEx1 {

	public static void main(String[] args) {
		/* 로또 프로그램을 day17 패키지의 야구 게임을 활용하여 만드세요. */
		List<Integer> lotto = new ArrayList<Integer>();
		List<Integer> user = new ArrayList<Integer>();
		int bonus = 0;
		int min = 1, max = 45;
		int count = 6, total = 0;
		char ch='y';
		Scanner scan = new Scanner(System.in);
		// 로또 당첨 번호를 랜덤으로 생성
		ExeBaseBallEx1.createRandomList(lotto, min, max, count);
		
		// 로또 보너스 번호를 랜덤으로 생성
		while(true) {
			bonus = (int)(Math.random()*(max - min + 1) + min);
			if(!lotto.contains(bonus)) {
				break;
			}
		}
		
		System.out.print(lotto);
		System.out.println(" : " + bonus);
		
		//반복
		while(ch == 'y' || ch == 'Y') {
			// 사용자가 로또 번호 입력
			System.out.print("6개 입력 : ");
			int inputResult = ExeBaseBallEx1.inputList(user, min, max, count, scan);
			switch(inputResult) {
			case -1:
				System.out.println("중복된 값을 입력했습니다.");
				break;
			case 1:
				System.out.println("잘못된 범위의 정수를 입력했습니다.");
				break;
			}
			// 당첨 갯수 확인
			total = ExeBaseBallEx1.getBall(lotto, user)
					+ ExeBaseBallEx1.getStrike(lotto, user);
			
			//당첨 등수 확인
			switch (total) {
			case 6:	System.out.println("1등 당첨");	break;
			case 5:	
				if(user.contains(bonus)) {
					System.out.println("2등 당첨");
				}else {
					System.out.println("3등 당첨");
				}
				break;
			case 4:	System.out.println("4등 당첨");	break;
			case 3:	System.out.println("5등 당첨");	break;
			default: System.out.println("꽝");
			}
			//더 할건지 말건지 물어보는 코드
			System.out.print("더하시겠습니까?(y/n) : ");
			ch = scan.next().charAt(0);
		}
		System.out.println("프로그램을 종료하겠습니다.");
	}

}

