//> Solutie Problema 5
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Poligon {
    private double pointX;
    private double pointY;
    public void setPointX(int x){
        this.pointX=x;
    }
    public double getX(){
        return pointX;
    }
    public double getY(){
        return pointY;
    }
    public Poligon(){
        pointY=pointX=0;
    }
    public void setPointY(int y){
        this.pointY=y;
    }
    public String toString(){
        return pointX + " " +pointY;
    }
    public void Perimetru(){

    }
    public static void main(String[] args){
        Poligon[] p=new Poligon[10];
        double perimetru=0;
        int linecounter=0;
        for(int i=0;i<10;i++){
            p[i]=new Poligon();
        }
        try {
            File datePoligon = new File("date.txt");
            Scanner scanner = new Scanner(datePoligon);
            while(scanner.hasNext()){
                linecounter++;
                if(linecounter==1)
                    scanner.nextLine();
                else {
                    int textPointX=scanner.nextInt();
                    int textPointY=scanner.nextInt();
                    p[linecounter].setPointX(textPointX);
                    p[linecounter].setPointY(textPointY);
                    System.out.println("Varful "+(linecounter-1)+" cu coordonatele "+p[linecounter].toString());
                }
            }
        }
        catch(FileNotFoundException e){
        }
        for(int i=0;i<linecounter;i++)
            for(int j=i+1;j<linecounter;j++){
                perimetru+=Math.sqrt(Math.pow(p[i].getX()-p[j].getX(),2)+Math.pow(p[i].getY()-p[j].getY(),2));
            }
        System.out.println(perimetru);
    }
}
