package record.learn.design.adtpter.b;

public class PrintBanner extends Print{

	private Banner banner;
	
	public PrintBanner(String str) {
		 banner = new Banner(str);
	}

	@Override
	public void printWeak() {
		banner.showWithAster();
	}

	@Override
	public void printStrong() {
		banner.showWithParen();
	}

}
