package model;

import java.util.Objects;

public class ClasseA {

    private String s;
    private int i;

    public ClasseA(String s, int i){
        this.s = s;
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }


    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "La stringa s vale: " + s +
                "\nL'intero i vale: " + i;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ClasseA classeA = (ClasseA) o;
        return i == classeA.i && Objects.equals(s, classeA.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, i);
    }
}
