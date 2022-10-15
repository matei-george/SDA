package laborator2;

public class CalculSalarii{
    public static void main(String args[]){
        Inginer ing1=new Inginer("Barbulescu","Barbu");
        Inginer ing2=new Inginer("Trestie","Tudor");
        Sofer sof1=new Sofer("Repede","Paul");

        ing1.setNrOreLucrate(100);
        ing2.setNrOreLucrate(200);

        sof1.setNrOreLucrate(250);
        sof1.setKmParcursi(1000);

        System.out.println(ing1.toString());
        System.out.println(ing2.toString());
        System.out.println(sof1.toString());
        
        double TotalSalarii=ing1.salariu()+ing2.salariu()+ sof1.salariu();
        System.out.println("Total salarii = "+TotalSalarii);

    }
}