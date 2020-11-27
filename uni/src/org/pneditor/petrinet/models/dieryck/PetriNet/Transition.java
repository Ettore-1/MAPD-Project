package org.pneditor.petrinet.models.dieryck.PetriNet;

import java.util.LinkedList;

public class Transition {
	
	private LinkedList<ArcBfr> arcsBefore;
	private LinkedList<ArcAft> arcsAfter;
	
	
	public Transition() {
		super();
	}
	
	public void addArc(Arc a) {
		if (a instanceof ArcBfr) {
			this.arcsBefore.add((ArcBfr) a);
		}
		else {
			this.arcsAfter.add((ArcAft) a);
		}
	}
	
	public boolean stepPossible() {
		for (int i = 0; i < arcsBefore.size(); i++) {
			if (!arcsBefore.get(i).isPullable()) return false;
		}
		return true;
	}
	
	public String step() {
		if (this.stepPossible()) {
			for (int i=0; i<arcsBefore.size();i++) {
				ArcBfr abef = this.arcsBefore.get(i);
				if (abef.getArrival() == this){
					if (abef instanceof ArcVideur) {
						abef.getDeparture().changeCoinValue(0);
					}
					if (abef instanceof ArcBfr) {
						abef.getDeparture().removeCoin(abef.getValue());
					}
				}
			}
			for (int i = 0; i < arcsAfter.size(); i++) {
				ArcAft aaft = this.arcsAfter.get(i);
				if (aaft.getDeparture() == this){
					aaft.getArrival().addCoin(aaft.getValue());
				}
			}
			return "Transition stepped with success";
		}
		else return "Transition impossible to realize";
	}
	
}
