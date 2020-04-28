package record.learn.design.adtpter.a;
/**
 * Adapter(适配器)
 *
 * @author: mqw   
 * @date:   2018年5月16日 上午10:16:24
 */
public class PrintBanner extends Banner implements Print{

	public PrintBanner(String str) {
		super(str);
	}

	@Override
	public void printWeak() {
		showWithParen();
	}

	@Override
	public void printStrong() {
		showWithAster();
	}

}
