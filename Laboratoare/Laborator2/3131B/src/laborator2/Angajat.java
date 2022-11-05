package laborator2;
import java.util.Random;

public interface Angajat {
    Random angajatID=new Random();
    public int LimitaID=999;
    public int ID = 0;
    public static final double salariuOrarMinim=15;
    public void setNrOreLucrate(int nrOreLucrate);
    public double salariu();
    public int getAngajatdupaID(int ID);
}
