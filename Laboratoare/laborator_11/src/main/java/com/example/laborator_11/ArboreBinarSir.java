package com.example.laborator_11;
import java.util.Objects;

public class ArboreBinarSir<E> {
    private StringBuilder sir = new StringBuilder();
    private int nrst = 0;
    private int nrdr = 0;

    public void setNrst(int nrst) {
        this.nrst = nrst;
    }

    public void setNrdr(int nrdr) {
        this.nrdr = nrdr;
    }

    public int getNrst() {
        return nrst;
    }

    public int getNrdr() {
        return nrdr;
    }

    public int Nivele() {
        if (getNrdr() > getNrst()) {
            setNrdr(getNrdr());
            return nrdr;
        } else {
            setNrst(getNrst());
            return nrst;
        }
    }

    static class Nod<E> {
        private E info;
        private Nod<E> stg;
        private Nod<E> dr;

        Nod(E info) {
            this.info = info;
            stg = null;
            dr = null;
        }

        private boolean esteFrunza() {
            return stg == null && dr == null;
        }

        @Override
        public String toString() {
            return info.toString();
        }
    }

    private Nod<E> radacina = null;

    public boolean isEmpty() {
        return radacina == null;
    }

    // ================================================
// inserarea unor chei in arbore
// ================================================
    public boolean add(E val) {
        if (isEmpty()) {
            radacina = new Nod<>(val);
            return true;
        } else
            return addRecursiv(radacina, val);
    }

    //
    // daca E nu este Comparable se lanseaza exceptia ClassCastException
    //
    public boolean addRecursiv(Nod<E> nodcrt, E val) {
        if (Objects.equals(nodcrt.info, val)) {
            return false;
        }
        int ok;
        if (((Comparable) val).compareTo(nodcrt.info) < 0) {
            // val este mai mica decat ce se gaseste in nodcrt
            ok = 1;
            if (nodcrt.stg != null) {
                return addRecursiv(nodcrt.stg, val);
            } else {
                nodcrt.stg = new Nod<>(val);
            }
        } else {
            // val este mai mare decat ce se gaseste in nodcrt
            ok = 0;
            if (nodcrt.dr != null)
                return addRecursiv(nodcrt.dr, val);
            else
                nodcrt.dr = new Nod<>(val);
        }
        if (ok == 1)
            nrst++;
        else
            nrdr++;
        return true;
    }

    //cautarea unei chei in arbore
    public boolean contains(E val) {
        return !isEmpty() && containsRecursiv(radacina, val);
    }

    private boolean containsRecursiv(Nod<E> nodcrt, E val) {
        if (nodcrt == null)
            return false;
        if (Objects.equals(nodcrt.info, val))
            return true;
        if (((Comparable) val).compareTo(nodcrt.info) < 0) {
            // se cauta in subarborele stang
            return containsRecursiv(nodcrt.stg, val);
        } else {
            // se cauta in sbarborele drept
            return containsRecursiv(nodcrt.dr, val);
        }
    }

// Utilizarea tranversarilor ale arborelui in ordine
    public String SRD(){
        sir.delete(0,sir.length());

        SRDrec(radacina);
        System.out.println();
        return sir.toString();
    }
    void SRDrec (Nod<E> x){
        if(x==null) return;
        SRDrec ( x.stg); //S...
        // System.out.print(x +" "); //R
        sir.append(x);
        sir.append(" ");
        SRDrec ( x.dr); //D
    }
    public String RSD(){
        sir.delete(0,sir.length());
        RSDrec(radacina);
        System.out.println();
        return sir.toString();
    }
    void RSDrec (Nod<E> x){
        if(x==null) return;
        //System.out.print(x +" "); //R
        sir.append(x);
        sir.append(" ");
        RSDrec ( x.stg ); //S...
        RSDrec ( x.dr ); //D
    }
    public String SDR(){
        sir.delete(0,sir.length());
        SDRrec(radacina);
        System.out.println();
        return sir.toString();
    }
    void SDRrec (Nod<E> x){
        if(x==null) return;
        SDRrec ( x.stg); //S
        SDRrec ( x.dr); //D
        // System.out.print(x +" "); //R
        sir.append(x);
        sir.append(" ");
    }



