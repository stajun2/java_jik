package day14;

import java.io.FileNotFoundException;

public class ExdThrowEx1 {

	public static void main(String[] args) {
		
		//Exception은 RuntimeException의 자손 클래스가 아니기 때문에
		//예외를 발생시키면 반드시 예외처리를 해야함
		//throw new Exception("예외 발생");
		//throw new RuntimeException("런타임 예외 발생");
		//thorwException();
		try {
			//thorwException2();
			thorwException3(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void thorwException() {
		throw new RuntimeException();
	}
	public static void thorwException2() throws Exception {
		throw new Exception();
	}
	public static void thorwException3(int num) 
			throws FileNotFoundException, Exception {
		if(num == 0) {
			throw new Exception("num가 0");
		}
		if(num < 0) {
			throw new FileNotFoundException("num는 음수");
		}
		if(num > 0) {
			throw new ArithmeticException("num는 양수");
		}
	}
}
