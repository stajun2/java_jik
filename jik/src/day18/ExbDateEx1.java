package day18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExbDateEx1 {

	public static void main(String[] args) {
		/* Date클래스는 날짜 클래스 */
		Date date1 = new Date();
		System.out.println(date1);
		/* Date를 String으로 변환
		 * SimpleDateFormat을 이용하여 원하는 문자열 패턴으로 바꿈 
		 * y : 년도
		 * M : 월
		 * d : 일
		 * H : 시
		 * m : 분
		 * s : 초
		 * */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str1 = format.format(date1);
		System.out.println(str1);
		
		format = new SimpleDateFormat("yyyy년 MM월 dd일");
		String str2 = format.format(date1);
		System.out.println(str2);
		
		/* String을 Date로 */
		
		try {
			String strDate1 = "2021-11-13 10:08:10";
			format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date2 = format.parse(strDate1);
			System.out.println(date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
