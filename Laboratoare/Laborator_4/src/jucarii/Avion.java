package jucarii;

import cutii.TipCutie;

public class Avion extends Jucarie{
    private String Tip="Avion";
    private double pretAvion=100;
    public Avion(double pretAvion) {
        super();
        this.pretAvion=pretAvion;
    }
    @Override
    public TipCutie getTipCutie() {
        return TipCutie.PARALELIPIPED;
    }
    @Override
    public double getPret() {
        return pretAvion;
    }
    public String getJucarie(){
        return Tip;
    }
    public String toString() {
        return "Avion" +
                " ,cutie recomandata : "+ getTipCutie();
    }
}
