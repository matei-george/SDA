package laborator2;

import java.util.Random;

public class Inginer extends Persoana{
    Random angajatID=new Random();
    public int LimitaID=999;
    private int tempRand=angajatID.nextInt(LimitaID);
    public int ID = tempRand;
    public static final double salariuOrarMinim=15;
    public Inginer(){}
    public Inginer(String nume,String prenume){
        super(nume,prenume);
    }
    @Override
    public String toString(){
        return "Inginer "+super.toString()+" a lucrat "+this.getOreLucrateInginer()+" - salariu= "+this.CalculSalariuInginer();
    }
    public void setNrOreLucrate(int nrOreLucrate) {
        this.nrOreLucrate=Math.max(nrOreLucrate,0);
        this.nrOreLucrate=Math.min(nrOreLucrate,nrMaxOreLucrate);
    }
    public double salariu() {return salariu;}
    public double CalculSalariuInginer(){
        salariu=15*coeficientSalarial*nrOreLucrate;
        return salariu;
    }
    public int getOreLucrateInginer(){return nrOreLucrate;}

    private static final int nrMaxOreLucrate=250;
    private int nrOreLucrate;
    private double coeficientSalarial=1.5;
    private double salariu;
}
