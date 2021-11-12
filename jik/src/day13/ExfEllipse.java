package day13;

public class ExfEllipse extends ExfShape {
	public ExfEllipse(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}
	@Override
	public void draw() {
		System.out.println("타원");
	}
	
}
