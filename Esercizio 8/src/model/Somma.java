package model;

public class Somma extends AbstractOperazioni{

    @Override
    public int operate(int a, int b) {
        return a + b;
    }

    @Override
    String getOperazione() {
        return "somma";
    }
}
