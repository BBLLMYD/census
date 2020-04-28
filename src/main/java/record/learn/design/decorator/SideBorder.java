package record.learn.design.decorator;

public class SideBorder extends Border{

	private char borderchar;
	
	public SideBorder(Dispaly dispaly,char ch) {
		super(dispaly);
		this.borderchar = ch;
	}

	@Override
	int getColumns() {
		return 1+dispaly.getColumns()+1;
	}

	@Override
	int getRows() {
		return dispaly.getRows();
	}

	@Override
	String getRowText(int i) {
		return borderchar+dispaly.getRowText(i)+borderchar;
	}

}
