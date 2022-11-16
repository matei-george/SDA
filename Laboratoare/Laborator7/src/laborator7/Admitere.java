package laborator7;

import java.util.*;

public class Admitere {
    public void inmatriculeaza(int n){

    }
    public void afiseazaStudFacultate(){

    }

    public static void main(String[] args){
        int counter=0; // Counter pentru fiecare student
        int mCounter=0; // Counter pentru genul masculin
        int fCounter=0; // Counter pentru genul feminin


        SortedSet<String> reg_matricol= new TreeSet<String>();
        Map<String, Integer> reg_studenti = new TreeMap<String, Integer>();
        SortedSet<String> reg_gen=new TreeSet<String>();

        Student[] VectStudenti=new Student[10];

        // > Reprezentare puncte studenti cu sorted set
        System.out.println("//--------------------------- 1p ----------------------------------");
        Student s1=new Student("Dobrescu",Gen.F,8,Facultate.FIESC);
        reg_matricol.add(s1.toString());
        if(reg_matricol.contains(s1.toString()))
            System.out.println(s1.toString() + " *** student deja inscris in Registrul matricol\n");

        // > Verifica daca in SortedSet sunt inscrisi studenti existenti.
        for(int i=0;i<VectStudenti.length;i++)
        {
            VectStudenti[i]=new Student();
            if(reg_matricol.contains(VectStudenti[i].toString()))
                System.out.println(VectStudenti[i].toString() + " *** student deja inscris in Registrul matricol\n");
            reg_matricol.add(VectStudenti[i].toString());
        }
        System.out.println("//--------------------------- 1p ----------------------------------");
        System.out.println("Raport- total in registru " + reg_matricol.size()+ " studenti:\n");


        System.out.println("//--------------------------- 2p ----------------------------------");
        System.out.println("Primele 10 nr.matricole:");
        for(String student:reg_matricol)
            System.out.println(counter++ +". "+student);
        // Alt tip de foreach
        // reg_matricol.forEach(System.out::println);

        System.out.println("//--------------------------- 2p ----------------------------------");
        for(int i=0;i<VectStudenti.length;i++){
                reg_gen.add(VectStudenti[i].getGen().toString());
        }
        for(String gen:reg_gen)
            System.out.println(gen);
        System.out.println("Baieti: "+mCounter+"\n"+"Fete: "+fCounter);
      }
    }
