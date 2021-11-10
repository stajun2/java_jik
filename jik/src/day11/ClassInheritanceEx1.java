package day11;

public class ClassInheritanceEx1 {

	public static void main(String[] args) {
		Square s1 = new Square();
		s1.print();
		Point p = new Point(10,10);
		Square s2 = new Square(p, 5);
		s2.print();
		p.move(20, 20);
		s2.print();
		s2.resize(10);
		s2.print();
	}

}
