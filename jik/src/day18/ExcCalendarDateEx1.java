package day18;

import java.util.Calendar;
import java.util.Date;

public class ExcCalendarDateEx1 {

	public static void main(String[] args) {
		/* Calendar를 Date로 */
		Calendar cal = Calendar.getInstance();
		
		Date date = new Date(cal.getTimeInMillis());
		System.out.println(date);
		
		/* Date를 Calendar로*/
		Date date2 = new Date();
		Calendar cal2 = Calendar.getInstance();
		//date2가 Calendar로 바뀐걸 구분할 수 있게 cal2의 년도를 2022로 수정
		cal2.set(Calendar.YEAR, 2022);
		cal2.setTime(date2);
		System.out.println(cal2);
	}

}
