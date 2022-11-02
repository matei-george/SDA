package laborator_1;
import java.lang.Math;

public class Punct {
    //> Atribute
    private double x;
    private double y;

    //> Constructori
    public Punct(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Punct(){}

    //> Getteri, Setteri si Metode
    public double getX() {return x;}
    public void setX(double x) {this.x = x;}
    public double getY() {return y;}
    public void setY(double y) {this.y = y;}

    @Override
    public String toString() {
       return "("+x+","+y+")";
    }
    public double distanta(Punct p, Punct q){
        return Math.sqrt(Math.pow(p.getX()-q.getX(),2)+Math.pow(p.getY()-q.getY(),2));
    }
}
