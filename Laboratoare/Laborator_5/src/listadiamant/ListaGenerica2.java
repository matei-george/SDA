package listadiamant;

public class ListaGenerica2<T> extends ListaGenerica<T>{
    public T eliminaPrimul(){
        T info = primul.getInfo();
        primul=primul.getUrm();
        if(primul==null)
            return null;
        if(primul.getUrm()==null)
            primul=ultimul=null;
        return info;
    }
    public T eliminaUltimul()
   {
        if (ultimul == null) return null;
            elementCounter--;
         T info = ultimul.getInfo();
        if(ultimul.getUrm()==null) {
           primul=ultimul=null;
           return info;
       }
       ultimul = (Element<T>) ultimul.getInfo();
       return info;
    }


}
