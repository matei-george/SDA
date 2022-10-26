package laborator_3;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Flota{
    Nava[] nave=new Nava[10];
    private int nrNave=0;
    public Flota(){}
    public Flota(String numeFisier) {
        File fisier = new File(numeFisier);
        int linecounter = 1;
        System.out.println("Flota:");
        try {
            Scanner scanner = new Scanner(fisier);
            while(scanner.hasNext()){
                if(linecounter==1)
                    scanner.nextLine();
                else {
                    String filedata=scanner.nextLine();
                    String arr[]= filedata.split(", ");
                    String nume=arr[0];
                    String pavilion=arr[1];
                    String tip=arr[2];
                    if(tip.equals("NavaCroaziera")){
                        int nrPasageri=Integer.parseInt(arr[3]);
                        NavaCroaziera nav1=new NavaCroaziera(nrPasageri,nume,pavilion);
                        adaugaNava(nav1);
                    }
                    if(tip.equals("Cargo")){
                        int capacitateIncarcare=Integer.parseInt(arr[3]);
                        Cargou car1=new Cargou(capacitateIncarcare,nume,pavilion);
                        adaugaNava(car1);
                    }
                    if(tip.equals("Feribot")){
                        int nrPasageri=Integer.parseInt(arr[3]);
                        int nrAuto=Integer.parseInt(arr[4]);
                        Feribot fer1=new Feribot(nrAuto,nrPasageri,nume,pavilion);
                        adaugaNava(fer1);
                    }
                }
                linecounter++;
            }
        }catch(FileNotFoundException e){
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
        for(int i=0;i<nrNave;i++){
            System.out.print(nave[i].getNume() + " - ");
            nave[i].utilizare();
        }
    }
    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<nrNave;i++){
            str.append(i+1).append(". ").append(nave[i].toString()).append('\n');
        }
        return str.toString();
    }
    // Punctul 4 incercare
    // TODO > Fix exception on punctul 4
    public boolean toStringFlota(boolean dupaNume){
        if(dupaNume==true)
            for(int i=0;i<nave.length;i++)
                Arrays.sort(nave[i].getNume().toCharArray());
        else
            for(int i=0;i<nave.length;i++)
                Arrays.sort(nave[i].getPavilion().toCharArray());
        return dupaNume;
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
        System.out.println();

        //Punctul 4
        System.out.println("---------  Punctul 4  ----------");
        flota2.toStringFlota(true);
        System.out.println(flota2);
        flota2.toStringFlota(false);
        System.out.println(flota2);
    }



}
