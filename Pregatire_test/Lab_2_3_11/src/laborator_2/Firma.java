package laborator_2;
import java.io.*;
import java.util.Scanner;

public class Firma {
    public static File file1 = new File("date.txt");
    public static void main(String[] args) {



        Inginer ing1 = new Inginer("Barbulescu", "Tudor");
        Inginer ing2 = new Inginer("Trestie", "Tudor");
        Sofer sof1 = new Sofer("Repede", "Paul");

        ing1.setNrOreLucrate(100);
        ing2.setNrOreLucrate(200);
        sof1.setNrOreLucrate(250);
        sof1.setNrKm(1000);

        String id=Integer.toString(ing1.getID());
        try {
            FileWriter writer = new FileWriter(file1);
            writer.write(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
