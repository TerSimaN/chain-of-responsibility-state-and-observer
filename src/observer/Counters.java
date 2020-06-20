package observer;

import java.util.ArrayList;
import java.util.List;

import state.CounterContext;

public class Counters implements Observable {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private String destination;
	
	public void setDestination(String destination, CounterContext counterContext) {
		this.destination = destination;
		this.notifyObservers(counterContext);
	}

	@Override
	public void startWatching(Observer observer) {
		observers.add(observer);
		observer.setCounter(this);
	}

	@Override
	public void stopWatching(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(CounterContext counterContext) {
		for (Observer observer : observers) {
			observer.update(counterContext);
		}
	}

	@Override
	public String getUpdate() {
		return this.destination;
	}

}
