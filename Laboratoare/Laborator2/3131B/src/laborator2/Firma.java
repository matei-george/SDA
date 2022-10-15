package laborator2;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Firma extends CalculSalarii{
    public static void main(String[] args) {
        Inginer ing1=new Inginer("Barbulescu","Barbu");
        Inginer ing2=new Inginer("Trestie","Tudor");
        Sofer sof1=new Sofer("Repede","Paul");

        ing1.setNrOreLucrate(100);
        ing2.setNrOreLucrate(200);

        sof1.setNrOreLucrate(250);
        sof1.setKmParcursi(1000);


        File fisier = new File("pontaj.txt");
        try {

            FileWriter writer = new FileWriter("pontaj.txt");
            writer.write(ing1.getOreLucrateInginer()+" ");
            writer.write(ing2.getOreLucrateInginer()+" ");
            writer.write(sof1.getOreLucrateSofer()+" ");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error ocurred while writing to the file.");
            e.printStackTrace();
        }
        try{
            Scanner scanner=new Scanner(fisier);
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }catch(IOException e){
            System.out.println("An error ocurred while reading from the file.");
            e.printStackTrace();
        }
    }
}
