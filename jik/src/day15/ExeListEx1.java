package day15;

import java.util.ArrayList;
import java.util.List;

public class ExeListEx1 {

	public static void main(String[] args) {
		//정수를 저장하는 List를 만드는 예제
		List<Integer> list1 = new ArrayList<Integer>();
		int [] arr1 = new int[5];
		arr1[0] = 1;
		//add()는 리스트에 객체를 추가하는 기능
		list1.add(1);
		arr1[1] = 2;
		list1.add(2);
		System.out.println(arr1[0]);
		//get(index)은 index 번지에 있는 객체를 가져오는 기능 
		//get()은 list에만 있고, set은 없음
		System.out.println(list1.get(0));
		System.out.println("배열의 크기 : " + arr1.length);
		//size()는 저장된 갯수를 알려주는 기능
		System.out.println("리스트에 저장된 갯수 : " + list1.size());
		System.out.println(list1);
		//remove(Object obj) : obj와 일치하는 객체를 제거한후 제거한 객체를 알려 줌
		//remove(int index)  : index 번지에 있는 객체를 제거한후 제거한 객체를 알려 줌
		//remove(1)을 하면 1과 일치하는 객체를 제거하는게 아니라 1번지에 있는 개체를 제거
		list1.remove((Integer)1);
		System.out.println(list1);
		list1.add(5);
		list1.add(4);
		list1.add(10);
		System.out.println(list1);
		//contains : 리스트에 객체와 일치하는 객체가 있는지 없는지 알려주는 기능
		System.out.println("1이 리스트에 있나요? : " + list1.contains(1));
		System.out.println("5가 리스트에 있나요? : " + list1.contains(5));
		//indexOf : 리스트에 객체와 일치하는 객체가 있으면 번지를 없으면 -1을 알려주는 기능
		System.out.println("1이 리스트에 있나요? : " + list1.indexOf(1));
		System.out.println("5가 리스트에 있나요? : " + list1.indexOf(5));
	}

}
