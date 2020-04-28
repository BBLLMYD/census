package record.learn.design.decorator;

public class StringDisplay extends Dispaly{
	
	private String string;

	public StringDisplay(String string) {
		super();
		this.string = string;
	}

	@Override
	int getColumns() {
		return string.getBytes().length;
	}

	@Override
	int getRows() {
		return 1;
	}

	@Override
	String getRowText(int i) {
		if(i == 0){
			return string;
		}else{
			return null;
		}
		
	}
	
}
