package day13;

public class ExaTestEx1 {

	public static void main(String[] args) {
		/* 도형을 그리는 기능을 Shape에 추상 메소드로 만든 경우와 그리는 기능을 
		 * Shape에서 제외한 클래스의 차이를 보여주는 예제
		 * 부모에 그리는 기능이 있으면, 다형성을 이용하여 조건없이(형변환 확인없이)
		 * 그리는 기능을 사용할 수 있지만,
		 * 부모에 그리는 기능이 없으면, 형변환 가능한지 확인하고, 형변환한 후 그리는
		 * 기능을 사용해야한다. 
		 * */
		ExaShape [] shapeList1 = new ExaShape[3];
		shapeList1[0] = new ExaEllipse();
		shapeList1[1] = new ExaRect();
		shapeList1[2] = new ExaRect();
		
		for(ExaShape tmp : shapeList1) {
			if(tmp != null) {
				tmp.print();
			}
		}
		System.out.println("----------");
		
		ExbShape [] shapeList2 = new ExbShape[3];
		shapeList2[0] = new ExbEllipse();
		shapeList2[1] = new ExbRect();
		shapeList2[2] = new ExbRect();
		
		for(ExbShape tmp : shapeList2) {
			//ExbShape에 print()가 없어서 에러 발생
			//tmp.print();
			//타원인 경우 형변환이 안되서 에러 발생
			//((ExbRect)tmp).print();
			if(tmp != null) {
				if(tmp instanceof ExbRect) {
					((ExbRect)tmp).print();
				}else if(tmp instanceof ExbEllipse) {
					((ExbEllipse)tmp).print();
				}
			}
		}
	}

}
