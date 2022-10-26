package cutii;
import java.lang.Math;

public class Cub implements iCutie{
    private double Lungime;
    @Override
    public double getSuprafataTotala() {return 6*Math.pow(Lungime,2);}

    @Override
    public double getLungimePanglica() {return 8*Lungime+iCutie.lnod;}
}
