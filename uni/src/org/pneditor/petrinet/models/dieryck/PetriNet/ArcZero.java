package org.pneditor.petrinet.models.dieryck.PetriNet;

public class ArcZero extends ArcBfr{

	public ArcZero(Place p, Transition t) {
		super(p, t);
		
	}
	
	public ArcZero(Place p, Transition t, int value) {
		super(p, t, value);
		
	}
	
	public boolean isPullable() {
		if (this.getValue() == 0) return true;
		else return false;
	}
	
}
