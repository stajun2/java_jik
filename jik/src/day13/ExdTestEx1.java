package day13;

public class ExdTestEx1 {
	public static void main(String[] args) {
		ExdLGTvRemoteCon lgR = new ExdLGTvRemoteCon(30, 900);
		lgR.volumnUp();
		lgR.powerOn();
		for(int i = 1; i <= 31; i++) {
			lgR.volumnUp();
		}
		for(int i = 1; i <= 32; i++) {
			lgR.volumnDown();
		}
		System.out.println(lgR.LOGO);
		lgR.changeChannel(901);
		lgR.powerOff();
	}
}
