package day16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ExbListEx3 {

	public static void main(String[] args) {
		/* 학생 성적을 관리하는 프로그램을 만들어보세요.
		 * 메뉴
		 * 1. 학생 정보 추가
		 * 2. 전체 학생 정보 출력
		 * 3. 학생 정보 삭제(삭제할 학생의 정보를 입력하여 일치하는 학생의 정보를 삭제)
		 * 4. 프로그램 종료
		 * Object 클래스의 equals()와 리스트의 remove()를 이용 
		 * */
		ArrayList<ExbStudent> stdList = new ArrayList<ExbStudent>();
		Scanner scan = new Scanner(System.in);
		int menu;
		
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택된 메뉴에 따라 동작 실행
			switch(menu) {
			//학생 정보 추가 기능
			case 1:	inputStudent(scan, stdList);	break;
			//전체 학생 정보 출력 기능
			case 2:	printStudentList(stdList);		break;
			//특정 학생 정보 삭제
			case 3:
				if(deleteStudent(stdList, scan)) {
					System.out.println("학생 정보를 삭제했습니다.");
				}else {
					System.out.println("일치하는 학생 정보가 없습니다.");
				}
				break;
			case 4:	break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 4);
		
		System.out.println("프로그램을 종료합니다.");
		
		scan.close();
	}
	
	public static ExbStudent inputStudent(Scanner scan) {
		System.out.println("학생 정보를 입력하세요.");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		System.out.println("성적을 입력하세요.");
		System.out.print("국어 : ");
		int kor = scan.nextInt();
		System.out.print("영어 : ");
		int eng = scan.nextInt();
		System.out.print("수학 : ");
		int math = scan.nextInt();
		ExbStudent std 
			= new ExbStudent(grade, classNum, num, name, kor, eng, math);
		return std;
	}
	public static void inputStudent(Scanner scan, ArrayList<ExbStudent> stdList) {
		ExbStudent std = inputStudent(scan);
		stdList.add(std);
	}
	public static void printStudentList(ArrayList<ExbStudent> stdList) {
		Iterator<ExbStudent> it = stdList.iterator();
		while(it.hasNext()) {
			ExbStudent tmp = it.next();
			System.out.println(tmp);
		}
	}
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 전체 학생 정보 출력");
		System.out.println("3. 학생 정보 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
	}
	/* 기능 : 주어진 리스트에 Scanner를 통해 입력받은 학생정보를 삭제하여 삭제됐는지 알려주는 메소드
	 * 매개변수 : 주어진 리스트, Scanner => ArrayList<ExbStudent> stdList, Scanner scan
	 * 리턴타입 : 삭제됐는지 안됐는지 => boolean
	 * 메소드명 : deleteStudent
	 * */
	public static boolean deleteStudent(ArrayList<ExbStudent> stdList, Scanner scan) {
		//삭제할 학생 정보를 입력
		System.out.println("삭제할 학생 정보를 입력하세요");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		//방법1
		//삭제할 학생 정보가 몇번지에 있는지 확인하는 작업을 위해
		//ExbStudent클래스의 equals를 오버라이딩 해야함
		//리스트에 특정 객체가 있는지 확인할 때 사용하는 메소드 : contains, indexOf
		ExbStudent std 
			= new ExbStudent(grade, classNum, num, "", 0, 0, 0);
		/*
		int index = stdList.indexOf(std);
		//있으면 해당 번지에 있는 학생 정보를 삭제
		if(index >= 0 ) {
			stdList.remove(index);
			//System.out.println("학생 정보를 삭제했습니다.");
			return true;
		}else {
			//System.out.println("일치하는 학생 정보가 없습니다.");
			return false;
		}
		*/
		//방법2
		//학생 정보를 삭제했을 때 해당 학생 정보가 있으면 삭제되었습니다
		//없으면 삭제할 학생 정보가 없습니다를 출력
		return stdList.remove(std);
	}
}


