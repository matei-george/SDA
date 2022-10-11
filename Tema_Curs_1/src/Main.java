class Patrulater{
    public int lungime;
    public int latime;
    public Patrulater(int lungime,int latime){ // Cu parametrii
        this.latime=latime;
        this.lungime=lungime;
    }
    public Patrulater(){} // Implicit
    public int getAria() {
        return lungime*latime;
    }
    public void ToString(){
        if(lungime==latime)
            System.out.println("Patratul are lungimea "+lungime+" si latimea "+latime);
        else
            System.out.println("Dreptunghiul are lungimea "+lungime+" si latimea "+latime);
    }
}
class Gresie extends Patrulater{
    public int inaltime;
    public int codCuloare;
    public Gresie(int lungime,int latime,int inaltime,int codCuloare){
        this.lungime=lungime;
        this.latime=latime;
        this.inaltime=inaltime;
        this.codCuloare=codCuloare;
    }
    public int getVolum(){
        return lungime*latime*inaltime;
    }
    public void ToString(){
        System.out.println("Placa de gresie are dimensiunile: "+lungime+" "+latime+" "+inaltime+" "+codCuloare);
    }
}
class DemoAplicatie{
    public static void main(String args[]){
        Patrulater d = new Patrulater(2,3);
        Patrulater p = new Patrulater(4,4);
        Gresie g = new Gresie(2,4,4,293);
        p.ToString();
        System.out.println(p.getAria());
        System.out.println();
        d.ToString();
        System.out.println(d.getAria());
        System.out.println();
        g.ToString();
        System.out.println(g.getVolum());
    }
}