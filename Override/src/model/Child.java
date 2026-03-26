package model;

public class Child extends Parent {

    private String stringa3;
    private String stringa4;

    @Override
    public String getStringa3() {
        return stringa3;
    }

    @Override
    public void setStringa3(String stringa3) {
        this.stringa3 = stringa3;
    }

    public String getStringa4() {
        return stringa4;
    }

    public void setStringa4(String stringa4) {
        this.stringa4 = stringa4;
    }

    public String getParentStr3(){
        return super.getStringa3();
    }

    public void setParentStr3(String stringa3){
        super.setStringa3(stringa3);
    }

    @Override
    public String toString() {
        return "Il valore della stringa3 e': " + stringa3;
    }
}
