package com.azienda.utilityjdk.esempio5.utils;

import java.util.Comparator;

import com.azienda.utilityjdk.esempio5.model.Automobile;

public class AutomobileComparatorByCc implements Comparator<Automobile> {

	@Override
	public int compare(Automobile o1, Automobile o2) {
		if (o1.getCc() < o2.getCc()) {
			return -1;
		}
		
		if (o1.getCc() > o2.getCc()) {
			return 1;
		}
		
		return 0;
	}
	
	

}
