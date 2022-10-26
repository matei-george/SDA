package magazin;

import cutii.TipCutie;
import jucarii.Avion;
import jucarii.Jucarie;
import cutii.iCutie;
import jucarii.Minge;
import jucarii.Racheta;

public class Pachet{
    private iCutie cutie;
    private Jucarie jucarie;
    private double lungimePanglica;
    private boolean cereCutie;
    private boolean cerePanglica;
    @Override
    public String toString() {
        return "Pachet [ " +
                "jucarie= " + jucarie.toString() +
                " ,cutie= "+cutie+
                " ,lungime panglica= " + lungimePanglica+
                " ] ";
    }
    public Pachet(Jucarie jucarie,boolean cereCutie,boolean cerePanglica){
        this.jucarie=jucarie;
        this.cereCutie=cereCutie;
        this.cerePanglica=cerePanglica;
    }
    public double pretPachet(){
        if(jucarie.getTipCutie()==TipCutie.CILINDRU)
            jucarie.getPret();
        if(jucarie.getTipCutie()==TipCutie.PARALELIPIPED)
            jucarie.getPret();
        if(jucarie.getTipCutie()==TipCutie.CUB)
            jucarie.getPret();
        return jucarie.getPret();
    }
    public static void main(String[] args){
        System.out.println("\n===== Demo Pachet (1p) =====");
        Pachet p1 = new Pachet(new Minge(10), true, true);
        System.out.println(p1);
        System.out.println("Pret="+p1.pretPachet());

        Pachet p2 = new Pachet(new Avion(150), true, true);
        System.out.println(p2);
        System.out.println("Pret="+p2.pretPachet());

        Pachet p3 = new Pachet(new Racheta(300), true, true);
        System.out.println(p3);
        System.out.println("Pret="+p3.pretPachet());

    }
}
