package record.learn.design.iterator.pro;

import census.dp.sj1.iterator.Iterator;

public class Main {

	public static void main(String[] args) {
		MusicFestival musicFestival = new MusicFestival(9);
		musicFestival.addStage(new Stage("草莓"));
		musicFestival.addStage(new Stage("爱"));
		musicFestival.addStage(new Stage("嘻哈"));
		musicFestival.addStage(new Stage("后摇"));
		Iterator iterator = musicFestival.iterator();
		while(iterator.hasNext()){
			Stage stage = (Stage)iterator.next();
			System.out.println(stage.getName());
		}
	}
	
}
