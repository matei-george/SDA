package laborator_3;

public class Cargou extends Nava{
    private int capacitateIncarcare;

    public Cargou(){}
    public Cargou(String nume,String pavilion,int capacitateIncarcare){
        super(nume, pavilion);
        this.capacitateIncarcare=capacitateIncarcare;
    }
    public int getCapacitateIncarcare() {return capacitateIncarcare;}
    public void setCapacitateIncarcare(int capacitateIncarcare) {this.capacitateIncarcare = capacitateIncarcare;}
    public void utilizare(){
        System.out.println("Transport marfuri");
    }

    @Override
    public String toString() {
        return "Nava Cargou - nume= "+this.getNume()+", pavilion= "+this.getPavilion()+", capacitateIncarcare= "+this.getCapacitateIncarcare();
    }
}
