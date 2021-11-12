package day13;

public interface ExdRemoteController {
	public void powerOn();
	public void powerOff();
}

interface ExdTvRemoteController extends ExdRemoteController{
	public void volumnUp();
	public void volumnDown();
	public void channelUp();
	public void channelDown();
	public void changeChannel(int num);
}
class ExdTvRemoteCon implements ExdTvRemoteController{
	
	private boolean power = false;	//TV전원 상태
	private int channel = 1;
	private int volumn = 0;
	private final int maxChannel;
	private final int maxVolumn;
	
	@Override
	public void powerOn() {
		power = true;
		System.out.println("전원이 켜졌습니다.");
	}
	@Override
	public void powerOff() {
		power = false;
		System.out.println("전원이 꺼졌습니다.");
	}

	@Override
	public void volumnUp() {
		//TV가 꺼져있으면 소리 올리지 마세요.
		if(!power) {
			return;
		}
		++volumn;
		volumn = volumn > maxVolumn ? maxVolumn : volumn;
		/*if(volumn > maxVolumn) {
			volumn = maxVolumn;
		}*/
		System.out.println("소리 : " + volumn);
	}

	@Override
	public void volumnDown() {
		if(!power) {
			return;
		}
		--volumn;
		volumn = volumn < 0 ? 0 : volumn;
		/*if(volumn < 0) {
			volumn = 0;
		}*/
		System.out.println("소리 : " + volumn);
	}

	@Override
	public void channelUp() {
		if(!power) {
			return;
		}
		++channel;
		channel = channel > maxChannel ? maxChannel : channel;
		System.out.println("채널 : " + channel);
	}
	@Override
	public void channelDown() {
		if(!power) {
			return;
		}
		--channel;
		channel = channel < 0 ? 0 : channel;
		System.out.println("채널 : " + channel);
	}
	@Override
	public void changeChannel(int num) {
		if(!power) {
			return;
		}
		channel = maxChannel < num ? maxChannel : num;
		System.out.println("채널 : " + channel);
	}
	public ExdTvRemoteCon(int maxVolumn, int maxChannel) {
		this.maxChannel = maxChannel;
		this.maxVolumn = maxVolumn;
	}
}
class ExdLGTvRemoteCon extends ExdTvRemoteCon{
	public final static String LOGO = "LG";
	public ExdLGTvRemoteCon(int maxVolumn, int maxChannel) {
		super(maxVolumn, maxChannel);
	}
}
class ExdSamSungTvRemoteCon extends ExdTvRemoteCon{
	public final static String LOGO = "SAMSUNG";
	public ExdSamSungTvRemoteCon(int maxVolumn, int maxChannel) {
		super(maxVolumn, maxChannel);
	}
}









