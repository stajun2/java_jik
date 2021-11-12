package day13;

/* 도형 크기 변경, 도형 이동, 도형그리기 기능을 가진 ExfDraw인터페이스를 만드세요. */
public interface ExfDraw {
	
	public void resize(int width, int height);
	
	public void move(int x, int y);
	
	public void draw();
}
