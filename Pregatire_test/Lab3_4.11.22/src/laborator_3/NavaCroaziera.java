package laborator_3;

public class NavaCroaziera extends Nava{
    private int nrPasageri;

    public NavaCroaziera(){}
    public NavaCroaziera(String nume,String pavilion,int nrPasageri){
        super(nume, pavilion);
        this.nrPasageri=nrPasageri;
    }

    @Override
    public String toString() {
        return "Nava Croaziera - nume= "+this.getNume()+", pavilion= "+this.getPavilion()+", nrPasageri= "+this.getNrPasageri();
    }

    public int getNrPasageri() {
        return nrPasageri;
    }

    public void setNrPasageri(int nrPasageri) {
        this.nrPasageri = nrPasageri;
    }
    public void utilizare(){
        System.out.println("Croaziere de lux");
    }
}
