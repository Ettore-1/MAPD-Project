package org.pneditor.petrinet.models.dieryck.Interface;

import java.util.LinkedList;

import org.pneditor.petrinet.models.dieryck.PetriNet.*;

public interface iNetwork{
//	
//	/**
//	 * Add a new Place with value 1.
//	 *
//	 * @param 
//	 */
//	public void addPlace();
//	
//	/**
//	 * Add a new Place with value a.
//	 *
//	 * @param int a 
//	 */
//	public void addPlace(int a);
//	
	
	/**
	 * Add a place
	 * 
	 * @param Place p
	 */
	public void addPlace(Place p);
	
	/**
	 * Remove Place p.
	 *
	 * @param Place p
	 */
	public void removePlace(Place p);
	
	/**
	 * Add transition.
	 *
	 * @param Transition t
	 */
	public void addTransition(Transition t);
	
	/**
	 * Remove Transition t.
	 *
	 * @param Transition t
	 */
	public void removeTransition(Transition t);
//	
//	/**
//	 * Add Arc if b=true we have an ArcBfr otherwise an ArcAft with arcValue=1.
//	 *
//	 * @param boolean b, Place p, Transition t
//	 */
//	public void addArc(boolean b, Place p, Transition t);
//	
//	/**
//	 * Add Arc if b=true we have an ArcBfr otherwise an ArcAft with arcValue=i.
//	 *
//	 * @param boolean b, Place p, Transition t, int i
//	 */
//	public void addArc(boolean b, Place p, Transition t, int i);
//	
//	/**
//	 * Add Arc if b=true we have an ArcZero otherwise an ArcVideur.
//	 *
//	 * @param boolean b, Place p, Transition t
//	 */
//	public void addArcSpe(boolean b, Place p, Transition t);
//	
//	/**
//	 * Add Arc if b=true we have an ArcZero otherwise an ArcVideur with arcValue=1.
//	 *
//	 * @param boolean b, Place p, Transition t, int i
//	 */
//	public void addArcSpe(boolean b, Place p, Transition t, int i);
//	
	
	/**
	 * Add an Arc
	 * 
	 * @param Arc a
	 */
	public void addArc(Arc a);
	
	/**
	 * Remove Arc.
	 *
	 * @param Arc a
	 */
	public void removeArc(Arc a);
	
	/**
	 * CoinValue of Place p equal to i.
	 *
	 * @param Place p, int i
	 */
	public void changeCoinValue(Place p, int i);
	
	/**
	 * ArcValue of Arc a equal to i.
	 *
	 * @param Arc a, int i
	 */
	public void changeArcValue(Arc a, int i);
	
	/**
	 * Do a step above a transition if it is possible.
	 *
	 * @param Transition t
	 */
	public void stepTransition(Transition t);
	
	/**
	 * For Test
	 */
	public LinkedList<Place> getPlace();
	
	public LinkedList<Transition> getTransition();
	
	public LinkedList<ArcBfr> getArcBfr();
	
	public LinkedList<ArcAft> getArcAft();


}
