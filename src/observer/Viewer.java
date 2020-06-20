package observer;

import state.CounterContext;
import state.CounterState;
import state.WaitingForPacketState;

public class Viewer implements Observer {
	
	private WaitingForPacketState waitingForPacket = new WaitingForPacketState();
	private CounterState counterState;
	private String currentCounterState;
	
	private String name;
	private Observable counter;
	
	public Viewer(String name) {
		this.setName(name);
	}

	@Override
	public void update(CounterContext counterContext) {
		if (counter == null) {
			System.out.println("No counter");
			return;
		}
		
		String counterDestination = counter.getUpdate();
		waitingForPacket.applyState(counterContext);
		counterState = counterContext.getCounterState();
		currentCounterState = counterState.getStateName();
		System.out.println(this.getName() + " updated with: " + "Destination is: " + counterDestination + ", CounterState changed to: " + currentCounterState);
	}

	@Override
	public void setCounter(Observable counter) {
		this.counter = counter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
