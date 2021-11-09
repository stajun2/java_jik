package day10;

public class Board {
	//게시글번호, 제목, 작성자, 조회수, 내용, 작성일 등
	private int num, views;
	private String title, contents, date, writer;
	
	public Board(int num, String title, String contents, String date, String writer) {
		this.num = num;
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.writer = writer;
	}
	//일반적으로 멤버변수를 변경만 하는 기능들은 리턴타입이 void
	//게시글 제목, 내용을 수정하는 기능 
	public void modify(String title, String contents) {
		this.title = title; this.contents = contents;
	}
	//게시글을 조회하는 기능(게시글 정보 출력)
	public void print() {
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + contents);
		System.out.println("작성자: " + writer);
		System.out.println("작성일: " + date);
		System.out.println("조회수: " + views);
	}
	//조회수 1증가하는 기능
	public void updateViews() {
		views++;
	}
}





