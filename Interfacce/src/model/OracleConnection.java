package model;

public class OracleConnection implements DBConnection{

    @Override
    public void open() {
        System.out.println("Oracle OpenConnection");
    }

    @Override
    public void close() {
        System.out.println("Oracle CloseConnection");

    }
    public void specifico1() {
        System.out.println("Oracle CloseConnection");

    }
}
