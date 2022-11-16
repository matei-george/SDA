package laborator7;
import java.util.Random;

public class Student extends Persoana {
    Random r=new Random();
    private float medieAdmitere;
    private Facultate facultate;
    @Override
    public String toString() {
        return "stud. " +super.toString()+", " + medieAdmitere + ", " + facultate;
    }
    public Student(String nume, Gen gen, float medieAdmitere, Facultate facultate) {
        super(nume,gen);
        this.medieAdmitere = medieAdmitere;
        this.facultate = facultate;
    }
    public Student(){
        super();
        this.medieAdmitere=r.nextFloat(5,10);
        this.facultate=Facultate.getFacultate(r.nextInt(0,Facultate.nrFacultati));
    }
    public float getMedieAdmitere() {
        return medieAdmitere;
    }
    public Facultate getFacultate() {
        return facultate;
    }
// clasa mai trebuie completata si cu altele pentru
// ca aplicatia sa poata functiona asa cum s-a cerut
}