package org.pneditor.petrinet.models.dieryck.PetriNet;

public class ArcBfr extends Arc{
	
	protected Place placeOut;
	private Transition transitionIn;
	
	public ArcBfr(Place p, Transition t) {
		super(p, t);
		this.placeOut = p;
		this.transitionIn = t;
	}
	
	public ArcBfr(Place p, Transition t, int value) {
		super(p, t, value);
		this.placeOut = p;
		this.transitionIn = t;
	}

	public Place getDeparture() {
		return this.placeOut;
	}
	
	public Transition getArrival() {
		return this.transitionIn;
	}
	
	public boolean isPullable() {
		int a = placeOut.getValue();
		int b = this.getValue();
		if (a <= b) return true;
		else return false;
	}
	
	
}
