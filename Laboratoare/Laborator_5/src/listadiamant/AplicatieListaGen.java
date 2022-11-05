package listadiamant;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Decanat1
 */
public class AplicatieListaGen {
    public static void main(String[] args) {
        ListaGenerica<String> lst = new ListaGenerica<>();
        lst.insertLaUrma("Bucuresti");
        lst.insertInFata("Suceava");
        lst.insertLaUrma("Iasi");
        System.out.println("Orasele din lista:" + lst);
        lst.eliminaToateElementele();
        for (int i = 0; i < 21; i++) {
            String o = Integer.toString(i); // o=""+i
            if (i % 2 != 0)
                lst.insertInFata(o);
            else
                lst.insertLaUrma(o);
        }
        System.out.println("Numerele din lsta:" + lst);
        System.out.print("Intregii din lsta x10: ");
        for (String el : lst) {
            System.out.print((Integer.valueOf(el) * 10) + ", ");
        }

        System.out.println();
        System.out.println("Lungimea listei este " + lst.size());
        System.out.println();

        System.out.println("================ Demo eliminaPrimul() ==================");
        ListaGenerica2<String> lst2 = new ListaGenerica2<>();
        for (int i = 0; i < 21; i++) {
            String o = Integer.toString(i); // o=""+i
            if (i % 2 != 0)
                lst2.insertInFata(o);
            else
                lst2.insertLaUrma(o);
        }
        for (int i = 0; i < lst2.size(); i++) {
            System.out.println("Numerele din lista" + '(' + (lst2.size() - i) + ") : " + lst2);
           //lst2.eliminaPrimul();
            lst2.eliminaUltimul();
        }
        System.out.println();
    }
}