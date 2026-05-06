package com.azienda.esercizio1SpringData.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "profilo_id")
	private Profilo profilo;
	
	public Utente() {}
	
	public Utente(String username, String password, Profilo profilo) {
		this.username = username;
        this.password = password;
        this.profilo = profilo;
	}
	
	public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Profilo getProfilo() {
        return profilo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilo(Profilo profilo) {
        this.profilo = profilo;
    }

	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
    
}
