package day6;

public class ArrayLengthEx1 {
	
	public static void main(String[] args) {
		int [] arr = new int [5];
		System.out.println("배열의 길이 : " + arr.length);
		int i;
		for(i = 0; i<arr.length; i++) {
			System.out.println("arr["+i+"] = " + arr[i]);
		}
	}
}
