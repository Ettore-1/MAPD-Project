package org.pneditor.petrinet.models.dieryck.PetriNet;

public class ArcVideur extends ArcBfr {

	public ArcVideur(Place p, Transition t) {
		super(p, t);
		
	}
	
	public ArcVideur(Place p, Transition t, int value) {
		super(p, t, value);
		
	}
	
	public boolean isPullable() {
		if (this.getValue() >= 1) return true;
		else return false;
	}
	
}
