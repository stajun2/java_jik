package day15;

import java.util.ArrayList;
import java.util.HashMap;

public class ExdGenericEx1 {

	public static void main(String[] args) {
		ExdData<Integer> data1 = new ExdData<Integer>(10);
		ExdData<Double> data2 = new ExdData<Double>(1.23);
		ExdData<Double> data3 = new ExdData<Double>(3.14);
		data1.print();
		data2.print();
		//if(data1 == data2) //에러 발생. 비교할 수 없어서
		if(data3 == data2) {
			System.out.println("비교 가능하고 같은 객체");
		}else {
			System.out.println("비교 가능하고 다른 객체");
		}
		//ExdData<String> data4;
		data2.test(data3);
		data2.test(data1);
	}
}
