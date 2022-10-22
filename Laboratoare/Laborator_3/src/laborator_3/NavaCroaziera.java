package laborator_3;

public class NavaCroaziera extends Nava{
    private int nrPasageri;
    public NavaCroaziera(int nrPasageri,String nume, String pavilion) {
        super(nume, pavilion);
        this.nrPasageri=nrPasageri;
    }
    public NavaCroaziera(){}
    public int getNrPasageri(){return nrPasageri;}
    public void utilizare(){
        System.out.println("Croaziere de lux");
    }
    @Override
    public String toString() {
        return "NavaCroaziera - nume=" +
                getNume() + ",pavilion=" + getPavilion() +
                ",nrPasageri=" + getNrPasageri();
    }
}
