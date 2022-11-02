package laborator_1;

public class EcuatieGrad1 {
    private double a;
    private double b;

    //> Constructori
    public EcuatieGrad1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    //> Getteri, Setteri si Metode
    public double getA() {return a;}
    public void setA(double a) {this.a = a;}
    public double getB() {return b;}
    public void setB(double b) {this.b = b;}

    @Override
    public String toString() {
        return a+"*x"+"+"+b+" =0";
    }
    public String rezolva(){
        return "Rezultat = " + (-1*b)/a;
    }
}
