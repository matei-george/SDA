package Laborator_8;
import java.util.Formatter;
import java.util.Locale;

public class Produs {
    public int codProdus,pret,cantitate;
    public String denumire;

    //Ctori
    public Produs(){}
    public Produs(int codProdus, String denumire,int pret,int cantitate) {
        this.codProdus = codProdus;
        this.pret = pret;
        this.cantitate = cantitate;
        this.denumire = denumire;
    }

    //Getteri si Setteri
    public void setCodProdus(int codProdus) {
        this.codProdus = codProdus;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getCodProdus() {
        return codProdus;
    }

    public int getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public String getDenumire() {
        return denumire;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        Formatter formatter=new Formatter(sb, Locale.US);
        formatter.format("%2d\t%-15s %2d %10d",codProdus,denumire,pret,cantitate);
        return formatter.toString();
    }
}
