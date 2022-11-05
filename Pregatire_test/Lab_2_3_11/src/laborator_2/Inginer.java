package laborator_2;
import java.util.Random;

public class Inginer extends Persoana implements IAngajat{
    Random randomId=new Random();
    private int ID;
    private final int MaxNrOre=250;
    private final int MaxID=999;
    private double salariu;
    private int nrOre;
    private final double coeficientSalarial=1.5;

    public Inginer(){}
    public Inginer(String nume,String prenume){
        super(nume, prenume);
        setID();
    }
    public double CalculSalariu(){
        salariu=salariuOrarMinim*coeficientSalarial*nrOre;
        return salariu;
    }
    @Override
    public void setNrOreLucrate(int nrOreLucrate) {
        this.nrOre = Math.max(nrOreLucrate,0);
        this.nrOre = Math.min(nrOreLucrate,MaxNrOre);
    }
    @Override
    public double salariu() {
        return salariu;
    }

    @Override
    public String toString(){
        return "Inginer "+this.getNume()+" "+this.getPrenume()+" a lucrat "+this.getNrOre()+" ore - salariu "+this.CalculSalariu();
    }
    public int getNrOre() {return nrOre;}
    public int getID(){return ID;}
    public void setID(){
        this.ID=Math.max(randomId.nextInt(MaxID),0);
        this.ID=Math.min(randomId.nextInt(MaxID),MaxID);
    }
}
