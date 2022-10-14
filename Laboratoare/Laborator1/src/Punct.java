//> Solutie Problema 4
public class Punct {
    private double x;
    private double y;

    public double getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Punct(double x,double y){
        this.x=x;
        this.y=y;
    }
    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
    public double distanta(Punct p) {
        return Math.sqrt(Math.pow((p.x-x),2)+Math.pow((p.y-y),2));
    }
    public static void main(String[] args){
        Punct p1=new Punct(2,3);
        Punct p2=new Punct(3,4);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.distanta(p2));
    }
}
