package chainofresponsibility;

import state.CounterContext;
import state.CounterState;
import state.PreparingPacketState;

public class ForeignCountryPacketSender extends PacketSender {
	private PreparingPacketState preparingPacket = new PreparingPacketState();
	private CounterState counterState;
	private String currentCounterState;
	
	public ForeignCountryPacketSender() {
		this.destination = PacketSender.FOREIGN_COUNTRY;
	}

	@Override
	protected void writePacketMessage(String packet, CounterContext counterContext) {
		preparingPacket.applyState(counterContext);
		counterState = counterContext.getCounterState();
		currentCounterState = counterState.getStateName();
		System.out.println("The packet \"" + packet + "\" is being prepared to be send to a destination in foreign country.");
		System.out.println("ForeignCountryCounterState changed to: " + currentCounterState);
	}
}
