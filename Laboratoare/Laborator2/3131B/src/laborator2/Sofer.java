package laborator2;

public class Sofer extends Persoana implements Angajat{
    public Sofer() {}
    public Sofer(String nume,String prenume){
        super(nume,prenume);
    }
    @Override
    public String toString(){
       return "Sofer "+super.toString()+" a lucrat "+this.getOreLucrateSofer()+", a parcurs "+this.getKmParcursi()+" km "+" - salariu= "+this.CalculSalariuSofer();
    }
    @Override
    public void setNrOreLucrate(int nrOreLucrate) {
        this.nrOreLucrate=Math.max(nrOreLucrate,0);
        this.nrOreLucrate=Math.min(nrOreLucrate,nrMaxOreLucrate);
    }
    @Override
    public double salariu() {return salariu;}
    public void setKmParcursi(int kmParcursi){
        this.kmParcursi=Math.max(kmParcursi,0);
        this.kmParcursi=Math.min(kmParcursi,kmParcursiMax);
    }
    public double CalculSalariuSofer(){
        salariu=15*coeficientSalarial*nrOreLucrate+(kmParcursi*0.1);
        return salariu;
    }
    public int getOreLucrateSofer(){return nrOreLucrate;}
    public int getKmParcursi(){return kmParcursi;}

    private static final int nrMaxOreLucrate=300;
    private int nrOreLucrate;
    private double coeficientSalarial=1;
    private static final int kmParcursiMax=5000;
    private int kmParcursi;
    private double salariu;

}
