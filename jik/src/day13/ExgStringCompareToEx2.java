package day13;

public class ExgStringCompareToEx2 {

	public static void main(String[] args) {
		/* 문자열 4개를 한곳에서 관리할 수 있게 배열을 만드세요. */
		String [] list = new String [4];
		/* 배열에 b d a c 순으로 저장하세요. */
		list[0] = "b"; list[1] = "d"; list[2] = "a"; list[3] = "c";
		
		/* 반복문과 compareTo를 이용하여 사전순으로 정렬해보세요. */
		
		for(int i = 0; i<list.length - 1; i++) {
			for(int j = 0; j<list.length - 1 - i ; j++) {
				if(list[j].compareTo(list[j+1]) > 0) {
					String tmp = list[j];
					list[j] = list[j+1];
					list[j+1] = tmp;
				}
			}
		}
		for(String tmp : list) {
			System.out.print(tmp + " ");
		}
	}

}
