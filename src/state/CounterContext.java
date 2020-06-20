package state;

public class CounterContext {
	
	private String name;
	private CounterState counterState;
	
	public CounterContext(String name) {
		this.setName(name);
	}

	public CounterState getCounterState() {
		return counterState;
	}

	public void setCounterState(CounterState counterState) {
		this.counterState = counterState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
