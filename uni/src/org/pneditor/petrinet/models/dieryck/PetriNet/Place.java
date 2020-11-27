package org.pneditor.petrinet.models.dieryck.PetriNet;

public class Place {
	
private int coinValue;
	
	public Place() {
		this.coinValue = 0;
	}
	
	public Place(int value){
		if (value>0) {
			this.coinValue = value;
		}
		else {
			this.coinValue = 0;
		}
	}
	
	public void addCoin(int value) {
		if (value>0) {
			this.coinValue = this.coinValue + value;
		}
	}
	
	public void removeCoin(int value) {
		if (value<this.coinValue) {
			this.coinValue = this.coinValue - value;
		}
	}
	
	public void changeCoinValue(int value) {
		if (value>=0) {
			this.coinValue = value;
		}
	}
	
	public int getValue() {
		return this.coinValue;
	}
	
}