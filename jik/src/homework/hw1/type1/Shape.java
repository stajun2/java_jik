package homework.hw1.type1;

public abstract class Shape implements Draw {
	
	protected int left, top;		
	protected int right, bottom;	
	
	public Shape(int x1, int y1, int x2, int y2) {
		left  = x1 < x2 ? x1 : x2;
		right = x1 < x2 ? x2 : x1;
		top   = y1 < y2 ? y1 : y2;
		bottom= y1 < y2 ? y2 : y1;
	}

	public int getWidth() {
		return right - left;
	}
	public int getHeight() {
		return bottom - top;
	}

	public void move(int left, int top) {
		this.right  = left + getWidth();
		this.bottom = top  + getHeight();
		this.left   = left;
		this.top    = top;
	}
	public void resize(int width, int height, int direction) {
		if(width <= 0 || height <= 0) {
			System.out.println("잘못된 너비 또는 높이입니다.");
			return ;
		}
		switch(direction) {
		case 1:
			right = left   + width;
			bottom= top    + height;
			break;
		case 2:
			left  = right  - width;
			bottom= top    + height;
			break;
		case 3:
			left  = right  - width;
			top   = bottom - height;
			break;
		case 4:
			right = left   + width;
			top   = bottom - height;
			break;
		default:
			System.out.println("잘못된 방향입니다.");
		}
	}
	
}





