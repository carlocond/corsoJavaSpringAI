package com.azienda.interfacce.esempio9.ui;

import com.azienda.interfacce.esempio9.model.Concreta1;
import com.azienda.interfacce.esempio9.model.Concreta2;
import com.azienda.interfacce.esempio9.model.EsempioAstratta;

public class TestAstratta {

	public static void main(String[] args) {
		
		EsempioAstratta ref = new Concreta1();
		
		ref.metodoAstratto();
		ref.metodoConcreto();
		if(ref instanceof Concreta1) {
			((Concreta1) ref).specifico1();
		}
		
		ref = new Concreta2();
		ref.metodoAstratto();
		ref.metodoConcreto();
		if(ref instanceof Concreta2) {
			((Concreta2) ref).specifico2();
		}
	}

}
