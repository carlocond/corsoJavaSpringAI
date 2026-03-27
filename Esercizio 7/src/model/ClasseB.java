package model;

import java.util.Objects;

public class ClasseB extends ClasseA{

    private String s;
    private float f;

    public ClasseB(String s, int i, float f){
        super(s, i);
        this.f = f;
    }

    @Override
    public String getS() {
        return s;
    }

    @Override
    public void setS(String s) {
        this.s = s;
    }

    public float getF() {
        return f;
    }

    public void setF(float f) {
        this.f = f;
    }

    public String getParentS(){
        return super.getS();
    }

    public void setParentS(String s){
        super.setS(s);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLa stringa s della classe b vale: " + s +
                "\nIl float f della classe b vale: " + f;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClasseB classeB = (ClasseB) o;
        return Float.compare(f, classeB.f) == 0 && Objects.equals(s, classeB.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), s, f);
    }


}
