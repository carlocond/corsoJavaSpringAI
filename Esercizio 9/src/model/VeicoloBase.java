package model;

public abstract class VeicoloBase implements Veicolo {

    private float velocitaMax;

    @Override
    public float getVelocitaMax() {
        return velocitaMax;
    }

    @Override
    public void setVelocitaMax(float velocitaMax) {
        this.velocitaMax = velocitaMax;
    }
}
