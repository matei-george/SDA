package magazin;

import cutii.TipCutie;
import cutii.iCutie;
import jucarii.Jucarie;

public class FabricaCutii extends Jucarie implements iCutie {

    public FabricaCutii(double l1, double l2, double l3) {
        super(l1, l2, l3);
    }

    @Override
    public TipCutie getTipCutie() {
        return null;
    }

    @Override
    public double getPret() {
        return 0;
    }

    @Override
    public double getSuprafataTotala() {
        return 0;
    }

    @Override
    public double getLungimePanglica() {
        return 0;
    }

    @Override
    public double pret() {
        return iCutie.super.pret();
    }
    public void getCutie(Jucarie jucarie){
        if(jucarie.getTipCutie()==TipCutie.PARALELIPIPED)
            jucarie.getTipCutie();
        if(jucarie.getTipCutie()==TipCutie.CUB)
            jucarie.getTipCutie();
        if(jucarie.getTipCutie()==TipCutie.CILINDRU)
            jucarie.getTipCutie();
    }
}
