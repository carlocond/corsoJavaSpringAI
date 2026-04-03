package com.azienda.recap.rubrica.service;

import com.azienda.recap.rubrica.exceptions.ContattoGiaPresenteException;
import com.azienda.recap.rubrica.exceptions.ContattoNonPresente;
import com.azienda.recap.rubrica.model.Contatto;
import com.azienda.recap.rubrica.model.Rubrica;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceRubrica {

    private final Rubrica rubrica;

    public ServiceRubrica(Rubrica rubrica){
        this.rubrica = rubrica;
    }

    //OPERAZIONI CRUD

    //CREATE
    public void creaContatto(Contatto contattoNuovo) throws ContattoGiaPresenteException {
        if (rubrica.getContatti().contains(contattoNuovo)){
            throw new ContattoGiaPresenteException("Il contatto e' gia presente in rubrica.");
        }
        rubrica.getContatti().add(contattoNuovo);
    }

    //READ
    public Contatto trovaContatto(String nome, String cognome) throws ContattoNonPresente {
        return rubrica.getContatti()
                .stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome) && c.getCognome().equalsIgnoreCase(c.getCognome()))
                .findFirst()
                .orElseThrow(() -> new ContattoNonPresente("Nessun contatto corrispondente ai dati forniti trovato"));
    }

    //UPDATE
    public void aggiornaContatto(String nome, String cognome, String nomeNuovo, String cognomeNuovo, String telNuovo) throws ContattoNonPresente, ContattoGiaPresenteException {
        Contatto daAggiornare = trovaContatto(nome, cognome);

        //Nel caso in cui, uno dei campi venga lasciato vuoto, allora quest'ultimo non subira' modifiche.
        nomeNuovo = (nomeNuovo == null) || (nomeNuovo.isEmpty()) ? daAggiornare.getNome() : nomeNuovo;
        cognomeNuovo = (cognomeNuovo == null) || (cognomeNuovo.isEmpty()) ? daAggiornare.getCognome() : cognomeNuovo;
        telNuovo = (telNuovo == null) || (telNuovo.isEmpty()) ? daAggiornare.getNumeroTel() : telNuovo;

        Contatto aggiornato = new Contatto(nomeNuovo, cognomeNuovo, telNuovo);

        //Verifica esistenza
        if (!daAggiornare.equals(aggiornato) && rubrica.getContatti().contains(aggiornato)){
            throw new ContattoGiaPresenteException("Il contatto aggiornato esiste gia'.");
        }

        //Aggiornamento definitivo
        daAggiornare.setNome(nomeNuovo);
        daAggiornare.setCognome(cognomeNuovo);
        daAggiornare.setNumeroTel(telNuovo);
    }

    //DELETE
    public void cancellaContatto(String nome, String cognome) throws ContattoNonPresente {
        Contatto daRimuovere = trovaContatto(nome, cognome);
        rubrica.getContatti().remove(daRimuovere);
    }

    //OPERAZIONI READ PER NOME, COGNOME, NUMERO

    public List<Contatto>  cercaPerNome(String nome) {
        return rubrica.getContatti()
                .stream()
                .filter(c -> c.getNome().toLowerCase().contains(nome))
                .collect(Collectors.toList());
    }

    public List<Contatto> cercaPerCognome (String cognome) {
        return rubrica.getContatti()
                .stream()
                .filter(c -> c.getCognome().toLowerCase().contains(cognome))
                .collect(Collectors.toList());
    }

    public List<Contatto> cercaPerNumeroTelefono (String numeroTelefono){
        return rubrica.getContatti()
                .stream()
                .filter(c -> c.getNumeroTel().toLowerCase().contains(numeroTelefono))
                .collect(Collectors.toList());
    }

    //OPERAZIONI READ ORDINATE INSERIMENTO, NOME, COGNOME

    public List<Contatto> ordinePerInserimento () {
        //Grazie all'utilizzo della LinkedList, la lista sara' gia in ordine di inserimento
        return new ArrayList<>(rubrica.getContatti());
    }

    public List<Contatto> ordinePerNome () {
        return rubrica.getContatti()
                .stream()
                .sorted(Comparator.comparing(c -> c.getNome().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Contatto> ordinePerCognome (){
        return rubrica.getContatti()
                .stream()
                .sorted(Comparator.comparing(c -> c.getCognome().toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Contatto> ordinePerCognomeNome (){
        //Ordina controllando prima il cognome e poi il nome
        return rubrica.getContatti()
                .stream()
                .sorted(Comparator.comparing((Contatto c) -> c.getCognome().toLowerCase()).thenComparing(c -> c.getNome().toLowerCase()))
                .collect(Collectors.toList());
    }


}
