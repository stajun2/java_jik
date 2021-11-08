package day9;

import java.util.Scanner;

public class ClassEx1 {

	public static void main(String[] args) {
		Car car1 = new Car(4,"현대","소형");
		car1.brand="기아";
		System.out.println("브랜드 : " + car1.brand);
		car1.turnOn();
		//객체 멤버 변수는 값을 공유하지 않음
		Car car2 = new Car(6, "기아", "SUV");
		System.out.println("브랜드 : " + car2.brand);
		Car car3 = car1;
		System.out.println("브랜드 : " + car3.brand);
		car3.type = "대형";
		System.out.println("차종 : " + car1.type);
		System.out.println(car1.count + "인승");
		//기본 생성자를 제공하지 않은 Scanner 클래스
		//Scanner scan = new Scanner();
	}
}

class Car{
	//자동차와 관련된 정보들 => 멤버 변수
	String brand;	//기아, 현대 등
	String type;	//소형차, SUV, 대형 등
	int count;		//최대 탑승 인원
	int power;		//시동
	int speed;		//속력
	//자동차와 관련된 기능들 => 멤버 메소드
	//시동 켜는 기능
	void turnOn() {
		System.out.println("켰습니다.");
	}
	//시동 끄는 기능
	void turnOff() {
		System.out.println("껐습니다.");
	}
	//Car(){}//생성자가 하나도 없으면 이 코드가 생성이 됨
	Car(){
		count = 1;
		brand = "";
		type = "소형";
	}
	Car(int count1, String brand1, String type1){
		count = count1;
		brand = brand1;
		type = type1;
	}
}




