package chainofresponsibility;

import state.CounterContext;

public abstract class PacketSender {
	
	public static int FOREIGN_COUNTRY = 1;
	public static int HOME_COUNTRY = 2;
	public static int PLOVDIV_CITY = 3;
	
	protected int destination;
	
	protected PacketSender nextPacketSender;
	
	public void setNextPacketSender(PacketSender nextPacketSender) {
		this.nextPacketSender = nextPacketSender;
	}
	
	public void registerPacket(int destination, String packet, CounterContext counterContext) {
		
		if (this.destination <= destination) {
			this.writePacketMessage(packet, counterContext);
			return;
		}
		
		if (this.nextPacketSender != null) {
			this.nextPacketSender.registerPacket(destination, packet, counterContext);
		}
	}
	
	abstract protected void writePacketMessage(String packet, CounterContext counterContext);
}
