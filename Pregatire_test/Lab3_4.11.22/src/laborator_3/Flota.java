package laborator_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Flota {
    Nava[] nave=new Nava[10];
    private int nrNave=0;
    public Flota(){}
    public Flota(String numeFisier) throws FileNotFoundException {
        File fisier=new File(numeFisier);
        int linecounter=1;
        Scanner scanner=new Scanner(fisier);
        while(scanner.hasNextLine()){
            if(linecounter==1)
                scanner.nextLine();
            else {
                String filedata=scanner.nextLine();
                String arr[]=filedata.split(", ");
                String nume=arr[0];
                String pavilion=arr[1];
                String tip=arr[2];
                if(tip.equals("NavaCroaziera")){
                    int nrPasageri=Integer.parseInt(arr[3]);
                    NavaCroaziera n1=new NavaCroaziera(nume,pavilion,nrPasageri);
                    adaugaNava(n1);
                }
                if(tip.equals("Cargou")){
                    int capacitateIncarcare=Integer.parseInt(arr[3]);
                    Cargou n1=new Cargou(nume,pavilion,capacitateIncarcare);
                    adaugaNava(n1);
                }
                if(tip.equals("Feribot")){
                    int nrPasageri=Integer.parseInt(arr[3]);
                    int nrAuto=Integer.parseInt(arr[4]);
                    Feribot n1=new Feribot(nume,pavilion,nrPasageri,nrAuto);
                    adaugaNava(n1);
                }
            }
            linecounter++;
        }
    }
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<nrNave;i++){
            str.append(i+1).append(". ").append(nave[i].toString()).append('\n');
        }
        return str.toString();
    }
    public void utilizare(){
        System.out.println("Utilizare flota: ");
        for(int i=0;i<nrNave;i++){
            System.out.print(nave[i].getNume()+" - ");
            nave[i].utilizare();
        }
    }
    public void adaugaNava(Nava x){
        if(nrNave==nave.length){
            nave= Arrays.copyOf(nave,nave.length+10);
        }
        nave[nrNave++]=x;
    }
    public Nava[] getNave(){
        for(int i=0;i<nrNave;i++)
            System.out.println(nave[i].toString());
        return null;
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("======================Partea 1======================");
        Flota flota1= new Flota();
        NavaCroaziera sv = new NavaCroaziera("Suceava","RO",1000);
        System.out.print(sv + "\nUtilizare:");
        sv.utilizare();
        System.out.println();
        flota1.adaugaNava( sv);
        flota1.adaugaNava(new NavaCroaziera("Victoria","RO",5000));
        System.out.println(flota1);
        flota1.utilizare();
        System.out.println();

        System.out.println("======================Partea 2======================");
        Flota flota2=new Flota();
        NavaCroaziera sv1 = new NavaCroaziera("Suceava","RO",1000);
        flota2.adaugaNava( sv1);
        flota2.adaugaNava(new NavaCroaziera("Victoria","RO",5000));
        flota2.adaugaNava(new Feribot("Marcel","BG",5000,250));
        flota2.adaugaNava(new Cargou("Ion","RO",15000));
        System.out.println(flota2);
        flota2.utilizare();
        System.out.println();

        System.out.println("======================Partea 3======================");
        Flota flota3 = new Flota("flota.txt");
        System.out.println(flota3);
        flota3.utilizare();
        System.out.println();
    }
}
