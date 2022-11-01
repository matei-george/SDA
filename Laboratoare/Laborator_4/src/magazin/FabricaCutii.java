package magazin;

import cutii.TipCutie;
import cutii.iCutie;
import jucarii.Jucarie;

public class FabricaCutii {
    public void getCutie(Jucarie jucarie){
        if(jucarie.getTipCutie()==TipCutie.PARALELIPIPED)
            jucarie.getTipCutie();
        if(jucarie.getTipCutie()==TipCutie.CUB)
            jucarie.getTipCutie();
        if(jucarie.getTipCutie()==TipCutie.CILINDRU)
            jucarie.getTipCutie();
    }
}
