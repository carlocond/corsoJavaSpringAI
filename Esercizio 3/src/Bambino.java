public class Bambino {

    public static int numeroBambini;
    public String nome;
    public String cognome;
    public double altezza;

    public Bambino(String nome, String cognome, double altezza){
        this.nome = nome;
        this.cognome = cognome;
        this.altezza = altezza;
        numeroBambini++;
    }

    public static int getNumeroBambini() {
        return numeroBambini;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public String infoBimbo(){
        return "Nome: " + nome + "\n" +
                "Cognome: " + cognome + "\n" +
                "Altezza: " + altezza;
    }

    public void cresce(double centimetri){
        if (centimetri > 0){
            System.out.println("Il bambino e' cresciuto di " + centimetri + "cm!");
            altezza += centimetri;
        } else {
            System.out.println("Valore non valido");
        }
    }
}
