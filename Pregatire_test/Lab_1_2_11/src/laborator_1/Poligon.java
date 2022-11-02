package laborator_1;
import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Poligon extends Punct{
    //> Atribute
    Punct[] pvect=new Punct[10];

    private double rezultat=0;
    File File1=new File("D:\\Programare\\SDA\\Pregatire_test\\Lab_1_2_11\\src\\laborator_1\\date.txt");
    Scanner scanner=new Scanner(File1);
    private int Linecounter = 1;
    private double Perimetru;
    //> Constructor
    public Poligon() throws FileNotFoundException {
        super();
        for(int i=0;i< pvect.length;i++)
            pvect[i]=new Punct();
        while(scanner.hasNextLine()){
            if(Linecounter== 1)
                scanner.nextLine();
            else {
                double punctX=Double.parseDouble(String.valueOf(scanner.next()));
                double punctY=Double.parseDouble(String.valueOf(scanner.next()));
                pvect[Linecounter-1]=new Punct(punctX,punctY);
                System.out.println( "Poligon cu varful "+(Linecounter-1)+" : " + pvect[Linecounter-1].toString());
            }
            Linecounter++;
        }
    }
    //> Metode
    public String perimetru(){
        for(int i=0;i< Linecounter;i++) {
            rezultat+=pvect[i].distanta(pvect[i],pvect[i+1]);
        }
        return  "Perimetru " + rezultat;
    }
}
