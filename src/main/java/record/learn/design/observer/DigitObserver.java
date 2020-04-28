package record.learn.design.observer;


public class DigitObserver implements Observer{

	@Override
	public void update(Numbergenerator numbergenerator) {
		System.out.println("DigitObserver:"+numbergenerator.getNumber());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
