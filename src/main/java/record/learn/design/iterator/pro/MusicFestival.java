package record.learn.design.iterator.pro;

import java.util.ArrayList;
import java.util.List;

import census.dp.sj1.iterator.Aggregate;
import census.dp.sj1.iterator.Iterator;

/**
 * 音乐节
 *
 * @author: mqw   
 * @date:   2018年5月15日 下午12:55:26
 */
public class MusicFestival implements Aggregate{

	private List<Stage> stages;
	private int last = 0;
	
	@Override
	public Iterator iterator() {
		return new MusicFestivalIterator(this);
	}

	public void addStage(Stage stage){
		stages.add(stage);
		last++;
	}
	
	public int getSize(){
		return last;
	}
	
	public Stage getStageAt(int index){
		return stages.get(index);
	}
	
	public MusicFestival(int maxSize){
		stages = new ArrayList<Stage>(maxSize);
	}
	
}
