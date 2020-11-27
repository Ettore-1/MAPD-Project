package org.pneditor.petrinet.models.dieryck.PetriNet;

public class ArcAft extends Arc{
	
	private Transition transitionOut;
	private Place placeIn;
	
	public ArcAft(Transition transitionOut, Place placeIn) {
		super(placeIn, transitionOut);
	}
	
	public ArcAft(Transition t, Place p, int value) {
		super(p, t, value);
		this.placeIn = p;
		this.transitionOut = t;
	}
	
	public Transition getDeparture() {
		return this.transitionOut;
	}
	
	public Place getArrival() {
		return this.placeIn;
	}

}
