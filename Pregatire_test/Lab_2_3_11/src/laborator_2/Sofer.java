package laborator_2;
import java.util.Random;

public class Sofer extends Persoana implements IAngajat{
    Random randomID=new Random();
    private int ID;
    private double salariu;
    private final int MaxID=999;
    private final int MaxNrOreLucrate=300;
    private final int MaxNrKmParcursi=5000;
    private final double coeficientSalarial=1.0;
    private int nrKm;
    private int nrOreLucrate;
    public Sofer(){}
    public Sofer(String nume,String prenume){
       super(nume,prenume);
       setID();
    }
    public double CalculSalariu(){
        salariu=15*coeficientSalarial*nrOreLucrate+(nrKm*0.1);
        return salariu;
    }
    @Override
    public void setNrOreLucrate(int nrOreLucrate) {
        this.nrOreLucrate=Math.max(nrOreLucrate,0);
        this.nrOreLucrate=Math.min(nrOreLucrate,MaxNrOreLucrate);
    }

    @Override
    public double salariu() {
        return salariu;
    }

    @Override
    public String toString() {
        return "Sofer "+this.getNume() + " " +this.getPrenume() +" a lucrat "+this.getNrOre()+", a parcurs "+this.getNrKm()+" km "+" - salariu= "+this.CalculSalariu();
    }

    public int getNrKm() {return nrKm;}
    public void setNrKm(int nrKm) {
        this.nrKm=Math.max(nrKm,0);
        this.nrKm=Math.min(nrKm,MaxNrKmParcursi);
    }
    public int getNrOre() {return nrOreLucrate;}
    public void setNrOre(int nrOre) {this.nrOreLucrate = nrOre;}
    public int getID(){return ID;}
    public void setID(){
        this.ID=Math.max(randomID.nextInt(MaxID),0);
        this.ID=Math.min(randomID.nextInt(MaxID),MaxID);
    }
}
