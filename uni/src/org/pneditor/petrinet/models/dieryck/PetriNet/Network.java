package org.pneditor.petrinet.models.dieryck.PetriNet;

import java.util.LinkedList;

import org.pneditor.petrinet.models.dieryck.Interface.iNetwork;


public class Network implements iNetwork{
	
	private LinkedList<Transition> transitions;
	private LinkedList<Place> places;
	private LinkedList<ArcBfr> arcsBefore;
	private LinkedList<ArcAft> arcsAfter;
	
	public Network() {
		this.transitions = new LinkedList<Transition>();
		this.places = new LinkedList<Place>();
		this.arcsBefore = new LinkedList<ArcBfr>();
		this.arcsAfter = new LinkedList<ArcAft>();
	}
	
	public void addPlace(Place p) {
		this.places.add(p);
	}
//	public void addPlace() {
//		this.places.add(new Place());
//	}
	
//	public void addPlace(int coin_value) {
//		this.places.add(new Place(coin_value));
//	}

	public void removePlace(Place p) {
		this.places.remove(p);
	}
	
	public void addTransition(Transition t) {
		this.transitions.add(t);
	}
	
	public void removeTransition(Transition t) {
		this.transitions.remove(t);
	}
	
	public void addArc(Arc a) {
		if (a instanceof ArcBfr) {
			this.arcsBefore.add((ArcBfr) a);
			//((ArcBfr) a).getArrival().addArc(a);
		}
		else {
			this.arcsAfter.add((ArcAft) a);
			//((ArcAft) a).getDeparture().addArc(a);
		}
	}
	
//	public void addArc(boolean b, Place p, Transition t) {
//		if (b == true) {
//			this.arcsBefore.add(new ArcBfr(p, t));
//		}
//		else {
//			this.arcsAfter.add(new ArcAft(t, p));
//		}
//	}
//	
//	public void addArc(boolean b, Place p, Transition t, int i) {
//		if (b == true) {
//			this.arcsBefore.add(new ArcBfr(p, t, i));
//		}
//		else {
//			this.arcsAfter.add(new ArcAft(t, p, i));
//		}
//	}
	
//	public void addArcSpe(boolean b, Place p, Transition t) {
//		if (b == true) {
//			this.arcsBefore.add(new ArcZero(p, t));
//		}
//		else {
//			this.arcsBefore.add(new ArcVideur(p, t));
//		}
//	}
//	
//	public void addArcSpe(boolean b, Place p, Transition t, int i) {
//		if (b == true) {
//			this.arcsBefore.add(new ArcZero(p, t, i));
//		}
//		else {
//			this.arcsBefore.add(new ArcVideur(p, t, i));
//		}
//	}
	
	public void removeArc(Arc a) {
		if (a instanceof ArcAft) {
			this.arcsAfter.remove(a);
		}
		else {
			this.arcsBefore.remove(a);
		}
	}
	
	public void changeCoinValue(Place p, int i) {
		p.changeCoinValue(i);
	}
	
	public void changeArcValue(Arc a, int i) {
		a.changeArcValue(i);
	}
	
//	public String step1(Transition t) {
//		int notPossible = 0;
//		for (int i=0; i<this.arcsBefore.size();i++) {
//			if (this.arcsBefore.get(i).getArrival() == t){
//				if (this.arcsBefore.get(i) instanceof ArcZero) {
//					if (this.arcsBefore.get(i).getValue() != 0) {
//						notPossible += 1;
//					}
//				}
//				else {
//					if (this.arcsBefore.get(i).getValue() > this.arcsBefore.get(i).getDeparture().getValue()) {
//						notPossible += 1;
//					}
//				}	
//			}
//		}
//		if (notPossible != 0) {
//			return "Transition impossible à réaliser";
//		}
//		else {
//			for (int i=0; i<this.arcsBefore.size();i++) {
//				if (this.arcsBefore.get(i).getArrival() == t){
//					if (this.arcsBefore.get(i) instanceof ArcVideur) {
//						this.arcsBefore.get(i).getDeparture().changeCoinValue(0);
//					}
//					if (this.arcsBefore.get(i) instanceof ArcBfr) {
//						this.arcsBefore.get(i).getDeparture().removeCoin(this.arcsBefore.get(i).getValue());
//					}
//				}
//			}
//			for (int i=0; i<this.arcsAfter.size();i++) {
//				if (this.arcsAfter.get(i).getDeparture() == t){
//					this.arcsAfter.get(i).getArrival().addCoin(this.arcsAfter.get(i).getValue());
//				}
//			}
//			return " Tranistion réalisée avec succès";
//		}
//	}
	
	public LinkedList<Place> getPlace(){
		return this.places;
	}
	
	public LinkedList<Transition> getTransition(){
		return this.transitions;
	}
	
	public LinkedList<ArcBfr> getArcBfr(){
		return this.arcsBefore;
	}
	
	public LinkedList<ArcAft> getArcAft(){
		return this.arcsAfter;
	}

	public void stepTransition(Transition t) {
		t.step();
	}
	
	
}





























