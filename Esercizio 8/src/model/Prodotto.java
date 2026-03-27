package model;

public class Prodotto extends AbstractOperazioni{

    @Override
    public int operate(int a, int b) {
        return a * b;
    }

    @Override
    String getOperazione() {
        return "prodotto";
    }
}
