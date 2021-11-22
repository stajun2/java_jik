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
				insertStudent(scan, list);
				break;
			case '2':
				printSubmenu('2');
				subMenu = scan.next().charAt(0);
				printStudent(scan, list, subMenu);
				break;
			case '3':
				modifyStudent(scan, list);
				break;
			case '4':
				deleteStudent(scan, list);
				break;
			case '5':
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
		//ToDo 메뉴 출력
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
		return false;
	}
	/**
	 * 메뉴번호에 맞는 서브 메뉴 출력하는 메소드
	 * @author stajun
	 * @param c	메뉴 번호
	 * @return 없음
	 * @throws 없음
	 */
	public static void printSubmenu(char c) {
		
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
		
	}
	/**
	 * 스캐너를 이용하여 리스트에 있는 학생 정보를 수정하는 메소드
	 * @author stajun
	 * @param scan	스캐너
	 * @param list	학생 리스트
	 * @return 학생 정보 수정 여부
	 * @throws 없음
	 */
	public static void modifyStudent(Scanner scan, List<Student> list) {
		
	}
	/**
	 * 스캐너를 이용하여 리스트에 있는 학생 정보를 삭제하는 메소드
	 * @author stajun
	 * @param scan	스캐너
	 * @param list	학생 리스트
	 * @return 학생 정보 삭제 여부
	 * @throws 없음
	 */
	public static void deleteStudent(Scanner scan, List<Student> list) {
		
	}

}
