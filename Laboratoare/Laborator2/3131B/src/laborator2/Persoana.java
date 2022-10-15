package laborator2;

public class Persoana {
    Persoana(){}
    private String nume;
    private String prenume;
    Persoana(String nume, String prenume){
        this.nume=nume;
        this.prenume=prenume;
    }
    public String getNume() {
        return nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public String toString(){
        return nume+" "+prenume;
    }
}
