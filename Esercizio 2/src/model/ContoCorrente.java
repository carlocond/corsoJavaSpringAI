package model;

public class ContoCorrente {

    private String numeroConto;
    private float saldo;
    private Banca banca;

    public ContoCorrente(String numeroConto, float saldo, Banca banca){
        this.numeroConto = numeroConto;
        this.saldo = saldo;
        this.banca = banca;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getBanca() {
        if (this.banca != null){
            return this.banca.getNome();
        } else {
            return "Nessuna banca associata";
        }
    }

    public void setBanca(Banca banca) {
        if (this.banca != null){
            this.banca.setNome(banca.getNome());
        }
    }

    public String descrizione(){
        String infoBanca = banca != null ? "\nBanca: " + banca.descrizione() : "";
        return "Numero conto: " + numeroConto +
                "\nSaldo: " + saldo + infoBanca;
    }

    public String getCittaBanca(){
        if (this.banca != null && this.banca.getIndirizzo() != null){
            return this.banca.getIndirizzo().getCitta();
        } else {
            return "Nessuna banca o indirizzo associato";
        }
    }

    public void setCittaBanca(String citta){
        if (this.banca != null && this.banca.getIndirizzo() != null){
            this.banca.getIndirizzo().setCitta(citta);
        }
    }
}
