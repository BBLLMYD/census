package record.learn.design.iterator.pro;

import census.dp.sj1.iterator.Iterator;

public class MusicFestivalIterator implements Iterator{

	MusicFestival musicFestival;
	private int index;
	
	public MusicFestivalIterator(MusicFestival musicFestival){
		this.musicFestival = musicFestival;
		index = 0;
	}
	
	@Override
	public boolean hasNext() {
		if(index < musicFestival.getSize()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Stage next() {
		Stage stage = musicFestival.getStageAt(index);
		index++;
		return stage;
	}

}
