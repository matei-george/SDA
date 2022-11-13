package practice;

public class Animal {
    public void ceFace(){
        System.out.println(this + "face ce stie");
    }
    @Override
    public String toString(){
        return getClass().getName();
    }
}
