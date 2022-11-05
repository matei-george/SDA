package laborator_2;

public class CalculSalarii {
    public static void main(String[] args){
        double totalsalarii=0;
        Inginer ing1=new Inginer("Barbulescu","Tudor");
        Inginer ing2=new Inginer("Trestie","Tudor");
        Sofer sof1=new Sofer("Repede","Paul");

        ing1.setNrOreLucrate(100);
        ing2.setNrOreLucrate(200);
        sof1.setNrOreLucrate(250);
        sof1.setNrKm(1000);

        System.out.println(ing1.toString());
        System.out.println(ing2.toString());
        System.out.println(sof1.toString());

        totalsalarii+=ing1.CalculSalariu();
        totalsalarii+=ing2.CalculSalariu();
        totalsalarii+= sof1.CalculSalariu();

        System.out.println("Total Salarii "+totalsalarii);
    }
}
