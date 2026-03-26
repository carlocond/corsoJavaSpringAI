package model;

import java.util.Objects;

public class Impiegato extends Persona{

    private String matricola;

    public Impiegato(String nome, String cognome, String matricola){
        super(nome, cognome);
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nImpiegato{" +
                "matricola='" + matricola + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Impiegato i = (Impiegato) o;
        return Objects.equals(matricola, i.matricola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), matricola);
    }
}
