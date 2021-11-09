package day10;

import java.util.Scanner;

/* 게시글을 관리하는 클래스 */
public class BoardManager {
	private Board [] boardList;
	private int count;
	private Scanner scan;
	
	public BoardManager(Scanner scan) {
		this(10,scan);
		//boardList = new Board[10];
		//this.scan = scan;
	}
	public BoardManager(int size, Scanner scan) {
		this.scan = scan;
		if(size > 10) {
			boardList = new Board[size];
		}else {
			boardList = new Board[10];
		}
	}
	//게시글 등록 기능
	public void insertBoard() {
		scan.nextLine();//메뉴에서 입력한 엔터를 처리
		System.out.print("게시글 제목 : ");
		String title = scan.nextLine();
		System.out.print("게시글 내용 : ");
		String contents = scan.nextLine();
		System.out.print("작성자 : ");
		String writer = scan.next();
		System.out.print("작성일 : ");
		String date = scan.next();
		//게시글을 생성한 후, 입력받은 정보들로 초기화를 하고,
		//초기화 된 게시글을 내가 원하는 배열에 번지에 저장
		boardList[count] 
				= new Board(count+1, title, contents, date, writer);
		//저장된 게시글 하나 증가
		count++;
	}
	//게시글 조회 기능
	public void displayBoard() {
		System.out.print("조회할 게시글 번호 : ");
		int num = scan.nextInt();
		if(num <= count) {
			//게시글 삭제여부를 확인해서 삭제된 게시글이면
			//삭제되었습니다라고 출력하고, 아니면 게시글 조회
			if(boardList[num-1] == null) {
				System.out.println("삭제된 게시글입니다.");
			}
			else {
				//조회수 증가
				boardList[num-1].updateViews();
				//게시글 조회
				boardList[num-1].print();
			}
		}
	}
	//게시글 수정 기능
	public void modifyBoard() {
		System.out.print("게시글 번호 : ");
		int num = scan.nextInt();
		if(boardList[num-1] == null) {
			System.out.println("삭제된 게시글은 수정할 수 없습니다.");
		}
		else {
			scan.nextLine();//게시글 번호에서 입력한 엔터 처리
			System.out.print("게시글 제목 : ");
			String title = scan.nextLine();
			System.out.print("게시글 내용 : ");
			String contents = scan.nextLine();
			if(num <= count) {
				boardList[num-1].modify(title, contents);
			}
		}
	}
	//게시글 삭제 기능
	public void deleteBoard() {
		System.out.print("게시글 번호 : ");
		int num = scan.nextInt();
		if(num <= count) {
			boardList[num-1] = null;
		}
	}
}
