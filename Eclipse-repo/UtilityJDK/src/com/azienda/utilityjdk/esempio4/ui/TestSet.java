package com.azienda.utilityjdk.esempio4.ui;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		
		try {
			Set<String> nomi = new HashSet<String>();
			nomi.add("Mario");
			nomi.add("Mario");
			nomi.add("Giovanni");
			nomi.add("Laura");
			nomi.add("Claudia");
			System.out.println(nomi.size());
			boolean b = nomi.contains("Laura");
			boolean c = nomi.contains("laura");
			nomi.remove("laura");
			nomi.remove("Laura");
			for(String res : nomi) {
				System.out.println(res);
			}
			Iterator<String> it = nomi.iterator();
			while(it.hasNext()) {
				String item = it.next();
				System.out.println(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
