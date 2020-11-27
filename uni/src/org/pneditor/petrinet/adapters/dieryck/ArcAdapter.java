package org.pneditor.petrinet.adapters.dieryck;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.dieryck.PetriNet.Arc;
import org.pneditor.petrinet.models.dieryck.PetriNet.ArcAft;
import org.pneditor.petrinet.models.dieryck.PetriNet.ArcBfr;
import org.pneditor.petrinet.models.dieryck.PetriNet.ArcZero;
import org.pneditor.petrinet.models.dieryck.PetriNet.ArcVideur;
import org.pneditor.petrinet.models.dieryck.PetriNet.Place;
import org.pneditor.petrinet.models.dieryck.PetriNet.Transition;

public class ArcAdapter extends AbstractArc{

	private Arc a;
	
	public ArcAdapter(Arc a) {
		this.a = a;
	}

	@Override
	public AbstractNode getSource() {
		if (a instanceof ArcBfr) {
			Place p =  a.getPlace();
			 
			return new PlaceAdapter("o", p);
		}
		else {
			Transition t = a.getTransition();
			return new TransitionAdapter("t", t);
		}
	}

	@Override
	public AbstractNode getDestination() {
		if (a instanceof ArcBfr) {
			Transition t =  a.getTransition();
			 
			return new TransitionAdapter("t", t);
		}
		else {
			Place p = a.getPlace();
			return new PlaceAdapter("o", p);
		}
	}

	@Override
	public boolean isReset() {
		return (a instanceof ArcVideur);
	}

	@Override
	public boolean isRegular() {
		return ((a instanceof ArcBfr) || (a instanceof ArcAft));
	}

	@Override
	public boolean isInhibitory() {
		return (a instanceof ArcZero);
	}

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		return a.getValue();
	}

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		a.changeArcValue(multiplicity);
		
	}
	
	public Arc getArc() {
		return a;
	}

}