    public int size(){
        return sizeRecursiv(radacina);
    }
    private int sizeRecursiv(Nod<E> x) {
        if(x==null) return 0;
        return 1+ sizeRecursiv ( x.stg) + sizeRecursiv ( x.dr);
    }
    private boolean gasit;
    public boolean removeRec(E val) {
        gasit = false;
        // este posibil ca radacina sa fie eliminata
        radacina = removeRecursiv(radacina, val);
        return gasit;
    }
    private Nod<E> removeRecursiv(Nod<E> nodcrt, E val) {
        if (nodcrt == null) {
            return null;
        }
        if(!Objects.equals(nodcrt.info, val)) {
            // val nu este in nodul curent (nodcrt)
            if (((Comparable)val).compareTo(nodcrt.info) < 0) {
                // nodul de eliminat poate fi in subarb. stang
                nodcrt.stg = removeRecursiv(nodcrt.stg, val);
            } else {
                // nodul de eliminat poate fi in subarb. drept
                nodcrt.dr = removeRecursiv(nodcrt.dr, val);
            }
        } else { // info == val
            // s-a gasit nodul ce trebuie eliminat
            gasit = true;
            if (nodcrt.stg == null && nodcrt.dr == null) {
                // Cazul 1) este un nod frunza => va fi eliminat
                return null;
            }
            // nu este frunza! Are 1 sau 2 fii
            if (nodcrt.dr == null) {
                // Cazul 2') are un singur fiu, cel din stanga
                // acesta ii va lua locul
                return nodcrt.stg;
            }
            if (nodcrt.stg == null) {
                // Cazul 2") are un singur fiu, cel din dreapta
                // acesta ii va lua locul
                return nodcrt.dr;
            }
            //
            // Cazul 3) are 2 fii; va fi eliminat cel mai mic nod care
            // este in acelasi timp mai mare decat val
            //
            E valMin = firstRecursiv ( nodcrt.dr );
            nodcrt.info = valMin; // valMin > val deoarece s-a cautat la dr.
            // valMin se pune in nodul eliminat
            // apoi se testRemove nodul cu valMin
            nodcrt.dr = removeRecursiv(nodcrt.dr, valMin);
        }
        return nodcrt;
    }
    // ================================================
// returneaza cea mai mica cheie din arbore (prima)
// ================================================
    public E first(){
        return isEmpty() ? null : firstRecursiv(radacina);
    }
    private E firstRecursiv(Nod<E> nodcrt) {
        return nodcrt.stg==null ? nodcrt.info :
                firstRecursiv( nodcrt.stg );
    }
    // ==========================================================
// remove – iterativ cu arg. cf. interfetei Set
//
// apeleaza 2 functii:
// - E eliminaMinDreapta(Nod<E> radv)
// - void conecteazaLaSuper(Nod<E> bunic, Nod<E> nepot, E val)
    public boolean remove(Object element){
        if (radacina == null)
            return false;
        E val = (E) element;
        Nod<E> tata = null;
        Nod<E> nodcrt = radacina;
//
// cauta daca este vreun nod continand valoarea val
//
        while (nodcrt != null && ! Objects.equals(nodcrt.info, val)) {
            tata = nodcrt;
            if (((Comparable)val).compareTo(nodcrt.info) < 0) {
                nodcrt = nodcrt.stg;
            } else {
                nodcrt = nodcrt.dr;
            }
        }
        if (nodcrt==null)
            return false; // val nu e in arbore
        //
        // nodcrt contine valoarea cautata (val)
        //
        if(nodcrt.esteFrunza())
            conecteazaLaSuper(tata, null, val);
        else if (nodcrt.stg==null)
            conecteazaLaSuper(tata, nodcrt.dr, val);
        else if (nodcrt.dr==null)
            conecteazaLaSuper(tata, nodcrt.stg, val);
        else {
            // nodcrt are 2 fii
            // se va cauta nodul x cu cea mai mica valoare din partea dreapta
            // a nodului nodcrt;
            // x.info va fi pusa in nodcrt.info apoi x va fi sters
            nodcrt.info = eliminaMinDreapta ( nodcrt );
        }
        return true;
    }
    private E eliminaMinDreapta(Nod<E> radv) {
        //
        // cauta nodul 'nod' care contine cea mai mica valoare
        // din subarborele cu radacina radv
        // nodul 'nod' va fi eliminat functia returneaza nod.info
        // Obs. 'radv' contine valoarea ce trebuie eliminata din arb.
        // In radv se va memora valoarea returnata de functie.
        //
        Nod<E> tata = radv;
        Nod<E> nod = radv.dr;
        // se cauta cel mai mic element din subarborele
        // cu radacina radv (nodul cel mai din stanga)
        while ( nod.stg != null ) {
            tata = nod;
            nod = nod.stg;
        }
        // nod este nodul cu cea mai mica valoare; va fi scos din arbore
        if( tata==radv )
            radv.dr = nod.dr; // nod este chiar radv
        else
            tata.stg = nod.dr;
        return nod.info;
    }
    private void conecteazaLaSuper(Nod<E> bunic, Nod<E> nepot, E val) {
        // bunic va fi legat de nepot ca fiu dr. sau stg.
        // functie de cum este val fata de bunic.info
        // (in acest fel ‘tatal’ este eliminat din arbore)
        //
        if( bunic != null ) {
            // se determina unde va fi conectat la dr sau stg
            if (((Comparable)val).compareTo(bunic.info) < 0)
                bunic.stg = nepot;
            else
                bunic.dr = nepot;
        } else {
            // bunic=null => ‘tatal’ este chiar radacina arborelui
            // elimnand ‘tatal’ 'nepotul' devine radacina
            //
            radacina = nepot;
        }
    }
    // ================================================================
// verificarea metodelor add(), contains(), first(), SRD() si RSD()
// ================================================================
    private void testRemove (E el) {
        if (!remove(el)) {
            System.out.println("remove: "+ el + " nu s-a gasit in arbore");
        } else {
            if(contains(el))
                System.out.println("*** Eroare: remove(" + el+") nereusit!");
            else
                System.out.print("Executat remove ( " + el + " )\nSRD: ");
            SRD();
        }
        System.out.print("RSD: ");
        RSD();
    }
    private static ArboreBinarSir<Integer> initArbore (int [] chei) {
        ArboreBinarSir<Integer> arb = new ArboreBinarSir<>();
        for(int x: chei)
            arb.add( x );
        System.out.print("initArbore SRD: ");
        arb.SRD();
        return arb;
    }
    private static void removeTestChei (int[] chei, boolean initArbRepetat){
        ArboreBinarSir<Integer> tst = initArbore( chei );
        for(int x: chei) {
            System.out.println("se incearca remove ("+x+")");
            tst.testRemove( x );
            if( initArbRepetat )
                tst = initArbore( chei );
        }
    }
    public static void main(String[] args) {
        int[] chei = new int[]{6, 5, 8, 9, 7, 3, 4, 5 };
        ArboreBinarSir<Integer> arb = new ArboreBinarSir<>();
        System.out.print("SRD: ");
        arb.SRD();
        System.out.println("first = " + arb.first());
        System.out.println("size="+ arb.size());
        arb = initArbore( chei );
        //arb.add(System.in); //java.lang.ClassCastException
        // pt. ca nu e Comparable (s-a facut ArboreBinarDeCautare<Object>)
        System.out.print("\nIntroducere arb.: ");
        System.out.print("SRD: ");
        arb.SRD();
        System.out.print("RSD: ");
        arb.RSD();
        arb.testRemove(6);
        System.out.println("size="+ arb.size());
        System.out.println("first = " + arb.first());
        // test contains()
        for(int x: chei)
            System.out.println( x + (arb.contains( x )?"":" nu" )+ " este in arbore");
        System.out.println( 10 + (arb.contains( 10 )?"":" nu" )+ " este in arbore");
        ArboreBinarSir<Integer> arb1 = new ArboreBinarSir<>();
        arb1.add(30);
        arb1.add(20);
        arb1.add(40);
        System.out.print("\nRSD: ");
        arb1.SRD();
        arb1.testRemove(30);
        arb1.testRemove(40);
        arb1.testRemove(30);
        arb1.testRemove(20);
        removeTestChei ( chei, true );
        removeTestChei ( chei, false );
    }

  /*  int inaltimeArbore(Nod radacina)
    {
        if(radacina)
        {
            int inaltimeST
        }
    } */


}
