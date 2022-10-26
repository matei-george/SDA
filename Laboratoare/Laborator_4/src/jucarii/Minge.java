package jucarii;

import cutii.Cilindru;
import cutii.TipCutie;

public class Minge extends Jucarie{
    private double pretMinge=50;
    public Minge(double pretMinge) {
        super();
        this.pretMinge=pretMinge;
    }
    @Override
    public TipCutie getTipCutie() { return TipCutie.CUB;}
    @Override
    public double getPret() { return pretMinge; }

    @Override
    public String toString() {
        return "Minge" +
                " ,cutie recomandata : "+ getTipCutie();
    }
}
