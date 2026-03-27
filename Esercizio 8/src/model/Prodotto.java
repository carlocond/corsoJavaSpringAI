package model;

public class Prodotto implements OperazioniAritmetiche{
    @Override
    public int operate(int a, int b) {
        return a * b;
    }

    @Override
    public void printResult(int result) {
        System.out.println("Il prodotto di a e b: " + result);
    }
}
