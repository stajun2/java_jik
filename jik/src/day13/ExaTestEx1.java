package day13;

public class ExaTestEx1 {

	public static void main(String[] args) {
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
