package state;

public class WaitingForPacketState implements CounterState {
	
	private String stateName = "WAITING_FOR_PACKET";

	@Override
	public void applyState(CounterContext counterContext) {
		counterContext.setCounterState(this);
	}

	@Override
	public String getStateName() {
		return this.stateName;
	}

}
