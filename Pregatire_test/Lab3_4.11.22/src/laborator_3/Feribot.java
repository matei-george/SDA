package laborator_3;

public class Feribot extends Nava{
        private int nrAuto;
        private int nrPasageri;
        public Feribot(){}
    public Feribot(String nume,String pavilion,int nrPasageri,int nrAuto){
            super(nume, pavilion);
            this.nrPasageri=nrPasageri;
            this.nrAuto=nrAuto;
    }
    public int getNrAuto() {return nrAuto;}
    public void setNrAuto(int nrAuto) {this.nrAuto = nrAuto;}
    public int getNrPasageri() {return nrPasageri;}
    public void setNrPasageri(int nrPasageri) {this.nrPasageri = nrPasageri;}
    public void utilizare(){
            System.out.println("Transport vehicule si pasageri");
    }

    @Override
    public String toString() {
        return "Nava Feribot - nume= "+this.getNume()+", pavilion= "+this.getPavilion()+", nrPasageri= "+this.getNrPasageri()+", nrAuto= "+this.getNrAuto();
    }
}
