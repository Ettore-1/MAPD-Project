package org.pneditor.petrinet.adapters.dieryck;

import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.models.dieryck.PetriNet.Place;

public class PlaceAdapter extends AbstractPlace{

	private Place p;
	
	public PlaceAdapter(String label, Place p) {
		super(label);
		this.p = p;
	}

	@Override
	public void addToken() {
		p.addCoin(1);
	}

	@Override
	public void removeToken() {
		p.removeCoin(1);
	}

	@Override
	public int getTokens() {
		return p.getValue();
	}

	@Override
	public void setTokens(int tokens) {
		p.changeCoinValue(tokens);
	}
	
	public Place getPlace() {
		return p;
	}
}
