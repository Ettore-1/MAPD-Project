package org.pneditor.petrinet.adapters.dieryck;

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.dieryck.PetriNet.Arc;
import org.pneditor.petrinet.models.dieryck.PetriNet.Transition;

public class TransitionAdapter extends AbstractTransition{
	
	private Transition t;
	
	public TransitionAdapter(String label, Transition t) {
		super(label);
		this.t = t;
	}
	
	public Transition getTransition() {
		return t;
	}
	
	public void addArc(Arc a) {
		t.addArc(a);
	}
}
