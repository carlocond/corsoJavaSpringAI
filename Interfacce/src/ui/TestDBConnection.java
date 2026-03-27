package ui;

import model.DBConnection;
import model.MySqlConnection;
import model.OracleConnection;

public class TestDBConnection {
    public static void main(String[] args) {

        DBConnection ref = new OracleConnection();
        ref.open();
        ref.close();
        if(ref instanceof OracleConnection) {
            ((OracleConnection)ref).specifico1();
        }

        ref = new MySqlConnection();
        ref.open();
        ref.close();
        if (ref instanceof MySqlConnection) {
            ((MySqlConnection)ref).specifico2();

        }
        metodo1(new OracleConnection());
        metodo1(new MySqlConnection());
        metodo2(new OracleConnection());
        //metodo2(new MySqlConnection());
    }

    // CASISTICA 1
    private static void metodo1(DBConnection x) {
        x.open();
        x.close();
    }
    private static void metodo2(OracleConnection x) {
        x.open();
        x.close();
    }
    //CASISTICA 2
    private static void metodo3(DBConnection x) {
        x.open();
        x.close();
        if (x instanceof OracleConnection) {
            ((OracleConnection)x).specifico1();
        }
    }
    private static void metodo4(OracleConnection x) {
        x.open();
        x.close();
        x.specifico1();

    }
}
