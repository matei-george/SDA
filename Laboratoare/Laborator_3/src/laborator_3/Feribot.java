package laborator_3;

public class Feribot extends NavaCroaziera{
    private int nrAuto;
    public Feribot(){}
    public Feribot(int nrAuto,int nrPasageri,String nume,String pavilion){
        super(nrPasageri,nume,pavilion);
        this.nrAuto=nrAuto;
    }
    public int getNrAuto(){return nrAuto;}
    @Override
    public String toString() {
        return "NavaFeribot - nume=" +
                getNume() + ",pavilion=" + getPavilion() +
                ",nrAuto" + getNrAuto();
    }
    public void utilizare(){
        System.out.println("Nava Feribot");
    }
}

