package main;

import chainofresponsibility.ForeignCountryPacketSender;
import chainofresponsibility.HomeCountryPacketSender;
import chainofresponsibility.PacketSender;
import chainofresponsibility.PlovdivCityPacketSender;
import observer.Counters;
import observer.Observer;
import observer.Viewer;
import state.CounterContext;
import state.WaitingForPacketState;

public class Main {
	
	private static PacketSender getChain() {
		PacketSender foreignCountryPacketSender = new ForeignCountryPacketSender();
		PacketSender homeCountryPacketSender = new HomeCountryPacketSender();
		PacketSender plovdivCityPacketSender = new PlovdivCityPacketSender();
		
		plovdivCityPacketSender.setNextPacketSender(homeCountryPacketSender);
		homeCountryPacketSender.setNextPacketSender(foreignCountryPacketSender);
		return plovdivCityPacketSender;
	}

	public static void main(String[] args) {
		
		CounterContext foreignCountryCounter = new CounterContext("Foreign Country");
		CounterContext homeCountryCounter = new CounterContext("Home Country");
		CounterContext plovdivCityCounter = new CounterContext("City Plovdiv");
		
		WaitingForPacketState waitingForPacket = new WaitingForPacketState();
		
		PacketSender senderChain = getChain();
		
		Counters counters = new Counters();
		Observer boy = new Viewer("Watching Boy");
		
		counters.startWatching(boy);
		
		waitingForPacket.applyState(foreignCountryCounter);
		waitingForPacket.applyState(homeCountryCounter);
		waitingForPacket.applyState(plovdivCityCounter);
		
		senderChain.registerPacket(1, "First Packet", foreignCountryCounter);
		senderChain.registerPacket(2, "Second Packet", homeCountryCounter);
		senderChain.registerPacket(3, "Third Packet", plovdivCityCounter);
		
		counters.setDestination(foreignCountryCounter.getName(), foreignCountryCounter);
		counters.setDestination(homeCountryCounter.getName(), homeCountryCounter);
		counters.setDestination(plovdivCityCounter.getName(), plovdivCityCounter);
	}

}
