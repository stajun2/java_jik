package homework.hw2.type1;

import java.util.*;

public class StudentMain {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		Scanner scan = new Scanner(System.in);
		char menu = '\0', subMenu = '\0';
		
		do {
			printMenu();
			menu = scan.next().charAt(0);
			switch(menu) {
			case '1':
				if(insertStudent(scan, list)) {
					System.out.println("학생 정보를 추가했습니다.");
				}else {
					System.out.println("이미 있는 학생입니다.");
				}
				break;
			case '2':
				printSubmenu('2');
				subMenu = scan.next().charAt(0);
				printStudent(scan, list, subMenu);
				break;
			case '3':
				if(modifyStudent(scan, list)) {
					System.out.println("학생 정보를 수정했습니다.");
				}else {
					System.out.println("없는 학생 정보입니다.");
				}
				break;
			case '4':
				if(deleteStudent(scan, list)) {
					System.out.println("학생 정보를 삭제했습니다.");
				}else {
					System.out.println("없는 학생 정보입니다.");
				}
				break;
			case '5':
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}while(menu != '5' );
		scan.close();
	}

	/**
	 * 메뉴를 출력하는 메소드
	 * @author stajun
	 * @param 없음
	 * @return 없음
	 * @throws 없음
	 */
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 정보 추가");
		System.out.println("2. 학생 정보 출력");
		System.out.println("3. 학생 정보 수정");
		System.out.println("4. 학생 정보 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	/**
	 * 스캐너를 이용하여 학생 정보를 리스트에 추가하는 메소드
	 * @author stajun
	 * @param scan	스캐너
	 * @param list	학생 리스트
	 * @return 리스트에 새로운 학생 추가 여부
	 * @throws 없음
	 */
	public static boolean insertStudent(Scanner scan, List<Student>list) {
		//학생 정보 확인
		System.out.println("학생 정보를 입력하세요");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		//입력된 학생인지 확인
		if(list.contains(new Student(grade, classNum, num, name))) {
			return false;
		}
		//성적 입력
		char isContine = 'y';
		List<Score> score = new ArrayList<Score>();
		while(true) {
			System.out.print("성적을 입력하겠습니까?(y/n) : ");
			isContine = scan.next().charAt(0);
			if(isContine == 'n' || isContine == 'N') {
				break;
			}
			System.out.print("과목명 : ");
			scan.nextLine();
			String subjectTitle = scan.nextLine();
			System.out.print("학년 : ");
			int grade2 = scan.nextInt();
			System.out.print("학기 : ");
			int term = scan.nextInt();
			System.out.print("점수 : ");
			int point = scan.nextInt();
			score.add(new Score(subjectTitle, grade2, term, point));
		}
		list.add(new Student(grade, classNum, num, name, score));
		return true;
	}
	/**
	 * 메뉴번호에 맞는 서브 메뉴 출력하는 메소드
	 * @author stajun
	 * @param c	메뉴 번호
	 * @return 없음
	 * @throws 없음
	 */
	public static void printSubmenu(char c) {
		switch(c) {
		case '2':
			System.out.println("출력 메뉴");
			System.out.println("1. 전체 출력");
			System.out.println("2. 검색 출력");
			System.out.print("메뉴 선택 : ");
			break;
		}
	}
	/**
	 * 서브 메뉴에 맞는 학생 정보를 출력하는 메소드
	 * @author stajun
	 * @param scan	스캐너
	 * @param list	학생 리스트
	 * @param c	메뉴 번호
	 * @return 없음
	 * @throws 없음
	 */	
	public static void printStudent(Scanner scan, List<Student> list, char subMenu) {
		switch(subMenu) {
		case '1':
			for(Student tmp : list) {
				System.out.println(tmp);
			}
			break;
		case '2':
			System.out.println("출력할 학생 정보를 입력하세요");
			System.out.print("학년 : ");
			int grade = scan.nextInt();
			System.out.print("학반 : ");
			int classNum = scan.nextInt();
			System.out.print("번호 : ");
			int num = scan.nextInt();
			int index = list.indexOf(new Student(grade, classNum, num, ""));
			if(index >= 0) {
				System.out.println(list.get(index));
			}else {
				System.out.println("없는 학생입니다.");
			}
			break;
		default:
			System.out.println("메뉴를 잘못 선택했습니다.");
		}
	}
	/**
	 * 스캐너를 이용하여 리스트에 있는 학생 정보를 수정하는 메소드
	 * @author stajun
	 * @param scan	스캐너
	 * @param list	학생 리스트
	 * @return 학생 정보 수정 여부
	 * @throws 없음
	 */
	public static boolean modifyStudent(Scanner scan, List<Student> list) {
		System.out.println("수정할 학생 정보를 입력하세요");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		int index =list.indexOf(new Student(grade, classNum, num, null)); 
		if(index < 0) {
			return false;
		}
		Student tmp = list.get(index);
		System.out.print("이름 : ");
		scan.nextLine();
		tmp.setName(scan.nextLine());
		List<Score> tmpScore = tmp.getScore();
		while(true) {
			System.out.print("성적을 수정하겠습니까?(y/n) : ");
			char isContinue = scan.next().charAt(0);
			if(isContinue == 'n' || isContinue == 'N') {
				break;
			}
			System.out.println("수정할 성적을 입력하세요");
			System.out.print("과목명 : ");
			scan.nextLine();
			String subjectTitle = scan.nextLine();
			System.out.print("학년 : ");
			int grade2 = scan.nextInt();
			System.out.print("학기 : ");
			int term = scan.nextInt();
			System.out.print("성적 : ");
			int score = scan.nextInt();
			Score obj = new Score(subjectTitle, grade2, term, score);
			int index2 = tmpScore.indexOf(obj);
			if(index2 < 0) {
				System.out.println("없는 성적입니다.");
			}else {
				tmpScore.set(index2, obj);
			}
		}
		return true;
	}
	/**
	 * 스캐너를 이용하여 리스트에 있는 학생 정보를 삭제하는 메소드
	 * @author stajun
	 * @param scan	스캐너
	 * @param list	학생 리스트
	 * @return 학생 정보 삭제 여부
	 * @throws 없음
	 */
	public static boolean deleteStudent(Scanner scan, List<Student> list) {
		System.out.println("삭제할 학생 정보를 입력하세요");
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("학반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return list.remove(new Student(grade, classNum, num, null));
	}

}
