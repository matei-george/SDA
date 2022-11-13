package practice;

import org.w3c.dom.ls.LSOutput;

public class Zoo {
    public static void main(String[] args){
        Animal[] zoo=new Animal[4];
        zoo[0]=new Leu();
        zoo[1]=new Leu();
        zoo[2]=new Tigru();
        zoo[3]=new Leu();
        System.out.println("In gradina zoologica avem");
        for(int i=0;i<zoo.length;i++)
            System.out.println(zoo[i] + " ");
        System.out.println();
        for(Animal animal:zoo)
            animal.ceFace();
        System.out.println();
        // > Exemplu pentru toString din lang.Obj respectiv lang.Class

        // > [=== lang.Obj ===]
        //--> toString() = este o reprezentare sub format clasa@hexazecimal
        //--> getClass() = returneaza clasa obiectului (un obiect de tip Class)

        // > [=== lang.Class ===]
        //--> getName() = returneaza numele complet al clasei
        //--> getSimpleName() = returneaza numele clasei fara pachet

        Leu obj=new Leu();
        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getName());
        System.out.println(obj.getClass().getSimpleName());
        System.out.println();

        // > Când e necesară o interfață?
        // > Atunci când se dorește ascunderea structurii interne a unei clase.
        // > Numai interfața este făcută cunoscută.


        // > [=== Compararea obiectelor ===]
        //--> o1==o2 = verifica egalitatea referintelor
        //--> o1.equals(o2) = se ia in considerare egalitatea continutului obiectelor

        Leu l1=new Leu();
        Leu l2=new Leu();
        System.out.println(l1==l2);
        System.out.println(l1.equals(l2));

        // > [=== Compararea a 2 siruri ===]
        // > Sirurile in Java sunt imutabile (imposibil de modificat) din motive de securitate si management de memorie
        String s1="Abcde";
        String s2="Abc";
        System.out.println(s1.equals(s2));
        System.out.println(s1==s2);
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareToIgnoreCase(s2));
    }

}
