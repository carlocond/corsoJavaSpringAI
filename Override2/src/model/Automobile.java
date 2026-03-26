package model;

import java.util.Objects;

public class Automobile {

    private String modello;
    private int anno;
    private int matricola;
    private Persona proprietario;

    public Automobile(String modello, int anno, int matricola, Persona proprietario) {
        this.modello = modello;
        this.anno = anno;
        this.matricola = matricola;
        this.proprietario = proprietario;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public Persona getProprietario() {
        return proprietario;
    }

    public void setProprietario(Persona proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "modello='" + modello + '\'' +
                ", anno=" + anno +
                ", matricola=" + matricola +
                ", proprietario=" + proprietario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Automobile that = (Automobile) o;
        return anno == that.anno && matricola == that.matricola && Objects.equals(modello, that.modello) && Objects.equals(proprietario, that.proprietario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modello, anno, matricola, proprietario);
    }
}
