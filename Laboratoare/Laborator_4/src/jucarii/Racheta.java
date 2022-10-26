package jucarii;

import cutii.TipCutie;

public class Racheta extends Jucarie{
    private double pretRacheta=120;
    public Racheta(double pretRacheta) {
        super();
        this.pretRacheta=pretRacheta;
    }
    @Override
    public TipCutie getTipCutie() {
        return TipCutie.CILINDRU;
    }
    @Override
    public double getPret() {
        return pretRacheta;
    }
    @Override
    public String toString() {
        return "Racheta" +
                " ,cutie recomandata : "+ getTipCutie();
    }
}
