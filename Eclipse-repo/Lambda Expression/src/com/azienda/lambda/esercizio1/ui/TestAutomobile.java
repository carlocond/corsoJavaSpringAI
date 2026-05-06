package com.azienda.lambda.esercizio1.ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.azienda.lambda.esercizio1.model.Automobile;

public class TestAutomobile {

	public static void main(String[] args) {
		
		int chiaviPos = 1300; // cc > chiaviPos per chiavi positive
		int chiaviNeg = 1100; // cc < chiaviNeg per chiavi negative
		int indiceRandom;
		boolean menu = false;
		Random random = new Random();
		
		try (Scanner scanner = new Scanner(System.in)){
			
			Supplier<Map<Integer, Automobile>> supplierMappa = HashMap::new;
			Map<Integer, Automobile> mappaAuto = supplierMappa.get();
			
			while (!menu) {
				System.out.println("1. Inserisci automobile | 2. Stampa automobili | 0. Esci");
				int choice = scanner.nextInt();
				scanner.nextLine();
				
				switch (choice) {
					case 1:
						do {
							indiceRandom = random.nextInt(-100, 100);
						} while (indiceRandom == 0 || mappaAuto.containsKey(indiceRandom));
						
						System.out.println("Inserisci la marca: ");
						String marca = scanner.nextLine();
						System.out.println("Inserisci il modello: ");
						String modello = scanner.nextLine();
						System.out.println("Inserisci la cilindrata: ");
						int cc = scanner.nextInt();
						scanner.nextLine();
						
						System.out.println("Inserisci la data di immatricolazione: (GG:MM:AAAA)");
						String dataImmatricolazione = scanner.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
						
						LocalDate data = null;
						try {
							data = LocalDate.parse(dataImmatricolazione, formatter);
						} catch (DateTimeException e) {
							System.out.println("Formato non valido.");
							e.printStackTrace();
						}
						
						try {
							Automobile a = new Automobile(marca, modello, cc, data);
							mappaAuto.put(indiceRandom, a);
							System.out.println("Auto creata e aggiunta con successo.");
						} catch (Exception e) {
							System.out.println("Qualcosa e' andato storto.");
						}
						break;
					case 2:
						//Stampa punto1 tramite forEach
						System.out.println("=== PUNTO 1 ===");
						mappaAuto.forEach((k, v) -> System.out.println(k + " " + v));
						
						Predicate<Map.Entry<Integer, Automobile>> filtro = entry -> {
							int chiave = entry.getKey();
							Automobile auto = entry.getValue();
							
							boolean chiavePositiva = (chiave > 0) && (auto.getCc() > chiaviPos);
							boolean chiaveNegativa = (chiave < 0) && (auto.getCc() < chiaviNeg);
							
							return chiavePositiva || chiaveNegativa;
						};
						
						Map<Integer, Automobile> mappaAuto2 = mappaAuto.entrySet()
								.stream()
								.filter(filtro)
								.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
						
						System.out.println("=== MAPPA FILTRATA ===");
						mappaAuto2.forEach((k, v) -> System.out.println(k + " " + v));
						
						Function<Map.Entry<Integer, Automobile>, Automobile> entryAuto = Map.Entry::getValue;
						
						List<Automobile> listaAuto = mappaAuto2.entrySet()
								.stream().filter(e -> e.getKey() > 0)
								.map(entryAuto)
								.collect(Collectors.toList());
						
						System.out.println("=== SOLO CHIAVI POSITIVE ===");
						listaAuto.forEach(System.out::println);
						
						List<Automobile> listaAuto2 = mappaAuto.values()
								.stream()
								.sorted((a1, a2) -> Integer.compare(a1.getCc(), a2.getCc()))
								.collect(Collectors.toList());
						
						System.out.println("=== MAPPA ORDINATA PER CC ===");
						listaAuto2.forEach(System.out::println);
						break;
					case 0:
						System.out.println("Arrivederci");
						menu = true;
						break;
					default:
						System.out.println("Scelta non valida");
						break;
							
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
