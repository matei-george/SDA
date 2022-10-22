package laborator_3;

public class Cargou extends Nava{
    private int capacitateIncarcare;
    public Cargou(){}
    public Cargou(int capacitateIncarcare,String nume,String pavilion){
        super(nume,pavilion);
        this.capacitateIncarcare=capacitateIncarcare;
    }
    public void utilizare(){
        System.out.println("Nava Cargou.");
    }
    public int getCapacitateIncarcare(){return capacitateIncarcare;}
    @Override
    public String toString() {
        return "NavaCargou - nume=" +
                getNume() + ",pavilion=" + getPavilion() +
                ",capacitateIncarcare=" + getCapacitateIncarcare();
    }
}
