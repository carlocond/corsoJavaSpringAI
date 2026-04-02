package com.azienda.utilityjdk.esempio2.ui;

public class TestArray2 {

	public static void main(String[] args) {
		
		try {
			String[][] nomi = new String[3][2];
			nomi[0][1] = "Mario";
			nomi[1][0] = "Laura";
			nomi[2][0] = "Giovanna";
			nomi[2][1] = "Francesca";
			
			for(int i = 0; i < nomi.length; i++) {
				//String[] riga = nomi[i];
				for(int j = 0; j < nomi[i].length; j++) {
					System.out.print(nomi[i][j] + " ");
				}
				System.out.println();
			}
			
			String[][] nomi2 = {{null, "Mario"},
								{"Laura", null},
								{"Giovanna", "Francesca"}};
			
			for(String[] riga : nomi2) {
				for(String colonna : riga) {
					System.out.print(colonna + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
