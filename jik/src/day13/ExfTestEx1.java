package day13;

public class ExfTestEx1 {

	public static void main(String[] args) {
		/* 타원, 사각형을 같이 관리할 수 있는 배열을 만들고, 
		 * 타원1개, 사각형 2개를 만들어 저장한 후, 그리는 코드를 작성하세요. */
		ExfShape [] list = new ExfShape [3];
		list[0] = new ExfEllipse(0, 0, 10, 10);
		list[1] = new ExfRect(0, 0, 10, 10);
		list[2] = new ExfRect(10, 10, 20, 20);
		
		for(ExfShape tmp:list) {
			tmp.draw();
		}
	}
}

