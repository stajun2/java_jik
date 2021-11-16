package homework.hw1.type2;

import java.util.Calendar;
import java.util.Scanner;

public class DrawProgram implements DrawProgramFunction {
	private int maxSize;	//도형 최대 크기
	private int drawCount;	//그려진 도형 갯수
	private int cancleCount;//취소한 도형 갯수
	private Shape [] list;
	private Shape [] basket;//실행 취소시 담을 쓰레기통
	Scanner scan;
	
	public DrawProgram(int maxSize, Scanner scan) {
		this.maxSize = maxSize;
		list = new Shape[maxSize];
		basket = new Shape[maxSize];
		this.scan = scan;
	}

	@Override
	public void draw(Shape shape) {
		// TODO 도형 그리기
		if(drawCount < maxSize) {
			list[drawCount] = shape;
			drawCount++;
			cancleCount = 0;
		}
	}

	@Override
	public void ctrlz() {
		// TODO 실행 취소 => 그린 도형을 basket으로 이동
		if(drawCount > 0) {
			drawCount--;	
			basket[cancleCount] = list[drawCount];
			cancleCount++;
		}else {
			System.out.println("더 이상 실행 취소 할 수 없습니다.");
		}
	}

	@Override
	public void ctrly() {
		// TODO 다시실행
		if(0 < cancleCount) {
			cancleCount--;
			list[drawCount] = basket[cancleCount];
			drawCount++;
		}else {
			System.out.println("더 이상 다시 실행 할 수 없습니다.");
		}

	}

	@Override
	public void view() {
		// TODO 도형 그리기
		for(int i = 0; i<drawCount; i++) {
			list[i].draw();
		}
	}

	@Override
	public void run() {
		// TODO 프로그램 실행
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			switch(menu) {
			case 1:	draw(createShape());	break;
			case 2:	ctrly();				break;
			case 3:	ctrlz();				break;
			case 4: view();					break;
			case 5: break;
			}
		}while(menu != 5);
		close();
	}

	@Override
	public void close() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	private void printMenu() {
		System.out.println("메뉴--------");
		System.out.println("1. 도형그리기");
		System.out.println("2. 다시실행");
		System.out.println("3. 실행취소");
		System.out.println("4. 도형 확인");
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴를 선택하세요 : ");
	}
	private Shape createShape() {
		Shape shape;
		System.out.print("그릴 도형을 선택하세요(1. 사각형, 2. 타원) : ");
		int type = scan.nextInt();
		System.out.println("점 두개를 입력하세요(예 : 1 2 3 4 => (1,2) (3,4)) :");
		int x1 = scan.nextInt();
		int x2 = scan.nextInt();
		int x3 = scan.nextInt();
		int x4 = scan.nextInt();
		shape = type == 1 ? new Rect(x1, x3, x2, x4) : new Ellipse(x1, x3, x2, x4);
		return shape;
	}
}
