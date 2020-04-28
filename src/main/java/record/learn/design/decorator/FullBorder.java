package record.learn.design.decorator;

public class FullBorder extends Border{

	public FullBorder(Dispaly dispaly) {
		super(dispaly);
	}

	@Override
	int getColumns() {
		return 1+dispaly.getColumns()+1;
	}

	@Override
	int getRows() {
		return 1+dispaly.getRows()+1;
	}

	@Override
	String getRowText(int i) {
		if(i ==0 ){
			return "+"+makeLine('-',dispaly.getColumns())+"+";
		}else if(i == dispaly.getRows()+1){
			return "+"+makeLine('-',dispaly.getColumns())+"+";
		}else{
			return "|"+dispaly.getRowText(i-1)+"|";
		}
	}

	private String makeLine(char c, int columns) {
		StringBuilder sb = new StringBuilder();
		for(int i=0 ;i<columns; i++){
			sb.append(c);
		}
		return sb.toString();
	}

}
