package org.pneditor.petrinet.adapters.dieryck;
import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.dieryck.PetriNet.ArcAft;
import org.pneditor.petrinet.models.dieryck.PetriNet.ArcBfr;
import org.pneditor.petrinet.models.dieryck.PetriNet.ArcVideur;
import org.pneditor.petrinet.models.dieryck.PetriNet.ArcZero;
import org.pneditor.petrinet.models.dieryck.PetriNet.Network;
import org.pneditor.petrinet.models.dieryck.PetriNet.Place;
import org.pneditor.petrinet.models.dieryck.PetriNet.Transition;

public class PetriNetAdapter extends PetriNetInterface{
	
	private Network petrinet;
	
	public PetriNetAdapter() {

		this.petrinet = new Network();
	}

	@Override
	public AbstractPlace addPlace() {
		Place p = new Place();
		petrinet.addPlace(p);
		return new PlaceAdapter("p", p);
	}

	@Override
	public AbstractTransition addTransition() {
		Transition t = new Transition();
		petrinet.addTransition(t);
		return new TransitionAdapter("t", t);
	}

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		if (source.isPlace()) {
			ArcBfr a = new ArcBfr(((PlaceAdapter) source).getPlace(), ((TransitionAdapter) destination).getTransition(), 1);
			petrinet.addArc(a);
			return new ArcAdapter(a);
		}
		else {
			ArcAft a = new ArcAft( ((TransitionAdapter) source).getTransition(), ((PlaceAdapter) destination).getPlace(), 1);
			petrinet.addArc(a);
			return new ArcAdapter(a);
		}
	}

	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		ArcZero a = new ArcZero(((PlaceAdapter) place).getPlace(), ((TransitionAdapter) transition).getTransition());
		petrinet.addArc(a);
		return new ArcAdapter(a);
	}

	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		ArcVideur a = new ArcVideur(((PlaceAdapter) place).getPlace(), ((TransitionAdapter) transition).getTransition());
		petrinet.addArc(a);
		return new ArcAdapter(a);
	}

	@Override
	public void removePlace(AbstractPlace place) {
		petrinet.removePlace(((PlaceAdapter) place).getPlace());
		
	}

	@Override
	public void removeTransition(AbstractTransition transition) {
		petrinet.removeTransition(((TransitionAdapter) transition).getTransition());
		
	}

	@Override
	public void removeArc(AbstractArc arc) {
		petrinet.removeArc(((ArcAdapter) arc).getArc());
		
	}

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		return ((TransitionAdapter) transition).getTransition().stepPossible();
	}

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		petrinet.stepTransition(((TransitionAdapter) transition).getTransition());
	}
	
	
}
