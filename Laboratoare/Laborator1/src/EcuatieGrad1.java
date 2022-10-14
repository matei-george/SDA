//> Solutie Problema 3
public class EcuatieGrad1 {
    private int a;
    private int b;
    public EcuatieGrad1(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int getA() {
        return a;
    }
    public int getB() {
        return b;
    }
    public void setA(int a) {
        this.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }
    public int rezolva(){
       int x=-b/a;
       return x;
    }
    @Override
    public String toString() {
        return a+"x+"+b+"=0";
    }
    public static void main(String[] args){
        EcuatieGrad1 e1=new EcuatieGrad1(2,4);
        System.out.println(e1.toString());
        System.out.println(e1.rezolva());
    }
}
