package state;

public class PreparingPacketState implements CounterState {
	
	private String stateName = "PREPARING_PACKET";

	@Override
	public void applyState(CounterContext counterContext) {
		counterContext.setCounterState(this);
	}

	@Override
	public String getStateName() {
		return this.stateName;
	}

}
