package laborator_3;

public abstract class Nava {
    private String nume;
    private String pavilion;

    public Nava(String nume, String pavilion) {
        this.nume = nume;
        this.pavilion = pavilion;
    }
    public Nava(){nume="";pavilion="";}
    public String getNume(){return nume;}
    public String getPavilion(){return pavilion;}
    public void setNume(String nume){this.nume=nume;}
    public void setPavilion(String pavilion){this.pavilion=pavilion;}
    @Override
    public String toString() {
        return "Nava{" +
                "nume='" + nume + '\'' +
                ", pavilion='" + pavilion + '\'' +
                '}';
    }
    public void utilizare(){}
}
