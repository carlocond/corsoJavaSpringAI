package com.azienda.springcore.esercizio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.azienda.springcore.esercizio.model.Banca;
import com.azienda.springcore.esercizio.model.Indirizzo;

@Component("banca")
public class BancaImpl implements Banca {

    private String nome;
    private Indirizzo indirizzo;

    @Autowired
    public BancaImpl(@Qualifier("indirizzo") Indirizzo indirizzo) {
        this.nome = "Unicredit";
        this.indirizzo = indirizzo;
    }

    public BancaImpl(String nome, Indirizzo indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    @Override 
    public String getNome() { 
    	return nome; 
    }
    
    @Override 
    public void setNome(String nome) {
    	this.nome = nome; 
    }
    
    @Override 
    public Indirizzo getIndirizzo() { 
    	return indirizzo; 
    }
    
    @Override 
    public void setIndirizzo(Indirizzo indirizzo) {
    	this.indirizzo = indirizzo; 
    }

    @Override
    public String toString() {
        return "| Dettagli Banca |" + 
        		"\nNome: " + nome + 
        		"\nIndirizzo: " + indirizzo;
    }
}
