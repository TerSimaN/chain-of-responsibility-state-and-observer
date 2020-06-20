package observer;

import state.CounterContext;

public interface Observable {
	public void startWatching(Observer observer);
	public void stopWatching(Observer observer);
	public void notifyObservers(CounterContext counterContext);
	public String getUpdate();
}
