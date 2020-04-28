package record.learn.design.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Numbergenerator {

	private List<Observer> observers = new ArrayList<>();
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	public void delObserver(Observer observer){
		observers.remove(observer);
	}
	public void notifyObserver(){
		Iterator<Observer> iterator = observers.iterator();
		while(iterator.hasNext()){
			Observer next = iterator.next();
			next.update(this);
		}
	}
	protected abstract int getNumber();
	protected abstract void execute();
}
