package model;

public class MySqlConnection implements DBConnection{

    @Override
    public void open() {
        System.out.println("MySql OpenConnection");

    }

    @Override
    public void close() {
        System.out.println("MySql OpenConnection");

    }
    public void specifico2() {
        System.out.println("MySql specifico2");

    }
}
