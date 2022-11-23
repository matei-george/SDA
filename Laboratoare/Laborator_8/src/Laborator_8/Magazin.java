package Laborator_8;
import java.util.HashMap;
import java.util.Map;

public class Magazin {
    private Map<Integer, Produs> inventar = new HashMap<Integer, Produs>();

    public Magazin(Map<Integer, Produs> inventar) {this.inventar = inventar;}

    public Magazin() {}

    public int aprovizioneaza(int codProdus, int qa)
    {
        if(qa<0)
            qa=-qa;
        if(inventar.containsKey(codProdus))
        {
            inventar.get(codProdus).cantitate+=qa;
            return inventar.get(codProdus).cantitate;
        }
        else
            return -1;
    }

    public int aprovizioneaza(int codProdus,String denumire,int pret,int qa)
    {
        if(inventar.containsKey(codProdus))
            return -1;
        pret=Math.abs(pret);
        qa=Math.abs(qa);
        Produs p=new Produs(codProdus,denumire,pret,qa);
        inventar.put(p.getCodProdus(),p);
        return 0;
    }

    public int vanzare(int codProdus,int qv)
    {
        qv=Math.abs(qv);
        if(inventar.containsKey(codProdus))
        {
            Produs p=inventar.get(codProdus);
            int cv=p.getCantitate()-qv;
            p.setCantitate(Math.max(p.getCantitate()-qv,0));
            if(p.getCantitate()-qv>=0)
            {
                p.setCantitate(cv);
                return cv;
            }
            else {
                int cval = p.getCantitate();

                return cv;
            }
        }
        return 0;
    }

    public void situatieVanzari()
    {
        System.out.println("cod  denumire     pret   cantitateExist.   cantitateVanduta   valoareVanzari");
        for(Integer cod: inventar.keySet()) {
            Produs p = inventar.get(cod);
            System.out.println(p.toString());
        }
    }

    public float situatieProdus(int codProdus)
    {
        if(inventar.containsKey(codProdus))
        {
            Produs p=inventar.get(codProdus);
            System.out.println(p);
            return 0;
        }
        return 0;
    }
    public static void main(String[] args){
        Produs p1=new Produs(1,"Paine",5,100);
        Produs p2=new Produs(2,"Mere",3,500);
        Produs p3=new Produs(3,"Portocale",4,10);
        Map<Integer, Produs>inventar=new HashMap<Integer,Produs>();
        inventar.put(p1.getCodProdus(),p1);
        inventar.put(p2.getCodProdus(),p2);
        inventar.put(p3.getCodProdus(),p3);
        Magazin magazin=new Magazin(inventar);
        magazin.situatieVanzari();
        System.out.println("\n---Situatie Magazin dupa vanzari---");
        magazin.vanzare(p1.getCodProdus(),5 );
        magazin.situatieVanzari();
        System.out.println("\n---Situatie Magazin dupa aprovizionare---");
        magazin.aprovizioneaza(p1.getCodProdus(),50);
        magazin.situatieVanzari();
    }
}
