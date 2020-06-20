package chainofresponsibility;

import state.CounterContext;
import state.CounterState;
import state.PreparingPacketState;

public class PlovdivCityPacketSender extends PacketSender {
	private PreparingPacketState preparingPacket = new PreparingPacketState();
	private CounterState counterState;
	private String currentCounterState;
	
	public PlovdivCityPacketSender() {
		this.destination = PacketSender.PLOVDIV_CITY;
	}

	@Override
	protected void writePacketMessage(String packet, CounterContext counterContext) {
		preparingPacket.applyState(counterContext);
		counterState = counterContext.getCounterState();
		currentCounterState = counterState.getStateName();
		System.out.println("The packet \"" + packet + "\" is being prepared to be send to a destination in city Plovdiv.");
		System.out.println("PlovdivCityCounterState changed to: " + currentCounterState);
	}
}
