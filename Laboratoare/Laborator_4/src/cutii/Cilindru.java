package cutii;
import java.lang.Math;

public class Cilindru implements iCutie{
    private double Raza;
    @Override
    public double getSuprafataTotala() {
        return Math.PI*2*Raza;
    }

    @Override
    public double getLungimePanglica() {return 2*Math.PI+iCutie.lnod;}
}
