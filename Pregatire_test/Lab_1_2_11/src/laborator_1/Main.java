package laborator_1;

import java.io.File;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("=======ECUATIE GRAD 1=========");
        EcuatieGrad1 ec1=new EcuatieGrad1(2,5);
        System.out.println(ec1.toString());
        System.out.println(ec1.rezolva());
        System.out.println();

        System.out.println("=======CLASA PUNCT=========");
        Punct p1=new Punct(2,3);
        Punct p2=new Punct(4,5);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.distanta(p1,p2));
        System.out.println();

        System.out.println("=======CLASA POLIGON=========");
        Poligon pol1=new Poligon();
        System.out.println(pol1.perimetru());
    }
}
