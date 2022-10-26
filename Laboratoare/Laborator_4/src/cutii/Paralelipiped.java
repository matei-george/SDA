package cutii;
import java.lang.Math;

public class Paralelipiped implements iCutie{
    private double Lungime;
    private double Latime;
    private double Inaltime;
    @Override
    public double getSuprafataTotala() {
        return Lungime*Latime*Inaltime;
    }

    @Override
    public double getLungimePanglica() {
        return 2*(Lungime+Inaltime)+ 2*(Lungime+Latime)+iCutie.lnod;
    }
}
