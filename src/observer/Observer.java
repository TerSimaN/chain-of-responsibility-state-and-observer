package observer;

import state.CounterContext;

public interface Observer {
	public void update(CounterContext counterContext);
	public void setCounter(Observable counter);
}
