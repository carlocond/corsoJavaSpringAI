package model;

public class Divisione implements OperazioniAritmetiche{

    @Override
    public int operate(int a, int b) {
        if (b == 0){
            return 0;
        }
        return a / b;
    }

    @Override
    public void printResult(int result) {
        System.out.println("Il quoziente di a e b: " + result);
    }
}
