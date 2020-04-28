package record.learn.effective._8equalsmethod;

public class EqualsTest {

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	protected EqualsTest clone() throws CloneNotSupportedException {
		return null;
	}
	
}
