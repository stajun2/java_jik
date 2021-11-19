package day18;

import java.util.*;

public class ExeAnonymousEx1 {

	public static void main(String[] args) {
		/* 주어진 리스트를 오른차순, 내림차순을 해보세요.*/
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(15);
		list.add(11);
		list.add(1);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);//오름차순
		/* 아래 sort는 정수형 리스트와 Comparator 인터페이스를 구현한 구현 
		 * 클래스의 객체가 필요
		 * */
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		System.out.println(list);
		
		List<String> strList = new ArrayList<String>();
		strList.add("an");
		strList.add("apple");
		strList.add("orange");
		strList.add("banana");
		Collections.sort(strList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(strList);
	}
}
