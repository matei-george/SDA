package laborator2;

public class Inginer extends Persoana implements Angajat {
    public Inginer(){}
    public Inginer(String nume,String prenume){
        super(nume,prenume);
    }
    @Override
    public String toString(){
        return "Inginer "+super.toString()+" a lucrat "+this.getOreLucrateInginer()+" - salariu= "+this.CalculSalariuInginer();
    }
    @Override
    public void setNrOreLucrate(int nrOreLucrate) {
        this.nrOreLucrate=Math.max(nrOreLucrate,0);
        this.nrOreLucrate=Math.min(nrOreLucrate,nrMaxOreLucrate);
    }
    @Override
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
