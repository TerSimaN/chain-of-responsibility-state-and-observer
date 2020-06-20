package state;

public interface CounterState {
	public void applyState(CounterContext counterContext);
	public String getStateName();
}
