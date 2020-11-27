package org.pneditor.petrinet.models.dieryck.PetriNet;

public class Arc {
	
	protected int arcValue;
	protected Place place;
	protected Transition t;
	
	public Arc(Place place, Transition t) {
		this.arcValue = 1;
		this.place = place;
		this.t = t;
	}
	
	public Arc(Place place, Transition t, int value) {
		if (value>1) {
			this.arcValue = value;
		}
		else {
			this.arcValue = 1;
		}

		this.place = place;
		this.t = t;
	}
	
	public void changeArcValue(int value) {
		if (value > 0) {
			this.arcValue = value;
		}
	}
	
	public int getValue() {
		return this.arcValue;
	}
	
	public Place getPlace() {
		return place;
	}
	
	public Transition getTransition() {
		return t;
	}
}
