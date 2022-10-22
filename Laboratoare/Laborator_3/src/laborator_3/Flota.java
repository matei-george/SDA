package laborator_3;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Flota{
    Nava[] nave=new Nava[10];
    private int nrNave=0;
    public Flota(){}
    public Flota(String numeFisier) {
        System.out.println("Flota:");
        File fisier = new File(numeFisier);
        int linecounter = 1;
        try {
            Scanner scanner = new Scanner(fisier);
            while(scanner.hasNextLine()){
                if(linecounter==1)
                    scanner.nextLine();
                else {
                    String filedata=scanner.nextLine();
                    String[] filedataArguments=filedata.split("[, ]+");
                    if(filedataArguments[2]=="NavaCroaziera")
                        new NavaCroaziera();
                    if(filedataArguments[2]=="NavaFeribot")
                        new Feribot();
                    if(filedataArguments[2]=="NavaCargou")
                        new Cargou();
                    System.out.println(filedata);
                }
                linecounter++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void adaugaNava(Nava x){
        if(nrNave==nave.length) {
            nave = Arrays.copyOf(nave, nave.length + 10);
        }
        nave[nrNave++]=x;
    }
    public Nava[] getNave(){
        for(int i=0;i<nrNave;i++)
            System.out.println(nave[i].toString());
        return null;
    }
    public void utilizare(){
        System.out.println("Utilizare Flota :");
        for(int i=0;i<nrNave;i++)
            nave[i].utilizare();
    }
    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<nrNave;i++){
            str.append(i+1).append(". ").append(nave[i].toString()).append('\n');
        }
        return str.toString();
    }
    public static void main(String[] args){
        // Punctul 1
        System.out.println("---------  Punctul 1   ----------");
        Flota flota1= new Flota();
        NavaCroaziera sv = new NavaCroaziera(1000, "Suceava", "RO");
        System.out.print(sv + "\nUtilizare:");
        sv.utilizare();
        System.out.println();

        // Punctul 2
        System.out.println("---------  Punctul 2   ----------");
        flota1.adaugaNava(sv);
        flota1.adaugaNava(new NavaCroaziera(5000, "Victoria", "RO"));
        flota1.adaugaNava(new Cargou(5000,"Marian","USV"));
        flota1.adaugaNava(new Feribot(30,300,"Tiberiu","USV"));
        System.out.println(flota1);
        flota1.utilizare();
        System.out.println();

        // Punctul 3
        System.out.println("---------  Punctul 3   ----------");
        Flota flota2=new Flota("flota.txt");
        System.out.println(flota2);
        flota2.utilizare();
    }



}
